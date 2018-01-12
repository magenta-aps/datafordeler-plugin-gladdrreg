package dk.magenta.datafordeler.gladdrreg.data.bnumber;

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
@Table(name="gladdrreg_bnumber_data", indexes = {
        @Index(name = "gladdrreg_bnumber_code", columnList = "code"),
        @Index(name = "gladdrreg_bnumber_type", columnList = "b_type"),
        @Index(name = "gladdrreg_bnumber_name", columnList = "b_callname")
})
public class BNumberData extends SumiffiikData<BNumberEffect, BNumberData> {

    public static final String DB_FIELD_CODE = "code";
    public static final String IO_FIELD_CODE = "bnummer";

    @JsonProperty
    @XmlElement
    @Column(name = DB_FIELD_CODE)
    private String code;


    public static final String DB_FIELD_TYPE = "b_type";
    public static final String IO_FIELD_TYPE = "husnummer";

    @JsonProperty
    @XmlElement
    @Column(name = DB_FIELD_TYPE)
    private String b_type;


    public static final String DB_FIELD_CALLNAME = "b_callname";
    public static final String IO_FIELD_CALLNAME = "husnummer";

    @JsonProperty
    @XmlElement
    @Column(name = DB_FIELD_CALLNAME)
    private String b_callname;


    public static final String DB_FIELD_LOCATION = "houseNumber";
    public static final String IO_FIELD_LOCATION = "husnummer";

    @JsonProperty
    @XmlElement
    @ManyToOne
    @JoinColumn(name = DB_FIELD_LOCATION + DatabaseEntry.REF)
    private Identification location;


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
        map.put("code", this.code);
        map.put("b_type", this.b_type);
        map.put("b_callname", this.b_callname);
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
