
package list.resource.users;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import list.exceptions.FooException;
import list.resource.users.model.UsersGETResponseBody;
import list.responses.FooResponse;

public class Users {

    private String _baseUrl;
    private Client _client;

    public Users() {
        _baseUrl = null;
        _client = null;
    }

    public Users(String baseUrl, Client _client) {
        _baseUrl = (baseUrl +"/users");
        this._client = _client;
    }

    protected Client getClient() {
        return this._client;
    }

    private String getBaseUri() {
        return _baseUrl;
    }

    /**
     * Returns the list of all users
     * 
     */
    public FooResponse<List<UsersGETResponseBody>> get() {
        WebTarget target = this._client.target(getBaseUri());
        final javax.ws.rs.client.Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        if (response.getStatusInfo().getFamily()!= Family.SUCCESSFUL) {
            Response.StatusType statusInfo = response.getStatusInfo();
            throw new FooException(statusInfo.getStatusCode(), statusInfo.getReasonPhrase());
        }
        FooResponse<List<UsersGETResponseBody>> apiResponse = new FooResponse<List<UsersGETResponseBody>>(response.readEntity(new GenericType<List<UsersGETResponseBody>>() {


        }
        ), response.getStringHeaders(), response);
        return apiResponse;
    }

}
