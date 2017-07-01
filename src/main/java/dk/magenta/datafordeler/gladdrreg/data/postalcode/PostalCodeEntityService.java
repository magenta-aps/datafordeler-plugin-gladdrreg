package dk.magenta.datafordeler.gladdrreg.data.postalcode;

import dk.magenta.datafordeler.core.exception.AccessDeniedException;
import dk.magenta.datafordeler.core.exception.AccessRequiredException;
import dk.magenta.datafordeler.core.fapi.FapiService;
import dk.magenta.datafordeler.core.user.DafoUserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lars on 19-05-17.
 */
@RestController
@RequestMapping("/gladdrreg/postcode/1/rest")
public class PostalCodeEntityService extends FapiService<PostalCodeEntity, PostalCodeQuery> {

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getServiceName() {
        return "postalcode";
    }

    @Override
    protected Class<PostalCodeEntity> getEntityClass() {
        return PostalCodeEntity.class;
    }

    @Override
    protected void checkAccess(DafoUserDetails dafoUserDetails) throws AccessDeniedException, AccessRequiredException {
    }

    @Override
    protected PostalCodeQuery getEmptyQuery() {
        return new PostalCodeQuery();
    }

}
