package dk.magenta.datafordeler.gladdreg;

import dk.magenta.datafordeler.core.configuration.ConfigurationManager;
import dk.magenta.datafordeler.core.plugin.Plugin;
import dk.magenta.datafordeler.core.plugin.RegisterManager;
import dk.magenta.datafordeler.gladdreg.configuration.GladdregConfigurationManager;
import dk.magenta.datafordeler.gladdreg.municipality.MunicipalityEntity;
import dk.magenta.datafordeler.gladdreg.municipality.MunicipalityEntityManager;
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

    @PostConstruct
    public void init() {
        this.registerManager.addEntityManager(this.municipalityEntityManager, MunicipalityEntity.schema);
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
