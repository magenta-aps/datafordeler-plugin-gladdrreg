package dk.magenta.datafordeler.gladdrreg.data.road;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.magenta.datafordeler.core.database.Entity;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_road_entity")
public class RoadEntity extends Entity<RoadEntity, RoadRegistration> {

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="type")
    public static final String schema = "Road";

    @Override
    protected RoadRegistration createEmptyRegistration() {
        return new RoadRegistration();
    }
}
