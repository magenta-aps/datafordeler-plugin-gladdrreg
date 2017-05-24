package dk.magenta.datafordeler.gladdreg.data.road;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.gladdreg.data.SumiffiikData;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="road_data")
public class RoadData extends SumiffiikData<RoadEffect, RoadData> {

    @Column
    @JsonProperty
    @XmlElement
    private int code;

    @Column
    @JsonProperty
    @XmlElement
    private String name;

    @Column
    @JsonProperty("shortname")
    @XmlElement
    private String shortName;

    @Column
    @JsonProperty("alternate_name")
    @XmlElement
    private String alternateName;

    @Column
    @JsonProperty("cpr_name")
    @XmlElement
    private String cprName;

    @JsonProperty
    @XmlElement
    @ManyToOne
    private Identification location;

    @JsonProperty
    @XmlElement
    @ManyToOne
    private Identification municipality;

    @Override
    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<>(super.asMap());
        map.put("code", this.code);
        map.put("name", this.name);
        map.put("shortName", this.shortName);
        map.put("alternateName", this.alternateName);
        map.put("cprName", this.cprName);
        return map;
    }


    @Override
    @JsonIgnore
    public HashMap<String, Identification> getReferences() {
        HashMap<String, Identification> references = super.getReferences();
        references.put("municipality", this.municipality);
        references.put("location", this.location);
        return references;
    }

    @Override
    public void updateReferences(HashMap<String, Identification> references) {
        super.updateReferences(references);
        if (references.containsKey("municipality")) {
            this.municipality = references.get("municipality");
        }
        if (references.containsKey("location")) {
            this.location = references.get("location");
        }
    }
}
