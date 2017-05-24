package dk.magenta.datafordeler.gladdreg.data.bnumber;

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
    protected BNumberQuery getEmptyQuery() {
        return new BNumberQuery();
    }

}
