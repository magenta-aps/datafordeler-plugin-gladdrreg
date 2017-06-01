package dk.magenta.datafordeler.gladdrreg.data.locality;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikData;

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
@Table(name="locality_data")
public class LocalityData extends SumiffiikData<LocalityEffect, LocalityData> {

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

    @Column
    @JsonProperty
    @XmlElement
    private int type;

    @Column
    @JsonProperty("locality_state")
    @XmlElement
    private int localityState;



    @ManyToOne
    @JsonProperty(required = false)
    @XmlElement
    private Identification municipality;

    @ManyToOne
    @JsonProperty(required = false)
    @XmlElement
    private Identification district;

    @ManyToOne
    @JsonProperty(value="postal_code", required = false)
    @XmlElement
    private Identification postalCode;


    @Override
    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<>(super.asMap());
        map.put("code", this.code);
        map.put("abbrev", this.abbrev);
        map.put("name", this.name);
        map.put("type", this.type);
        map.put("localityState", this.localityState);
        return map;
    }

    @Override
    @JsonIgnore
    public HashMap<String, Identification> getReferences() {
        HashMap<String, Identification> references = super.getReferences();
        references.put("municipality", this.municipality);
        references.put("district", this.district);
        references.put("postalCode", this.postalCode);
        return references;
    }

    @Override
    public void updateReferences(HashMap<String, Identification> references) {
        super.updateReferences(references);
        if (references.containsKey("municipality")) {
            this.municipality = references.get("municipality");
        }
        if (references.containsKey("district")) {
            this.district = references.get("district");
        }
        if (references.containsKey("postalCode")) {
            this.postalCode = references.get("postalCode");
        }
    }

}
