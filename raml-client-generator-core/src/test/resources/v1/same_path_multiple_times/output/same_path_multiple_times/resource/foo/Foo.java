
package same_path_multiple_times.resource.foo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import same_path_multiple_times.exceptions.FooException;
import same_path_multiple_times.resource.foo.a.A;
import same_path_multiple_times.resource.foo.b.B;

public class Foo {

    private String _baseUrl;
    private Client _client;
    public final A a;
    public final B b;

    public Foo() {
        _baseUrl = null;
        _client = null;
        a = null;
        b = null;
    }

    public Foo(String baseUrl, Client _client) {
        _baseUrl = (baseUrl +"/foo");
        this._client = _client;
        a = new A(getBaseUri(), getClient());
        b = new B(getBaseUri(), getClient());
    }

    protected Client getClient() {
        return this._client;
    }

    private String getBaseUri() {
        return _baseUrl;
    }

    public same_path_multiple_times.resource.foo.model.FooGETResponse get() {
        WebTarget target = this._client.target(getBaseUri());
        final javax.ws.rs.client.Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        if (response.getStatusInfo().getFamily()!= Family.SUCCESSFUL) {
            Response.StatusType statusInfo = response.getStatusInfo();
            throw new FooException(statusInfo.getStatusCode(), statusInfo.getReasonPhrase(), response.getStringHeaders(), response);
        }
        return response.readEntity(same_path_multiple_times.resource.foo.model.FooGETResponse.class);
    }

}
