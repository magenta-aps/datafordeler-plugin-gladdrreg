package dk.magenta.datafordeler.gladdrreg.data.locality;

import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.core.database.LookupDefinition;
import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.Query;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lars on 19-05-17.
 */
public class LocalityQuery extends SumiffiikQuery<LocalityEntity> {

    public static final String CODE = LocalityData.IO_FIELD_CODE;
    public static final String ABBREV = LocalityData.IO_FIELD_ABBREV;
    public static final String NAME = LocalityData.IO_FIELD_NAME;
    public static final String TYPE = LocalityData.IO_FIELD_TYPE;
    public static final String LOCALITY_STATE = LocalityData.IO_FIELD_STATE;

    @QueryField(type = QueryField.FieldType.INT, queryName = CODE)
    private String code;

    @QueryField(type = QueryField.FieldType.STRING, queryName = ABBREV)
    private String abbrev;

    @QueryField(type = QueryField.FieldType.STRING, queryName = NAME)
    private String name;

    @QueryField(type = QueryField.FieldType.INT, queryName = TYPE)
    private Integer type;

    @QueryField(type = QueryField.FieldType.INT, queryName = LOCALITY_STATE)
    private Integer localityState;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        if (code != null) {
            this.increaseDataParamCount();
        }
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
        if (abbrev != null) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
        if (type != null) {
            this.increaseDataParamCount();
        }
    }

    public Integer getLocalityState() {
        return localityState;
    }

    public void setLocalityState(Integer locality_state) {
        this.localityState = locality_state;
        if (locality_state != null) {
            this.increaseDataParamCount();
        }
    }

    private String municipality;

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    @Override
    public Map<String, Object> getSearchParameters() {
        HashMap<String, Object> map = new HashMap<>(super.getSearchParameters());
        map.put(CODE, this.code);
        map.put(ABBREV, this.abbrev);
        map.put(NAME, this.name);
        map.put(TYPE, this.type);
        map.put(LOCALITY_STATE, this.localityState);
        return map;
    }

    @Override
    public LookupDefinition getLookupDefinition() {
        LookupDefinition lookupDefinition = super.getLookupDefinition();
        if (this.code != null) {
            lookupDefinition.put(LocalityData.DB_FIELD_CODE, this.code, Integer.class);
        }
        if (this.name != null) {
            lookupDefinition.put(LocalityData.DB_FIELD_NAME, this.name, String.class);
        }
        if (this.abbrev != null) {
            lookupDefinition.put(LocalityData.DB_FIELD_ABBREV, this.abbrev, String.class);
        }
        if (this.type != null) {
            lookupDefinition.put(LocalityData.DB_FIELD_TYPE, this.type, Integer.class);
        }
        if (this.localityState != null) {
            lookupDefinition.put(LocalityData.DB_FIELD_STATE, this.localityState, Integer.class);
        }
        if (this.municipality != null) {
            lookupDefinition.put(LocalityData.DB_FIELD_MUNICIPALITY + LookupDefinition.separator + Identification.DB_FIELD_UUID, this.municipality, UUID.class);
        }
        return lookupDefinition;
    }

    @Override
    public void setFromParameters(ParameterMap parameters) {
        super.setFromParameters(parameters);
        this.setCode(parameters.getFirst(CODE));
        this.setAbbrev(parameters.getFirst(ABBREV));
        this.setName(parameters.getFirst(NAME));
        this.setType(Query.intFromString(parameters.getFirst(TYPE)));
        this.setLocalityState(Query.intFromString(parameters.getFirst(LOCALITY_STATE)));
    }

    @Override
    public Class<LocalityEntity> getEntityClass() {
        return LocalityEntity.class;
    }

    @Override
    public Class getDataClass() {
        return LocalityData.class;
    }

}
