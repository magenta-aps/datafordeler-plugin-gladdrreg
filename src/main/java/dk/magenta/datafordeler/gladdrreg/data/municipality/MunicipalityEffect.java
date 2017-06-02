package dk.magenta.datafordeler.gladdrreg.data.municipality;

import dk.magenta.datafordeler.core.database.Effect;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_municipality_effect")
public class MunicipalityEffect extends Effect<MunicipalityRegistration, MunicipalityEffect, MunicipalityData> {
}
