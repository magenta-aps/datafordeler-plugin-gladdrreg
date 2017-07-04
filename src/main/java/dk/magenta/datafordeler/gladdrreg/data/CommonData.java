package dk.magenta.datafordeler.gladdrreg.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.magenta.datafordeler.core.database.DataItem;
import dk.magenta.datafordeler.core.database.Effect;
import dk.magenta.datafordeler.core.database.Identification;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;

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

    @ManyToOne
    @JsonProperty
    @XmlElement
    private Identification state;

    @Override
    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("active", this.active);
        map.put("note", this.note);
        map.put("registration_user", this.registration_user);
        map.put("state", this.state);
        return map;
    }

    @Override
    @JsonIgnore
    public HashMap<String, Identification> getReferences() {
        HashMap<String, Identification> references = super.getReferences();
        references.put("state", this.state);
        return references;
    }

    @Override
    public void updateReferences(HashMap<String, Identification> references) {
        super.updateReferences(references);
        if (references.containsKey("state")) {
            this.state = references.get("state");
        }
    }

    @Override
    public void forceLoad(Session session) {
    }
}
