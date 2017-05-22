package dk.magenta.datafordeler.gladdreg.data.postalcode;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="postalcode_registration")
public class PostalCodeRegistration extends Registration<PostalCodeEntity, PostalCodeRegistration, PostalCodeEffect> {
}
