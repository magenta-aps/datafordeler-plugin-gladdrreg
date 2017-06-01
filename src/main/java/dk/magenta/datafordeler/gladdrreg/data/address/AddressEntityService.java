package dk.magenta.datafordeler.gladdrreg.data.address;

import dk.magenta.datafordeler.core.fapi.FapiService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.ws.rs.Path;

/**
 * Created by lars on 19-05-17.
 */
@Path("")
@Component
@WebService
public class AddressEntityService extends FapiService<AddressEntity, AddressQuery> {

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getServiceName() {
        return "address";
    }

    @Override
    protected Class<AddressEntity> getEntityClass() {
        return AddressEntity.class;
    }

    @Override
    protected AddressQuery getEmptyQuery() {
        return new AddressQuery();
    }

}
