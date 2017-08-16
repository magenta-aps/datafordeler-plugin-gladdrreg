package dk.magenta.datafordeler.gladdrreg.data.municipality;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.magenta.datafordeler.core.database.Entity;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_municipality_entity")
public class MunicipalityEntity extends Entity<MunicipalityEntity, MunicipalityRegistration> {

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="type")
    public static final String schema = "Municipality";

    @Override
    protected MunicipalityRegistration createEmptyRegistration() {
        return new MunicipalityRegistration();
    }
}
