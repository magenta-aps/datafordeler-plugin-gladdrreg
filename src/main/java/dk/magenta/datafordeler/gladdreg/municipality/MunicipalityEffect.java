package dk.magenta.datafordeler.gladdreg.municipality;

import dk.magenta.datafordeler.core.database.Effect;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="municipality_effect")
public class MunicipalityEffect extends Effect<MunicipalityRegistration, MunicipalityEffect, MunicipalityData> {
}
