package dk.magenta.datafordeler.gladdrreg.data.road;

import dk.magenta.datafordeler.core.database.DatabaseEntry;
import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.core.database.LookupDefinition;
import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lars on 19-05-17.
 */
public class RoadQuery extends SumiffiikQuery<RoadEntity> {

    public static final String CODE = RoadData.IO_FIELD_CODE;
    public static final String NAME = RoadData.IO_FIELD_NAME;
    public static final String SHORT_NAME = RoadData.IO_FIELD_SHORTNAME;
    public static final String ALTERNATE_NAME = RoadData.IO_FIELD_ALTNAME;
    public static final String CPR_NAME = RoadData.IO_FIELD_CPRNAME;
    public static final String MUNICIPALITY_ID = RoadData.IO_FIELD_MUNICIPALITY;

    @QueryField(type = QueryField.FieldType.INT, queryName = CODE)
    private String code;

    @QueryField(type = QueryField.FieldType.STRING, queryName = NAME)
    private String name;

    @QueryField(type = QueryField.FieldType.STRING, queryName = SHORT_NAME)
    private String shortName;

    @QueryField(type = QueryField.FieldType.STRING, queryName = ALTERNATE_NAME)
    private String alternateName;

    @QueryField(type = QueryField.FieldType.STRING, queryName = CPR_NAME)
    private String cprName;

    @QueryField(type = QueryField.FieldType.STRING, queryName = MUNICIPALITY_ID)
    private String municipalityIdentifier;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        if (code != null) {
            this.increaseDataParamCount();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (name != null) {
            this.increaseDataParamCount();
        }
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
        if (shortName != null) {
            this.increaseDataParamCount();
        }
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
        if (alternateName != null) {
            this.increaseDataParamCount();
        }
    }

    public String getCprName() {
        return cprName;
    }

    public void setCprName(String cprName) {
        this.cprName = cprName;
        if (cprName != null) {
            this.increaseDataParamCount();
        }
    }

    public String getMunicipalityIdentifier() {
        return this.municipalityIdentifier;
    }

    public void setMunicipalityIdentifier(String municipalityIdentifier) {
        this.municipalityIdentifier = municipalityIdentifier;
        if (municipalityIdentifier != null) {
            this.increaseDataParamCount();
        }
    }

    private String locality;

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public Map<String, Object> getSearchParameters() {
        HashMap<String, Object> map = new HashMap<>(super.getSearchParameters());
        map.put(CODE, this.code);
        map.put(NAME, this.name);
        map.put(SHORT_NAME, this.shortName);
        map.put(ALTERNATE_NAME, this.alternateName);
        map.put(CPR_NAME, this.cprName);
        return map;
    }

    @Override
    public LookupDefinition getLookupDefinition() {
        LookupDefinition lookupDefinition = super.getLookupDefinition();
        if (this.code != null) {
            lookupDefinition.put(RoadData.DB_FIELD_CODE, this.code, Integer.class);
        }
        if (this.name != null) {
            lookupDefinition.put(RoadData.DB_FIELD_NAME, this.name, String.class);
        }
        if (this.shortName != null) {
            lookupDefinition.put(RoadData.DB_FIELD_SHORTNAME, this.shortName, String.class);
        }
        if (this.alternateName != null) {
            lookupDefinition.put(RoadData.DB_FIELD_ALTNAME, this.alternateName, String.class);
        }
        if (this.cprName != null) {
            lookupDefinition.put(RoadData.DB_FIELD_CPRNAME, this.cprName, String.class);
        }
        if (this.municipalityIdentifier != null) {
            lookupDefinition.put(RoadData.DB_FIELD_MUNICIPALITY + LookupDefinition.separator + Identification.DB_FIELD_UUID, this.municipalityIdentifier, UUID.class);
        }
        if (this.locality != null) {
            lookupDefinition.put(RoadData.DB_FIELD_LOCATION + LookupDefinition.separator + Identification.DB_FIELD_UUID, this.locality, UUID.class);
        }
        return lookupDefinition;
    }

    @Override
    public void setFromParameters(ParameterMap parameters) {
        super.setFromParameters(parameters);
        this.setCode(parameters.getFirst(CODE));
        this.setName(parameters.getFirst(NAME));
        this.setShortName(parameters.getFirst(SHORT_NAME));
        this.setAlternateName(parameters.getFirst(ALTERNATE_NAME));
        this.setCprName(parameters.getFirst(CPR_NAME));
    }

    @Override
    public Class<RoadEntity> getEntityClass() {
        return RoadEntity.class;
    }

    @Override
    public Class getDataClass() {
        return RoadData.class;
    }

}
