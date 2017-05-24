package dk.magenta.datafordeler.gladdreg.data.municipality;

import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.gladdreg.data.SumiffiikData;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="municipality_data")
public class MunicipalityData extends SumiffiikData<MunicipalityEffect, MunicipalityData> {

    @Column
    @JsonProperty
    @XmlElement
    private int code;

    @Column
    @JsonProperty
    @XmlElement
    private String abbrev;

    @Column
    @JsonProperty
    @XmlElement
    private String name;

    @Override
    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<>(super.asMap());
        map.put("code", this.code);
        map.put("abbrev", this.abbrev);
        map.put("name", this.name);
        return map;
    }

}
