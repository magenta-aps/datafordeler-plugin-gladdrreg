package dk.magenta.datafordeler.gladdreg.data.district;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.magenta.datafordeler.core.database.Entity;
import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="district_entity")
public class DistrictEntity extends Entity<DistrictEntity, DistrictRegistration> {

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="type")
    public static final String schema = "District";

}
