package dk.magenta.datafordeler.gladdreg.data.district;

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
public class DistrictEntityManager extends CommonEntityManager {

    @Autowired
    private DistrictEntityService districtEntityService;

    public DistrictEntityManager() {
        this.managedEntityClass = DistrictEntity.class;
        this.managedEntityReferenceClass = DistrictEntityReference.class;
        this.managedRegistrationClass = DistrictRegistration.class;
        this.managedRegistrationReferenceClass = DistrictRegistrationReference.class;
    }

    @Override
    protected String getBaseName() {
        return "district";
    }

    @Override
    public FapiService getEntityService() {
        return this.districtEntityService;
    }

    @Override
    public String getSchema() {
        return DistrictEntity.schema;
    }

    @Override
    protected RegistrationReference createRegistrationReference(URI uri) {
        return new DistrictRegistrationReference(uri);
    }

}
