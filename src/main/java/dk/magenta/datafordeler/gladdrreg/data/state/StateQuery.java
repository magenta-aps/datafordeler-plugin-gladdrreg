package dk.magenta.datafordeler.gladdrreg.data.state;

import dk.magenta.datafordeler.core.database.Entity;
import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.core.util.ListHashMap;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class StateQuery extends SumiffiikQuery<StateEntity> {

    public static final String CODE = "code";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";

    @QueryField(type = QueryField.FieldType.STRING)
    private String code;

    @QueryField(type = QueryField.FieldType.STRING)
    private String name;

    @QueryField(type = QueryField.FieldType.STRING)
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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