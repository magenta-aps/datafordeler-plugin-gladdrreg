package dk.magenta.datafordeler.gladdreg.data.postalcode;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.magenta.datafordeler.core.database.Entity;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="postalcode_entity")
public class PostalCodeEntity extends Entity<PostalCodeEntity, PostalCodeRegistration> {

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="type")
    public static final String schema = "PostalCode";

}
