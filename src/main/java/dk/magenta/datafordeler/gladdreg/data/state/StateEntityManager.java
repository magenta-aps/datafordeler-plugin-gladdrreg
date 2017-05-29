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
import dk.magenta.datafordeler.gladdreg.data.CommonEntityManager;
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
public class StateEntityManager extends CommonEntityManager {

    @Autowired
    private StateEntityService stateEntityService;

    public StateEntityManager() {
        super();
        this.managedEntityClass = StateEntity.class;
        this.managedEntityReferenceClass = StateEntityReference.class;
        this.managedRegistrationClass = StateRegistration.class;
        this.managedRegistrationReferenceClass = StateRegistrationReference.class;
    }

    @Override
    protected String getBaseName() {
        return "state";
    }

    @Override
    public FapiService getEntityService() {
        return this.stateEntityService;
    }

    @Override
    public RegistrationReference createRegistrationReference(URI uri) {
        return new StateRegistrationReference(uri);
    }

}
