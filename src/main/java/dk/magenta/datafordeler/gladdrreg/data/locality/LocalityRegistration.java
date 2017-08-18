package dk.magenta.datafordeler.gladdrreg.data.locality;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_locality_registration")
public class LocalityRegistration extends Registration<LocalityEntity, LocalityRegistration, LocalityEffect> {
    @Override
    protected LocalityEffect createEmptyEffect(OffsetDateTime effectFrom, OffsetDateTime effectTo) {
        return new LocalityEffect(this, effectFrom, effectTo);
    }
}
