package dk.magenta.datafordeler.gladdrreg.data.road;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_road_registration")
public class RoadRegistration extends Registration<RoadEntity, RoadRegistration, RoadEffect> {
    @Override
    protected RoadEffect createEmptyEffect(OffsetDateTime effectFrom, OffsetDateTime effectTo) {
        return new RoadEffect(this, effectFrom, effectTo);
    }
}
