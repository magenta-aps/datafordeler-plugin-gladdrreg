package dk.magenta.datafordeler.gladdrreg.data.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.core.database.DatabaseEntry;
import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikData;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_address_data", indexes = {
        @Index(name = "gladdrreg_address_road", columnList = "road_id"),
        @Index(name = "gladdrreg_address_housenumber", columnList = "houseNumber"),
        @Index(name = "gladdrreg_address_floor", columnList = "floor"),
        @Index(name = "gladdrreg_address_room", columnList = "room")
})
public class AddressData extends SumiffiikData<AddressEffect, AddressData> {

    public static final String DB_FIELD_HOUSENUMBER = "houseNumber";
    public static final String IO_FIELD_HOUSENUMBER = "husnummer";

    @Column(name = DB_FIELD_HOUSENUMBER)
    @JsonProperty("house_number")
    @XmlElement
    private String houseNumber;


    public static final String DB_FIELD_FLOOR = "floor";
    public static final String IO_FIELD_FLOOR = "etage";

    @JsonProperty
    @XmlElement
    @Column(name = DB_FIELD_FLOOR)
    private String floor;


    public static final String DB_FIELD_ROOM = "room";
    public static final String IO_FIELD_ROOM = "værelse";

    @JsonProperty
    @XmlElement
    @Column(name = DB_FIELD_ROOM)
    private String room;


    public static final String DB_FIELD_BNUMBER = "bNumber";
    public static final String IO_FIELD_BNUMBER = "bNummer";

    @JsonProperty("b_number")
    @XmlElement
    @ManyToOne
    @JoinColumn(name = DB_FIELD_BNUMBER + DatabaseEntry.REF)
    private Identification bNumber;


    public static final String DB_FIELD_ROAD = "road";
    public static final String IO_FIELD_ROAD = "vej";

    @JsonProperty
    @XmlElement
    @ManyToOne
    @JoinColumn(name = DB_FIELD_ROAD + DatabaseEntry.REF)
    private Identification road;


    public static final String DB_FIELD_MUNICIPALITY = "municipality";
    public static final String IO_FIELD_MUNICIPALITY = "kommune";

    @JsonProperty
    @XmlElement
    @ManyToOne
    @JoinColumn(name = DB_FIELD_MUNICIPALITY + DatabaseEntry.REF)
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
