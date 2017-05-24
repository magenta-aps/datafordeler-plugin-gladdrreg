package dk.magenta.datafordeler.gladdreg.data.address;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="address_registration")
public class AddressRegistration extends Registration<AddressEntity, AddressRegistration, AddressEffect> {
}
