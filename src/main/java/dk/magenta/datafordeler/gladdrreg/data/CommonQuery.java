package dk.magenta.datafordeler.gladdrreg.data;

import dk.magenta.datafordeler.core.database.Entity;
import dk.magenta.datafordeler.core.database.LookupDefinition;
import dk.magenta.datafordeler.core.fapi.ParameterMap;
import dk.magenta.datafordeler.core.fapi.Query;
import dk.magenta.datafordeler.core.fapi.QueryField;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public abstract class CommonQuery <E extends Entity> extends Query<E> {

    public static final String ACTIVE = "active";
    public static final String NOTE = "note";
    public static final String REGISTRATION_USER = "registration_user";
    public static final String STATE = "state";

    // Contain all fields that are searchable

    @QueryField(type = QueryField.FieldType.BOOLEAN, queryName = ACTIVE)
    private Boolean active;

    @QueryField(type = QueryField.FieldType.STRING, queryName = NOTE)
    private String note;

    @QueryField(type = QueryField.FieldType.STRING, queryName = REGISTRATION_USER)
    private String registration_user;

    @QueryField(type = QueryField.FieldType.STRING, queryName = STATE)
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
    public void setFromParameters(ParameterMap parameters) {
        this.setActive(Query.booleanFromString(parameters.getFirst(ACTIVE)));
        this.setNote(parameters.getFirst(NOTE));
        this.setRegistration_user(parameters.getFirst(REGISTRATION_USER));
        this.setState(parameters.getFirst(STATE));
    }

    @Override
    public LookupDefinition getLookupDefinition() {
        LookupDefinition lookupDefinition = new LookupDefinition(this);
        return lookupDefinition;
    }
}
