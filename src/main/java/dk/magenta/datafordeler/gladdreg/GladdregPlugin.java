package dk.magenta.datafordeler.gladdreg;

import dk.magenta.datafordeler.core.configuration.ConfigurationManager;
import dk.magenta.datafordeler.core.plugin.Plugin;
import dk.magenta.datafordeler.core.plugin.RegisterManager;
import dk.magenta.datafordeler.gladdreg.data.bnumber.BNumberEntity;
import dk.magenta.datafordeler.gladdreg.data.bnumber.BNumberEntityManager;
import dk.magenta.datafordeler.gladdreg.data.district.DistrictEntity;
import dk.magenta.datafordeler.gladdreg.data.district.DistrictEntityManager;
import dk.magenta.datafordeler.gladdreg.data.locality.LocalityEntity;
import dk.magenta.datafordeler.gladdreg.data.locality.LocalityEntityManager;
import dk.magenta.datafordeler.gladdreg.data.municipality.MunicipalityEntity;
import dk.magenta.datafordeler.gladdreg.data.municipality.MunicipalityEntityManager;
import dk.magenta.datafordeler.gladdreg.configuration.GladdregConfigurationManager;
import dk.magenta.datafordeler.gladdreg.data.postalcode.PostalCodeEntity;
import dk.magenta.datafordeler.gladdreg.data.postalcode.PostalCodeEntityManager;
import dk.magenta.datafordeler.gladdreg.data.road.RoadEntity;
import dk.magenta.datafordeler.gladdreg.data.road.RoadEntityManager;
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

    @Autowired
    private LocalityEntityManager localityEntityManager;

    @Autowired
    private BNumberEntityManager bNumberEntityManager;

    @Autowired
    private RoadEntityManager roadEntityManager;

    @PostConstruct
    public void init() {
        this.registerManager.addEntityManager(this.municipalityEntityManager, MunicipalityEntity.schema);
        this.registerManager.addEntityManager(this.districtEntityManager, DistrictEntity.schema);
        this.registerManager.addEntityManager(this.postalCodeEntityManager, PostalCodeEntity.schema);
        this.registerManager.addEntityManager(this.localityEntityManager, LocalityEntity.schema);
        this.registerManager.addEntityManager(this.bNumberEntityManager, BNumberEntity.schema);
        this.registerManager.addEntityManager(this.roadEntityManager, RoadEntity.schema);
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
