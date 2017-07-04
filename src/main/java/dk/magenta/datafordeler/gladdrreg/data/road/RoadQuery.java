package dk.magenta.datafordeler.gladdrreg.data.road;

import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class RoadQuery extends SumiffiikQuery<RoadEntity> {

    public static final String CODE = "code";
    public static final String NAME = "name";
    public static final String SHORT_NAME = "short_name";
    public static final String ALTERNATE_NAME = "alternate_name";
    public static final String CPR_NAME = "cpr_name";

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    public String getCprName() {
        return cprName;
    }

    public void setCprName(String cprName) {
        this.cprName = cprName;
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
