package dk.magenta.datafordeler.gladdrreg.data.state;

import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikData;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 16-05-17.
 */
@javax.persistence.Entity
@Table(name="gladdrreg_state_data", indexes = {
        @Index(name = "gladdrreg_state_code", columnList = "code"),
        @Index(name = "gladdrreg_state_name", columnList = "name"),
        @Index(name = "gladdrreg_state_description", columnList = "description")
})
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
