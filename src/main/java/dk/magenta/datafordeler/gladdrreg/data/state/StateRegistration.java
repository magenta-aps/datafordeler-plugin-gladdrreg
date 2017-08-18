package dk.magenta.datafordeler.gladdrreg.data.state;

import dk.magenta.datafordeler.core.database.Registration;

import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_state_registration")
public class StateRegistration extends Registration<StateEntity, StateRegistration, StateEffect> {
    @Override
    protected StateEffect createEmptyEffect(OffsetDateTime effectFrom, OffsetDateTime effectTo) {
        return new StateEffect(this, effectFrom, effectTo);
    }
}
