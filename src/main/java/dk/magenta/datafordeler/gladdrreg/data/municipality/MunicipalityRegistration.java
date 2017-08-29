package dk.magenta.datafordeler.gladdrreg.data.municipality;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_municipality_registration")
public class MunicipalityRegistration extends Registration<MunicipalityEntity, MunicipalityRegistration, MunicipalityEffect> {
    @Override
    protected MunicipalityEffect createEmptyEffect(OffsetDateTime effectFrom, OffsetDateTime effectTo) {
        return new MunicipalityEffect(this, effectFrom, effectTo);
    }
}
