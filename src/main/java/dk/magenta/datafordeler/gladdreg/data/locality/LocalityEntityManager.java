package dk.magenta.datafordeler.gladdreg.data.locality;

import dk.magenta.datafordeler.core.database.RegistrationReference;
import dk.magenta.datafordeler.core.fapi.FapiService;
import dk.magenta.datafordeler.gladdreg.data.CommonEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * Created by lars on 16-05-17.
 */
@Component
public class LocalityEntityManager extends CommonEntityManager {

    @Autowired
    private LocalityEntityService localityEntityService;

    public LocalityEntityManager() {
        this.managedEntityClass = LocalityEntity.class;
        this.managedEntityReferenceClass = LocalityEntityReference.class;
        this.managedRegistrationClass = LocalityRegistration.class;
        this.managedRegistrationReferenceClass = LocalityRegistrationReference.class;
    }

    @Override
    protected String getBaseName() {
        return "locality";
    }

    @Override
    public FapiService getEntityService() {
        return this.localityEntityService;
    }

    @Override
    public String getSchema() {
        return LocalityEntity.schema;
    }

    @Override
    protected RegistrationReference createRegistrationReference(URI uri) {
        return new LocalityRegistrationReference(uri);
    }

}
