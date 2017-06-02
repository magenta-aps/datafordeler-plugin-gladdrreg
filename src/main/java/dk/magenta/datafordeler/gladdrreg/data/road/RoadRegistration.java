package dk.magenta.datafordeler.gladdrreg.data.road;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_road_registration")
public class RoadRegistration extends Registration<RoadEntity, RoadRegistration, RoadEffect> {
}
