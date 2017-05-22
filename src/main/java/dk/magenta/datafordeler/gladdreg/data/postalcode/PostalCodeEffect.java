package dk.magenta.datafordeler.gladdreg.data.postalcode;

import dk.magenta.datafordeler.core.database.Effect;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="postalcode_effect")
public class PostalCodeEffect extends Effect<PostalCodeRegistration, PostalCodeEffect, PostalCodeData> {
}
