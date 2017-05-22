package dk.magenta.datafordeler.gladdreg.data.district;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="district_registration")
public class DistrictRegistration extends Registration<DistrictEntity, DistrictRegistration, DistrictEffect> {
}
