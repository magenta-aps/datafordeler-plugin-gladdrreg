package dk.magenta.datafordeler.gladdrreg.data.locality;

import dk.magenta.datafordeler.core.database.Entity;
import dk.magenta.datafordeler.core.fapi.Query;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.core.util.ListHashMap;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class LocalityQuery extends SumiffiikQuery {

    public static final String CODE = "code";
    public static final String ABBREV = "abbrev";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String LOCALITY_STATE = "localityState";

    @QueryField(type = QueryField.FieldType.INT)
    private String code;

    @QueryField(type = QueryField.FieldType.STRING)
    private String abbrev;

    @QueryField(type = QueryField.FieldType.STRING)
    private String name;

    @QueryField(type = QueryField.FieldType.INT)
    private Integer type;

    @QueryField(type = QueryField.FieldType.INT)
    private Integer localityState;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLocalityState() {
        return localityState;
    }

    public void setLocalityState(Integer locality_state) {
        this.localityState = locality_state;
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
    public void setFromParameters(ListHashMap<String, String> listHashMap) {
        super.setFromParameters(listHashMap);
        this.setCode(listHashMap.getFirst(CODE));
        this.setAbbrev(listHashMap.getFirst(ABBREV));
        this.setName(listHashMap.getFirst(NAME));
        this.setType(Query.intFromString(listHashMap.getFirst(TYPE)));
        this.setLocalityState(Query.intFromString(listHashMap.getFirst(LOCALITY_STATE)));
    }

    @Override
    public Class<? extends Entity> getEntityClass() {
        return LocalityEntity.class;
    }

}
