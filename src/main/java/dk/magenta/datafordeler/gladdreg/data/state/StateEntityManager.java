package dk.magenta.datafordeler.gladdreg.data.state;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.magenta.datafordeler.core.database.EntityReference;
import dk.magenta.datafordeler.core.database.Registration;
import dk.magenta.datafordeler.core.database.RegistrationReference;
import dk.magenta.datafordeler.core.exception.DataFordelerException;
import dk.magenta.datafordeler.core.exception.ParseException;
import dk.magenta.datafordeler.core.exception.WrongSubclassException;
import dk.magenta.datafordeler.core.fapi.FapiService;
import dk.magenta.datafordeler.core.io.Receipt;
import dk.magenta.datafordeler.core.plugin.Communicator;
import dk.magenta.datafordeler.core.plugin.EntityManager;
import dk.magenta.datafordeler.core.plugin.HttpCommunicator;
import dk.magenta.datafordeler.core.util.ItemInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by lars on 16-05-17.
 */
@Component
public class StateEntityManager extends EntityManager {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StateEntityService stateEntityService;

    private HttpCommunicator commonFetcher;

    protected Logger log = LogManager.getLogger("StateEntityManager");

    private Collection<String> handledURISubstrings;

    public StateEntityManager() {
        this.managedEntityClass = StateEntity.class;
        this.managedEntityReferenceClass = StateEntityReference.class;
        this.managedRegistrationClass = StateRegistration.class;
        this.managedRegistrationReferenceClass = StateRegistrationReference.class;
        this.commonFetcher = new HttpCommunicator();
        this.handledURISubstrings = new ArrayList<>();
        this.handledURISubstrings.add("http://localhost:8000/state");
        this.handledURISubstrings.add("http://localhost:8000/get/state");
    }

    @Override
    public Collection<String> getHandledURISubstrings() {
        return this.handledURISubstrings;
    }

    @Override
    protected ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    protected Communicator getRegistrationFetcher() {
        return this.commonFetcher;
    }

    @Override
    protected Communicator getReceiptSender() {
        return this.commonFetcher;
    }

    @Override
    public FapiService getEntityService() {
        return this.stateEntityService;
    }

    @Override
    public URI getBaseEndpoint() {
        //return expandBaseURI(this.getRegisterManager().getBaseEndpoint(), "/municipality");
        return this.getRegisterManager().getBaseEndpoint();
    }

    @Override
    protected URI getReceiptEndpoint(Receipt receipt) {
        return expandBaseURI(this.getBaseEndpoint(), "/receipt/" + receipt.getEventID());
    }

    @Override
    public RegistrationReference parseReference(InputStream referenceData) throws IOException {
        return this.objectMapper.readValue(referenceData, this.managedRegistrationReferenceClass);
    }

    @Override
    public RegistrationReference parseReference(String referenceData, String charsetName) throws IOException {
        return this.objectMapper.readValue(referenceData.getBytes(charsetName), this.managedRegistrationReferenceClass);
    }

    @Override
    public RegistrationReference parseReference(URI uri) {
        return new StateRegistrationReference(uri);
    }

    @Override
    public Registration parseRegistration(JsonNode registrationData) throws ParseException {
        if (registrationData.has("registrationFrom")) { // Check whether the object is wrapped
            // Unwrapped case
            try {
                return objectMapper.treeToValue(registrationData, this.managedRegistrationClass);
            } catch (JsonProcessingException e) {
                throw new ParseException("Error parsing registration "+registrationData);
            }
        } else {
            // Wrapped case
            Map<String, Registration> map = this.parseRegistrationList(registrationData);
            if (map.size() > 0) {
                return map.get(map.keySet().iterator().next());
            }
            return null;
        }
    }

    @Override
    public URI getRegistrationInterface(RegistrationReference reference) throws WrongSubclassException {
        if (!this.managedRegistrationReferenceClass.isInstance(reference)) {
            throw new WrongSubclassException(this.managedRegistrationReferenceClass, reference);
        }
        if (reference.getURI() != null) {
            return reference.getURI();
        }
        return EntityManager.expandBaseURI(this.getBaseEndpoint(), "/get/state/"+reference.getChecksum());
    }

    @Override
    protected URI getListChecksumInterface(OffsetDateTime fromDate) {
        return this.getRegisterManager().getListChecksumInterface(this.getSchema(), fromDate);
    }

    @Override
    protected ItemInputStream<? extends EntityReference> parseChecksumResponse(InputStream responseContent) throws DataFordelerException {
        return ItemInputStream.parseJsonStream(responseContent, this.managedEntityReferenceClass, "items", this.objectMapper);
    }

    @Override
    protected Logger getLog() {
        return this.log;
    }

}
