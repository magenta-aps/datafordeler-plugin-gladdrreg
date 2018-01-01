package dk.magenta.datafordeler.gladdrreg.data.district;

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
@Table(name="gladdrreg_district_data", indexes = {
        @Index(name = "gladdrreg_district_code", columnList = "code"),
        @Index(name = "gladdrreg_district_abbrev", columnList = "abbrev"),
        @Index(name = "gladdrreg_district_name", columnList = "name")
})
public class DistrictData extends SumiffiikData<DistrictEffect, DistrictData> {

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

    @Override
    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<>(super.asMap());
        map.put("code", this.code);
        map.put("abbrev", this.abbrev);
        map.put("name", this.name);
        return map;
    }
}
