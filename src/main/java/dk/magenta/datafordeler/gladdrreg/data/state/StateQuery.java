package dk.magenta.datafordeler.gladdrreg.data.state;

import dk.magenta.datafordeler.core.database.LookupDefinition;
import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class StateQuery extends SumiffiikQuery<StateEntity> {

    public static final String CODE = StateData.IO_FIELD_CODE;
    public static final String NAME = StateData.IO_FIELD_NAME;
    public static final String DESCRIPTION = StateData.IO_FIELD_DESCRIPTION;

    @QueryField(type = QueryField.FieldType.STRING, queryName = CODE)
    private String code;

    @QueryField(type = QueryField.FieldType.STRING, queryName = NAME)
    private String name;

    @QueryField(type = QueryField.FieldType.STRING, queryName = DESCRIPTION)
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        if (description != null) {
            this.increaseDataParamCount();
        }
    }

    @Override
    public Map<String, Object> getSearchParameters() {
        HashMap<String, Object> map = new HashMap<>(super.getSearchParameters());
        map.put(CODE, this.code);
        map.put(NAME, this.name);
        map.put(DESCRIPTION, this.description);
        return map;
    }

    @Override
    public LookupDefinition getLookupDefinition() {
        LookupDefinition lookupDefinition = super.getLookupDefinition();
        if (this.code != null) {
            lookupDefinition.put(StateData.DB_FIELD_CODE, this.code, String.class);
        }
        if (this.name != null) {
            lookupDefinition.put(StateData.DB_FIELD_NAME, this.name, String.class);
        }
        if (this.description != null) {
            lookupDefinition.put(StateData.DB_FIELD_DESCRIPTION, this.description, String.class);
        }
        return lookupDefinition;
    }

    @Override
    public void setFromParameters(ParameterMap parameters) {
        super.setFromParameters(parameters);
        this.setCode(parameters.getFirst(CODE));
        this.setName(parameters.getFirst(NAME));
        this.setDescription(parameters.getFirst(DESCRIPTION));
    }

    @Override
    public Class<StateEntity> getEntityClass() {
        return StateEntity.class;
    }

    @Override
    public Class getDataClass() {
        return StateData.class;
    }

}
