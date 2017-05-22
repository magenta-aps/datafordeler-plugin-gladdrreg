package dk.magenta.datafordeler.gladdreg.data.district;

import dk.magenta.datafordeler.core.database.Effect;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="district_effect")
public class DistrictEffect extends Effect<DistrictRegistration, DistrictEffect, DistrictData> {
}
