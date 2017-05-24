package dk.magenta.datafordeler.gladdreg.data.address;

import dk.magenta.datafordeler.core.database.Effect;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="address_effect")
public class AddressEffect extends Effect<AddressRegistration, AddressEffect, AddressData> {
}
