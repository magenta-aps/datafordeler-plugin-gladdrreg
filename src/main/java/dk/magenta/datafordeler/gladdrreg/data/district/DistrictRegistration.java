package dk.magenta.datafordeler.gladdrreg.data.district;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_district_registration")
public class DistrictRegistration extends Registration<DistrictEntity, DistrictRegistration, DistrictEffect> {
    @Override
    protected DistrictEffect createEmptyEffect(OffsetDateTime effectFrom, OffsetDateTime effectTo) {
        return new DistrictEffect(this, effectFrom, effectTo);
    }
}
