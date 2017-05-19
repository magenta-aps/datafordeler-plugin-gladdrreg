package dk.magenta.datafordeler.gladdreg.data;

import dk.magenta.datafordeler.core.fapi.Query;
import dk.magenta.datafordeler.core.util.ListHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public abstract class CommonQuery extends Query {

    public static final String ACTIVE = "active";
    public static final String NOTE = "note";
    public static final String REGISTRATION_USER = "registration_user";
    public static final String STATE = "state";

    // Contain all fields that are searchable

    private Boolean active;

    private String note;

    private String registration_user;

    private String state;

    public boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRegistration_user() {
        return registration_user;
    }

    public void setRegistration_user(String registration_user) {
        this.registration_user = registration_user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public Map<String, Object> getSearchParameters() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("active", this.active);
        map.put("note", this.note);
        map.put("registration_user", this.registration_user);
        map.put("state", this.state);
        return map;
    }

    @Override
    public void setFromParameters(ListHashMap<String, String> listHashMap) {
        this.setActive(Query.booleanFromString(listHashMap.getFirst(ACTIVE)));
        this.setNote(listHashMap.getFirst(NOTE));
        this.setRegistration_user(listHashMap.getFirst(REGISTRATION_USER));
        this.setState(listHashMap.getFirst(STATE));
    }
}
