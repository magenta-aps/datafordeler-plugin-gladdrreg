package dk.magenta.datafordeler.gladdrreg.data.postalcode;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_postalcode_registration")
public class PostalCodeRegistration extends Registration<PostalCodeEntity, PostalCodeRegistration, PostalCodeEffect> {
}
