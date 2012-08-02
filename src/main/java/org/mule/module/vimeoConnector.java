/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.module;

import org.apache.commons.httpclient.HttpClient;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.oauth.*;
import org.mule.api.annotations.rest.HttpMethod;
import org.mule.api.annotations.rest.RestCall;
import org.mule.api.annotations.rest.RestHttpClient;
import org.mule.api.annotations.rest.RestUriParam;

import java.io.IOException;


/**
 * Cloud Connector
 *
 * @author MuleSoft, Inc.
 */

@OAuth(requestTokenUrl = vimeoConnector.REQUEST_TOKEN_URL,
        accessTokenUrl = vimeoConnector.ACCESS_TOKEN_URL,
        authorizationUrl = vimeoConnector.AUTHORIZATION_URL)
@Connector(name="vimeo", schemaVersion="1.0-SNAPSHOT")
public abstract class vimeoConnector
{

    public static final String REQUEST_TOKEN_URL = "https://vimeo.com/oauth/request_token";
    public static final String AUTHORIZATION_URL = "https://vimeo.com/oauth/access_token";
    public static final String ACCESS_TOKEN_URL = "https://vimeo.com/oauth/access_token";
    public static final String BASE_URI = "http://vimeo.com/api/rest/v2?method=";


    @RestHttpClient
    private HttpClient httpClient;

    /**
     * Configurable
     */
    @Configurable
    @OAuthConsumerKey
    private String vimeoOAuthClientID;

    @Configurable
    @OAuthConsumerSecret
    private String vimeoOAuthClientSecret;


    @OAuthAccessToken
    private String accessToken;

    @OAuthAccessTokenSecret
    private String accessTokenSecret;


    @Processor
    @OAuthProtected
    @RestCall(uri = BASE_URI+"vimeo.test.echo&echo={echoString}", method = HttpMethod.GET)
    public abstract String getTestEcho(@RestUriParam("echoString") String echoString) throws IOException;

    /**
     * Accessor methods
     */

    public HttpClient getHttpClient(){
        return this.httpClient;
    }

    public void setHttpClient(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public String getVimeoOAuthClientID(){
        return this.vimeoOAuthClientID;
    }

    public void setVimeoOAuthClientID(String vimeoOAuthClientID)
    {
        this.vimeoOAuthClientID = vimeoOAuthClientID;
    }

    public String getVimeoOAuthClientSecret(){
        return this.vimeoOAuthClientSecret;
    }
    
    public void setVimeoOAuthClientSecret(String vimeoOAuthClientSecret)
    {
        this.vimeoOAuthClientSecret = vimeoOAuthClientSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
}
