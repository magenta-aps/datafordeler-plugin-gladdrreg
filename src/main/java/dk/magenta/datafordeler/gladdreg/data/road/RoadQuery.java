package dk.magenta.datafordeler.gladdreg.data.road;

import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.core.database.Entity;
import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.core.util.ListHashMap;
import dk.magenta.datafordeler.gladdreg.data.SumiffiikQuery;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class RoadQuery extends SumiffiikQuery {

    public static final String CODE = "code";
    public static final String NAME = "name";
    public static final String SHORT_NAME = "short_name";
    public static final String ALTERNATE_NAME = "alternate_name";
    public static final String CPR_NAME = "cpr_name";

    @QueryField(type = QueryField.FieldType.INT)
    private String code;

    @QueryField(type = QueryField.FieldType.STRING)
    private String name;

    @QueryField(type = QueryField.FieldType.STRING)
    private String shortName;

    @QueryField(type = QueryField.FieldType.STRING)
    private String alternateName;

    @QueryField(type = QueryField.FieldType.STRING)
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
    public void setFromParameters(ListHashMap<String, String> listHashMap) {
        super.setFromParameters(listHashMap);
        this.setCode(listHashMap.getFirst(CODE));
        this.setName(listHashMap.getFirst(NAME));
        this.setShortName(listHashMap.getFirst(SHORT_NAME));
        this.setAlternateName(listHashMap.getFirst(ALTERNATE_NAME));
        this.setCprName(listHashMap.getFirst(CPR_NAME));
    }

    @Override
    public Class<? extends Entity> getEntityClass() {
        return RoadEntity.class;
    }

}
