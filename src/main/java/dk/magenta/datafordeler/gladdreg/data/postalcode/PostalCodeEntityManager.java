package dk.magenta.datafordeler.gladdreg.data.postalcode;

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
public class PostalCodeEntityManager extends CommonEntityManager {

    @Autowired
    private PostalCodeEntityService postalCodeEntityService;

    public PostalCodeEntityManager() {
        this.managedEntityClass = PostalCodeEntity.class;
        this.managedEntityReferenceClass = PostalCodeEntityReference.class;
        this.managedRegistrationClass = PostalCodeRegistration.class;
        this.managedRegistrationReferenceClass = PostalCodeRegistrationReference.class;
    }

    @Override
    protected String getBaseName() {
        return "postalcode";
    }

    @Override
    public FapiService getEntityService() {
        return this.postalCodeEntityService;
    }

    @Override
    protected RegistrationReference createRegistrationReference(URI uri) {
        return new PostalCodeRegistrationReference(uri);
    }

}
