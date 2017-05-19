package dk.magenta.datafordeler.gladdreg.data;

import dk.magenta.datafordeler.core.util.ListHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class SumiffiikQuery extends CommonQuery {

    public static final String SUMIFFIIK = "sumiffiik";
    public static final String SUMIFFIIK_DOMAIN = "sumiffiik_domain";

    private String sumiffiik;

    private String sumiffiik_domain;

    public String getSumiffiik() {
        return sumiffiik;
    }

    public void setSumiffiik(String sumiffiik) {
        this.sumiffiik = sumiffiik;
    }

    public String getSumiffiik_domain() {
        return sumiffiik_domain;
    }

    public void setSumiffiik_domain(String sumiffiik_domain) {
        this.sumiffiik_domain = sumiffiik_domain;
    }

    @Override
    public Map<String, Object> getSearchParameters() {
        HashMap<String, Object> map = new HashMap<>(super.getSearchParameters());
        map.put("sumiffiik", this.sumiffiik);
        map.put("sumiffiik_domain", this.sumiffiik_domain);
        return map;
    }

    @Override
    public void setFromParameters(ListHashMap<String, String> listHashMap) {
        super.setFromParameters(listHashMap);
        this.setSumiffiik(listHashMap.getFirst(SUMIFFIIK));
        this.setSumiffiik_domain(listHashMap.getFirst(SUMIFFIIK_DOMAIN));
    }

}
