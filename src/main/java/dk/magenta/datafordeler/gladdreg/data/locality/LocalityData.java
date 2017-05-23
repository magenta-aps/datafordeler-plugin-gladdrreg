package dk.magenta.datafordeler.gladdreg.data.locality;

import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.gladdreg.data.SumiffiikData;

import javax.persistence.Column;
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



    @Column
    @JsonProperty(required = false)
    @XmlElement
    private int municipality;

    @Column
    @JsonProperty(required = false)
    @XmlElement
    private int district;

    @Column
    @JsonProperty(value="postal_code", required = false)
    @XmlElement
    private int postalCode;


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
}
