package dk.magenta.datafordeler.gladdreg.data.bnumber;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="bnumber_registration")
public class BNumberRegistration extends Registration<BNumberEntity, BNumberRegistration, BNumberEffect> {
}
