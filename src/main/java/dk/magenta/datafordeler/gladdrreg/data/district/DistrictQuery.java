package dk.magenta.datafordeler.gladdrreg.data.district;

import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class DistrictQuery extends SumiffiikQuery<DistrictEntity> {

    public static final String CODE = "code";
    public static final String ABBREV = "abbrev";
    public static final String NAME = "name";

    @QueryField(type = QueryField.FieldType.STRING)
    private String code;

    @QueryField(type = QueryField.FieldType.STRING)
    private String abbrev;

    @QueryField(type = QueryField.FieldType.STRING)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
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
        map.put(ABBREV, this.abbrev);
        map.put(NAME, this.name);
        return map;
    }

    @Override
    public void setFromParameters(ParameterMap parameters) {
        super.setFromParameters(parameters);
        this.setCode(parameters.getFirst(CODE));
        this.setAbbrev(parameters.getFirst(ABBREV));
        this.setName(parameters.getFirst(NAME));
    }

    @Override
    public Class<DistrictEntity> getEntityClass() {
        return DistrictEntity.class;
    }

    @Override
    public Class getDataClass() {
        return DistrictData.class;
    }

}