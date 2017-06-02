package dk.magenta.datafordeler.gladdrreg.data.municipality;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_municipality_registration")
public class MunicipalityRegistration extends Registration<MunicipalityEntity, MunicipalityRegistration, MunicipalityEffect> {
}
