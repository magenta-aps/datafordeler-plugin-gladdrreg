package dk.magenta.datafordeler.gladdrreg.data.district;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_district_registration")
public class DistrictRegistration extends Registration<DistrictEntity, DistrictRegistration, DistrictEffect> {
}
