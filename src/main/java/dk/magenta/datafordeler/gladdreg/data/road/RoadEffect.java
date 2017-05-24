package dk.magenta.datafordeler.gladdreg.data.road;

import dk.magenta.datafordeler.core.database.Effect;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="road_effect")
public class RoadEffect extends Effect<RoadRegistration, RoadEffect, RoadData> {
}
