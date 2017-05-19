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
public class SumiffiikData<V extends Effect, D extends DataItem> extends CommonData<V, D> {

    @Column
    @JsonProperty
    @XmlElement
    private String sumiffiik;

    @Column
    @JsonProperty
    @XmlElement
    private String sumiffiik_domain;

    @Override
    public Map<String, Object> asMap() {
        HashMap<String, Object> map = new HashMap<>(super.asMap());
        map.put("sumiffiik", this.sumiffiik);
        map.put("sumiffiik_domain", this.sumiffiik_domain);
        return map;
    }
}
