package dk.magenta.datafordeler.gladdrreg.data.locality;

import dk.magenta.datafordeler.core.exception.AccessDeniedException;
import dk.magenta.datafordeler.core.exception.AccessRequiredException;
import dk.magenta.datafordeler.core.fapi.FapiService;
import dk.magenta.datafordeler.core.user.DafoUserDetails;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.ws.rs.Path;

/**
 * Created by lars on 19-05-17.
 */
@Path("")
@Component
@WebService
public class LocalityEntityService extends FapiService<LocalityEntity, LocalityQuery> {

    @Override
    protected void checkAccess(DafoUserDetails dafoUserDetails) throws AccessDeniedException, AccessRequiredException {

    }

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
    protected LocalityQuery getEmptyQuery() {
        return new LocalityQuery();
    }

}
