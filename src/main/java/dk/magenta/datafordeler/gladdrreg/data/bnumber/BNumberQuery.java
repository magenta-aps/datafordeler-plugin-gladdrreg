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

    public static final String CODE = BNumberData.IO_FIELD_CODE;
    public static final String TYPE = BNumberData.IO_FIELD_TYPE;
    public static final String NAME = BNumberData.IO_FIELD_CALLNAME;

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
        if (code != null) {
            this.increaseDataParamCount();
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        if (type != null) {
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
            lookupDefinition.put(BNumberData.DB_FIELD_CODE, this.code, String.class);
        }
        if (this.type != null) {
            lookupDefinition.put(BNumberData.DB_FIELD_TYPE, this.type, String.class);
        }
        if (this.name != null) {
            lookupDefinition.put(BNumberData.DB_FIELD_CALLNAME, this.name, String.class);
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
