package dk.magenta.datafordeler.gladdrreg.data.bnumber;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_bnumber_registration")
public class BNumberRegistration extends Registration<BNumberEntity, BNumberRegistration, BNumberEffect> {
    @Override
    protected BNumberEffect createEmptyEffect(OffsetDateTime effectFrom, OffsetDateTime effectTo) {
        return new BNumberEffect(this, effectFrom, effectTo);
    }
}
