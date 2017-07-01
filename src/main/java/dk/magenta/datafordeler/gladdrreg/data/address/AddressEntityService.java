package dk.magenta.datafordeler.gladdrreg.data.address;

import dk.magenta.datafordeler.core.exception.AccessDeniedException;
import dk.magenta.datafordeler.core.exception.AccessRequiredException;
import dk.magenta.datafordeler.core.fapi.FapiService;
import dk.magenta.datafordeler.core.user.DafoUserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lars on 19-05-17.
 */
@Controller
@RequestMapping("/gladdrreg/address/1/rest")
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
    protected void checkAccess(DafoUserDetails dafoUserDetails) throws AccessDeniedException, AccessRequiredException {
    }

    @Override
    protected AddressQuery getEmptyQuery() {
        return new AddressQuery();
    }

}
