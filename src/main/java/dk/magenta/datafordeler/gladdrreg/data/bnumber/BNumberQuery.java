package dk.magenta.datafordeler.gladdrreg.data.bnumber;

import dk.magenta.datafordeler.core.database.LookupDefinition;
import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class BNumberQuery extends SumiffiikQuery<BNumberEntity> {

    public static final String CODE = "code";
    public static final String TYPE = "type";
    public static final String NAME = "name";

    @QueryField(type = QueryField.FieldType.STRING, queryName = CODE)
    private String code;

    @QueryField(type = QueryField.FieldType.STRING, queryName = TYPE)
    private String type;

    @QueryField(type = QueryField.FieldType.STRING, queryName = NAME)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<String, Object> getSearchParameters() {
        HashMap<String, Object> map = new HashMap<>(super.getSearchParameters());
        map.put(CODE, this.code);
        map.put(TYPE, this.type);
        map.put(NAME, this.name);
        return map;
    }

    @Override
    public LookupDefinition getLookupDefinition() {
        LookupDefinition lookupDefinition = super.getLookupDefinition();
        if (this.code != null) {
            lookupDefinition.put("code", this.code, String.class);
        }
        if (this.type != null) {
            lookupDefinition.put("b_type", this.type, String.class);
        }
        if (this.name != null) {
            lookupDefinition.put("b_callname", this.name, String.class);
        }
        return lookupDefinition;
    }

    @Override
    public void setFromParameters(ParameterMap parameters) {
        super.setFromParameters(parameters);
        this.setCode(parameters.getFirst(CODE));
        this.setType(parameters.getFirst(TYPE));
        this.setName(parameters.getFirst(NAME));
    }

    @Override
    public Class<BNumberEntity> getEntityClass() {
        return BNumberEntity.class;
    }

    @Override
    public Class getDataClass() {
        return BNumberData.class;
    }

}
