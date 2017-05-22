package dk.magenta.datafordeler.gladdreg;

import dk.magenta.datafordeler.core.configuration.ConfigurationManager;
import dk.magenta.datafordeler.core.plugin.Plugin;
import dk.magenta.datafordeler.core.plugin.RegisterManager;
import dk.magenta.datafordeler.gladdreg.data.district.DistrictEntity;
import dk.magenta.datafordeler.gladdreg.data.district.DistrictEntityManager;
import dk.magenta.datafordeler.gladdreg.data.municipality.MunicipalityEntity;
import dk.magenta.datafordeler.gladdreg.data.municipality.MunicipalityEntityManager;
import dk.magenta.datafordeler.gladdreg.configuration.GladdregConfigurationManager;
import dk.magenta.datafordeler.gladdreg.data.postalcode.PostalCodeEntity;
import dk.magenta.datafordeler.gladdreg.data.postalcode.PostalCodeEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by lars on 16-05-17.
 */
@Component
public class GladdregPlugin extends Plugin {

    @Autowired
    private GladdregConfigurationManager configurationManager;

    @Autowired
    private GladdregRegisterManager registerManager;

    @Autowired
    private MunicipalityEntityManager municipalityEntityManager;

    @Autowired
    private DistrictEntityManager districtEntityManager;

    @Autowired
    private PostalCodeEntityManager postalCodeEntityManager;

    @PostConstruct
    public void init() {
        this.registerManager.addEntityManager(this.municipalityEntityManager, MunicipalityEntity.schema);
        this.registerManager.addEntityManager(this.districtEntityManager, DistrictEntity.schema);
        this.registerManager.addEntityManager(this.postalCodeEntityManager, PostalCodeEntity.schema);
    }

    @Override
    public RegisterManager getRegisterManager() {
        return this.registerManager;
    }

    @Override
    public ConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }

}
