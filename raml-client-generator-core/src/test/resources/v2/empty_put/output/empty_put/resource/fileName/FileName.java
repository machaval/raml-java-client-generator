
package empty_put.resource.fileName;

import java.net.URLEncoder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import empty_put.exceptions.SimpleApiException;
import empty_put.resource.fileName.model.FileNamePUTHeader;
import empty_put.responses.SimpleApiResponse;

public class FileName {

    private String _baseUrl;
    private Client _client;

    public FileName() {
        _baseUrl = null;
        _client = null;
    }

    public FileName(String baseUrl, Client _client, String uriParam) {
        _baseUrl = (baseUrl +("/"+ URLEncoder.encode(uriParam)));
        this._client = _client;
    }

    protected Client getClient() {
        return this._client;
    }

    private String getBaseUri() {
        return _baseUrl;
    }

    /**
     * Creates or updates the given file
     * 
     */
    public SimpleApiResponse<Void> put(Object body, String mimeType, FileNamePUTHeader headers) {
        WebTarget target = this._client.target(getBaseUri());
        final javax.ws.rs.client.Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
        if (headers.getXBaseCommitId()!= null) {
            invocationBuilder.header("x-base-commit-id", headers.getXBaseCommitId());
        }
        if (headers.getXCommitMessage()!= null) {
            invocationBuilder.header("x-commit-message", headers.getXCommitMessage());
        }
        Response response = invocationBuilder.method("PUT", Entity.entity(body, mimeType));
        if (response.getStatusInfo().getFamily()!= Family.SUCCESSFUL) {
            Response.StatusType statusInfo = response.getStatusInfo();
            throw new SimpleApiException(statusInfo.getStatusCode(), statusInfo.getReasonPhrase(), response.getStringHeaders(), response);
        }
        SimpleApiResponse<Void> apiResponse = new SimpleApiResponse<Void>(null, response.getStringHeaders(), response);
        return apiResponse;
    }

}
