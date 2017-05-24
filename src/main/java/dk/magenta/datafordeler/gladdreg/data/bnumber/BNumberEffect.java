package dk.magenta.datafordeler.gladdreg.data.bnumber;

import dk.magenta.datafordeler.core.database.Effect;

import javax.persistence.Table;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="bnumber_effect")
public class BNumberEffect extends Effect<BNumberRegistration, BNumberEffect, BNumberData> {
}
