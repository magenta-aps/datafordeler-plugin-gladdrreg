package dk.magenta.datafordeler.gladdrreg.data.state;

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
public class StateEntityService extends FapiService<StateEntity, StateQuery> {

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getServiceName() {
        return "state";
    }

    @Override
    protected Class<StateEntity> getEntityClass() {
        return StateEntity.class;
    }

    @Override
    protected StateQuery getEmptyQuery() {
        return new StateQuery();
    }

}
