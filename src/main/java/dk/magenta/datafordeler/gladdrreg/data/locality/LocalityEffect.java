package dk.magenta.datafordeler.gladdrreg.data.locality;

import dk.magenta.datafordeler.core.database.Effect;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_locality_effect")
public class LocalityEffect extends Effect<LocalityRegistration, LocalityEffect, LocalityData> {
}
