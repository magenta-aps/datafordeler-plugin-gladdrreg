package dk.magenta.datafordeler.gladdrreg.data.road;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikData;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_road_data", indexes = {
        @Index(name = "gladdrreg_road_code", columnList = "code")
})
public class RoadData extends SumiffiikData<RoadEffect, RoadData> {

    @Column
    @JsonProperty
    @XmlElement
    private int code;

    @Column
    @JsonProperty
    @XmlElement
    private String name;

    public String getName() {
        return this.name;
    }

    @Column
    @JsonProperty("shortname")
    @XmlElement
    private String shortName;

    public String getShortName() {
        return this.shortName;
    }

    @Column
    @JsonProperty("alternate_name")
    @XmlElement
    private String alternateName;

    public String getAlternateName() {
        return this.alternateName;
    }

    @Column
    @JsonProperty("cpr_name")
    @XmlElement
    private String cprName;

    public String getCprName() {
        return this.cprName;
    }

    @ManyToOne
    @JsonProperty
    @XmlElement
    private Identification location;

    public Identification getLocation() {
        return this.location;
    }

    @ManyToOne
    @JsonProperty
    @XmlElement
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
