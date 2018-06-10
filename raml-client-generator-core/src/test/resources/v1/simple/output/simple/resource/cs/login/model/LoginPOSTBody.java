
package simple.resource.cs.login.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "access_token",
    "token_type"
})
public class LoginPOSTBody {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("access_token")
    private String accessToken;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("token_type")
    private String tokenType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginPOSTBody() {
    }

    /**
     * 
     * @param accessToken
     * @param tokenType
     */
    public LoginPOSTBody(String accessToken, String tokenType) {
        super();
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public LoginPOSTBody withAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("token_type")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public LoginPOSTBody withTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public LoginPOSTBody withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("accessToken", accessToken).append("tokenType", tokenType).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(accessToken).append(tokenType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LoginPOSTBody) == false) {
            return false;
        }
        LoginPOSTBody rhs = ((LoginPOSTBody) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(accessToken, rhs.accessToken).append(tokenType, rhs.tokenType).isEquals();
    }

}
