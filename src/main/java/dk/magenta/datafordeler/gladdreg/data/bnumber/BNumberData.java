package dk.magenta.datafordeler.gladdreg.data.bnumber;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.core.database.Identification;
import dk.magenta.datafordeler.gladdreg.data.SumiffiikData;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
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
@Table(name="bnumber_data")
public class BNumberData extends SumiffiikData<BNumberEffect, BNumberData> {

    @Column
    @JsonProperty
    @XmlElement
    private String code;

    @Column
    @JsonProperty
    @XmlElement
    private String name;

    @Column
    @JsonProperty
    @XmlElement
    private String nickname;

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
        map.put("nickname", this.nickname);
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
