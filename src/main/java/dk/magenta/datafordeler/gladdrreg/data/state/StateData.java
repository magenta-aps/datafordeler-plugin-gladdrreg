package dk.magenta.datafordeler.gladdrreg.data.state;

import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikData;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="state_data")
public class StateData extends SumiffiikData<StateEffect, StateData> {

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
    private String description;

    @Override
    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<>(super.asMap());
        map.put("code", this.code);
        map.put("name", this.name);
        map.put("description", this.description);
        return map;
    }

}
