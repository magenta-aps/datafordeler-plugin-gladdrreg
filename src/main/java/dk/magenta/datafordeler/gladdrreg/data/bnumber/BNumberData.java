package dk.magenta.datafordeler.gladdrreg.data.bnumber;

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
@Table(name="gladdrreg_bnumber_data", indexes = {
        @Index(name = "gladdrreg_bnumber_code", columnList = "code")
})
public class BNumberData extends SumiffiikData<BNumberEffect, BNumberData> {

    @Column
    @JsonProperty
    @XmlElement
    private String code;

    @Column
    @JsonProperty
    @XmlElement
    private String b_type;

    @Column
    @JsonProperty
    @XmlElement
    private String b_callname;

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
