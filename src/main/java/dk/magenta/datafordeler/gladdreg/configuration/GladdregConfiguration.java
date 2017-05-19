package dk.magenta.datafordeler.gladdreg.configuration;

import dk.magenta.datafordeler.gladdreg.GladdregPlugin;
import dk.magenta.datafordeler.core.configuration.Configuration;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdreg_config")
public class GladdregConfiguration implements Configuration {

    @Id
    @Column(name = "id")
    private final String plugin = GladdregPlugin.class.getName();

    @Column
    private String pullCronSchedule = "0 15 * * * ?";

    public String getPullCronSchedule() {
        return this.pullCronSchedule;
    }
}
