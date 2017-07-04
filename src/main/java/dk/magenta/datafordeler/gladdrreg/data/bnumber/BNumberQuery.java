package dk.magenta.datafordeler.gladdrreg.data.bnumber;

import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.gladdrreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class BNumberQuery extends SumiffiikQuery<BNumberEntity> {

    public static final String CODE = "code";
    public static final String NAME = "name";
    public static final String NICKNAME = "nickname";

    @QueryField(type = QueryField.FieldType.STRING, queryName = CODE)
    private String code;

    @QueryField(type = QueryField.FieldType.STRING, queryName = NAME)
    private String name;

    @QueryField(type = QueryField.FieldType.STRING, queryName = NICKNAME)
    private String nickname;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public Map<String, Object> getSearchParameters() {
        HashMap<String, Object> map = new HashMap<>(super.getSearchParameters());
        map.put(CODE, this.code);
        map.put(NAME, this.name);
        map.put(NICKNAME, this.nickname);
        return map;
    }

    @Override
    public void setFromParameters(ParameterMap parameters) {
        super.setFromParameters(parameters);
        this.setCode(parameters.getFirst(CODE));
        this.setName(parameters.getFirst(NAME));
        this.setNickname(parameters.getFirst(NICKNAME));
    }

    @Override
    public Class<BNumberEntity> getEntityClass() {
        return BNumberEntity.class;
    }

    @Override
    public Class getDataClass() {
        return BNumberData.class;
    }

}
