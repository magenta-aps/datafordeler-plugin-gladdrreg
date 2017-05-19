package dk.magenta.datafordeler.gladdreg.data.municipality;

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
public class MunicipalityEntityService extends FapiService<MunicipalityEntity, MunicipalityQuery> {

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getServiceName() {
        return "municipality";
    }

    @Override
    protected Class<MunicipalityEntity> getEntityClass() {
        return MunicipalityEntity.class;
    }

    @Override
    protected MunicipalityQuery getEmptyQuery() {
        return new MunicipalityQuery();
    }

}
