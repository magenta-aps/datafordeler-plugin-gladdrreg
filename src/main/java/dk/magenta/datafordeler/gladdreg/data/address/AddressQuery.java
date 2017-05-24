package dk.magenta.datafordeler.gladdreg.data.address;

import dk.magenta.datafordeler.core.database.Entity;
import dk.magenta.datafordeler.core.fapi.QueryField;
import dk.magenta.datafordeler.core.util.ListHashMap;
import dk.magenta.datafordeler.gladdreg.data.SumiffiikQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lars on 19-05-17.
 */
public class AddressQuery extends SumiffiikQuery {

    public static final String HOUSE_NUMBER = "houseNumber";
    public static final String FLOOR = "floor";
    public static final String ROOM = "room";

    @QueryField(type = QueryField.FieldType.STRING)
    private String houseNumber;

    @QueryField(type = QueryField.FieldType.STRING)
    private String floor;

    @QueryField(type = QueryField.FieldType.STRING)
    private String room;

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public Map<String, Object> getSearchParameters() {
        HashMap<String, Object> map = new HashMap<>(super.getSearchParameters());
        map.put(HOUSE_NUMBER, this.houseNumber);
        map.put(FLOOR, this.floor);
        map.put(ROOM, this.room);
        return map;
    }

    @Override
    public void setFromParameters(ListHashMap<String, String> listHashMap) {
        super.setFromParameters(listHashMap);
        this.setHouseNumber(listHashMap.getFirst(HOUSE_NUMBER));
        this.setFloor(listHashMap.getFirst(FLOOR));
        this.setRoom(listHashMap.getFirst(ROOM));
    }

    @Override
    public Class<? extends Entity> getEntityClass() {
        return AddressEntity.class;
    }

}
