package dk.magenta.datafordeler.gladdrreg.data.bnumber;

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
@RequestMapping("/gladdrreg/bnumber/1/rest")
public class BNumberEntityService extends FapiService<BNumberEntity, BNumberQuery> {

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getServiceName() {
        return "bnumber";
    }

    @Override
    protected Class<BNumberEntity> getEntityClass() {
        return BNumberEntity.class;
    }

    @Override
    protected void checkAccess(DafoUserDetails dafoUserDetails) throws AccessDeniedException, AccessRequiredException {
    }

    @Override
    protected BNumberQuery getEmptyQuery() {
        return new BNumberQuery();
    }

}
