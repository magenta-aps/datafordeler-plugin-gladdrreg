package dk.magenta.datafordeler.gladdrreg.data.district;

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
public class DistrictEntityService extends FapiService<DistrictEntity, DistrictQuery> {

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getServiceName() {
        return "district";
    }

    @Override
    protected Class<DistrictEntity> getEntityClass() {
        return DistrictEntity.class;
    }

    @Override
    protected DistrictQuery getEmptyQuery() {
        return new DistrictQuery();
    }

}
