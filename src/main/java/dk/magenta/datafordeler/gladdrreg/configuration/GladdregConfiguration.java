package dk.magenta.datafordeler.gladdrreg.configuration;

import dk.magenta.datafordeler.gladdrreg.GladdregPlugin;
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

    // Midnight every january 1st, eg. never
    @Column
    private String pullCronSchedule = "0 0 0 1 1 ?";

    @Column
    private String registerAddress = "http://localhost:8000";

    public String getPullCronSchedule() {
        return this.pullCronSchedule;
    }

    public String getRegisterAddress() {
        return this.registerAddress;
    }
}
