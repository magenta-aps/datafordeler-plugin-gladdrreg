package dk.magenta.datafordeler.gladdreg.data.postalcode;

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
    protected PostalCodeQuery getEmptyQuery() {
        return new PostalCodeQuery();
    }

}
