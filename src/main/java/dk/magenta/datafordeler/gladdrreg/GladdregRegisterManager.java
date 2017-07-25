package dk.magenta.datafordeler.gladdrreg;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.magenta.datafordeler.core.exception.DataFordelerException;
import dk.magenta.datafordeler.core.exception.WrongSubclassException;
import dk.magenta.datafordeler.core.plugin.*;
import dk.magenta.datafordeler.core.util.ItemInputStream;
import dk.magenta.datafordeler.core.util.ListHashMap;
import dk.magenta.datafordeler.gladdrreg.configuration.GladdregConfigurationManager;
import dk.magenta.datafordeler.gladdrreg.data.CommonEntityManager;
import dk.magenta.datafordeler.gladdrreg.synchronization.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by lars on 16-05-17.
 */
@Component
public class GladdregRegisterManager extends RegisterManager {

    private HttpCommunicator commonFetcher;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GladdregConfigurationManager configurationManager;

    @Autowired
    private GladdregPlugin plugin;

    private Logger log = LogManager.getLogger("GladdregRegisterManager");

    public GladdregRegisterManager() {
        this.commonFetcher = new HttpCommunicator();
    }

    @PostConstruct
    public void init() {
        try {
            this.baseEndpoint = new URI(this.configurationManager.getConfiguration().getRegisterAddress());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Logger getLog() {
        return this.log;
    }

    @Override
    public Plugin getPlugin() {
        return this.plugin;
    }

    private URI baseEndpoint;

    @Override
    public URI getBaseEndpoint() {
        return this.baseEndpoint;
    }



    @Override
    protected Communicator getEventFetcher() {
        return this.commonFetcher;
    }

    @Override
    protected ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override
    protected URI getEventInterface(EntityManager entityManager) {
        return expandBaseURI(this.getBaseEndpoint(), "/getNewEvents");
    }

    @Override
    protected ItemInputStream<Event> parseEventResponse(InputStream responseContent, EntityManager entityManager) throws DataFordelerException {
        if (!(entityManager instanceof CommonEntityManager)) {
            throw new WrongSubclassException(CommonEntityManager.class, entityManager);
        }
        return ItemInputStream.parseJsonStream(responseContent, Event.class, "events", this.getObjectMapper());
    }

    @Override
    protected Communicator getChecksumFetcher() {
        return this.commonFetcher;
    }

    @Override
    public URI getListChecksumInterface(String schema, OffsetDateTime from) {
        ListHashMap<String, String> parameters = new ListHashMap<>();
        if (schema != null) {
            parameters.add("objectType", schema);
        }
        if (from != null) {
            parameters.add("timestamp", from.format(DateTimeFormatter.ISO_DATE_TIME));
        }
        return expandBaseURI(this.getBaseEndpoint(), "/listChecksums", RegisterManager.joinQueryString(parameters), null);
    }

    public String getPullCronSchedule() {
        return this.configurationManager.getConfiguration().getPullCronSchedule();
    }

}
