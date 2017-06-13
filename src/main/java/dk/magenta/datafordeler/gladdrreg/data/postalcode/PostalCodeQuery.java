package dk.magenta.datafordeler.gladdrreg.data.postalcode;

import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class PostalCodeQuery extends SumiffiikQuery<PostalCodeEntity> {

    public static final String CODE = "code";
    public static final String NAME = "name";

    @QueryField(type = QueryField.FieldType.INT)
    private String code;

    @QueryField(type = QueryField.FieldType.STRING)
    private String name;

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

    @Override
    public Map<String, Object> getSearchParameters() {
        HashMap<String, Object> map = new HashMap<>(super.getSearchParameters());
        map.put(CODE, this.code);
        map.put(NAME, this.name);
        return map;
    }

    @Override
    public void setFromParameters(ParameterMap parameters) {
        super.setFromParameters(parameters);
        this.setCode(parameters.getFirst(CODE));
        this.setName(parameters.getFirst(NAME));
    }

    @Override
    public Class<PostalCodeEntity> getEntityClass() {
        return PostalCodeEntity.class;
    }

}
