package dk.magenta.datafordeler.gladdreg.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.core.database.DataItem;
import dk.magenta.datafordeler.core.database.Effect;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
@MappedSuperclass
public class CommonData<V extends Effect, D extends DataItem> extends DataItem<V, D> {

    @Column
    @JsonProperty
    @XmlElement
    private boolean active;

    @Column
    @JsonProperty
    @XmlElement
    private String note;

    @Column
    @JsonProperty
    @XmlElement
    private String registration_user;

    @Column
    @JsonProperty
    @XmlElement
    private int state;

    @Override
    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("active", this.active);
        map.put("note", this.note);
        map.put("registration_user", this.registration_user);
        map.put("state", this.state);
        return map;
    }
}
