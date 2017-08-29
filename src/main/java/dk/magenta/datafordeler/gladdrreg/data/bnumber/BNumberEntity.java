package dk.magenta.datafordeler.gladdrreg.data.bnumber;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.magenta.datafordeler.core.database.Entity;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_bnumber_entity")
public class BNumberEntity extends Entity<BNumberEntity, BNumberRegistration> {

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="type")
    public static final String schema = "BNumber";

    @Override
    protected BNumberRegistration createEmptyRegistration() {
        return new BNumberRegistration();
    }
}
