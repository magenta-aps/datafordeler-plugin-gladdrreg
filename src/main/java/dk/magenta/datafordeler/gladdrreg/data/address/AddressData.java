package dk.magenta.datafordeler.gladdrreg.data.address;

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
@Table(name="address_data")
public class AddressData extends SumiffiikData<AddressEffect, AddressData> {

    @Column
    @JsonProperty("house_number")
    @XmlElement
    private String houseNumber;

    @Column
    @JsonProperty
    @XmlElement
    private String floor;

    @Column
    @JsonProperty
    @XmlElement
    private String room;

    @ManyToOne
    @JsonProperty("b_number")
    @XmlElement
    private Identification bNumber;

    @ManyToOne
    @JsonProperty
    @XmlElement
    private Identification road;

    @ManyToOne
    @JsonProperty
    @XmlElement
    private Identification municipality;

    @Override
    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<>(super.asMap());
        map.put("houseNumber", this.houseNumber);
        map.put("floor", this.floor);
        map.put("room", this.room);
        map.put("bNumber", this.bNumber);
        map.put("road", this.road);
        map.put("municipality", this.municipality);
        return map;
    }


    @Override
    @JsonIgnore
    public HashMap<String, Identification> getReferences() {
        HashMap<String, Identification> references = super.getReferences();
        references.put("bNumber", this.bNumber);
        references.put("road", this.road);
        references.put("municipality", this.municipality);
        return references;
    }

    @Override
    public void updateReferences(HashMap<String, Identification> references) {
        super.updateReferences(references);
        if (references.containsKey("bNumber")) {
            this.bNumber = references.get("bNumber");
        }
        if (references.containsKey("road")) {
            this.road = references.get("road");
        }
        if (references.containsKey("municipality")) {
            this.municipality = references.get("municipality");
        }
    }
}
