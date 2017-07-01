package dk.magenta.datafordeler.gladdrreg.data.locality;

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
@RequestMapping("/gladdrreg/locality/1/rest")
public class LocalityEntityService extends FapiService<LocalityEntity, LocalityQuery> {

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getServiceName() {
        return "locality";
    }

    @Override
    protected Class<LocalityEntity> getEntityClass() {
        return LocalityEntity.class;
    }

    @Override
    protected void checkAccess(DafoUserDetails dafoUserDetails) throws AccessDeniedException, AccessRequiredException {
    }

    @Override
    protected LocalityQuery getEmptyQuery() {
        return new LocalityQuery();
    }

}
