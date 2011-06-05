package com.marcodinacci.commons.social.impl;

import java.net.URI;
import java.util.List;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import android.net.Uri;

import com.marcodinacci.commons.auth.OAuthConnector;
import com.marcodinacci.commons.auth.OAuthable;
import com.marcodinacci.commons.data.impl.XMLUnmarshaller;

public class LinkedInConnector implements OAuthConnector, OAuthable {

	private static final String ERROR_AUTH = "Access token missing";
	private static final String GET_CONNECTIONS_QUERY = 
		"http://api.linkedin.com/v1/people/~/connections";
	
	private OAuthService mService;
	private Token mRequestToken;
	private Token mAccessToken;

	public LinkedInConnector(String apiKey, String apiSecret, String callback) {
		mService = new ServiceBuilder()
        .provider(LinkedInApi.class)
        .apiKey(apiKey)
        .apiSecret(apiSecret)
        .callback(callback).build();
	}
	
	@Override
	public Response get(String query) {
		OAuthRequest request = new OAuthRequest(Verb.GET, query);
		mService.signRequest(mAccessToken, request);
		Response response = request.send();
		
		return response;
	}

	@Override
	public Response post(String query) {
		return null;
	}

	public List<LinkedInConnection> getConnections() {
		assertIsAuthorized();
		
		Response response = get(GET_CONNECTIONS_QUERY);
		String xml = response.getBody();
		
		//Log.d(TAG, xml);
		
		List<LinkedInConnection> connsList = null;
		XMLUnmarshaller<LinkedInConnections> unmarshaller = 
			new XMLUnmarshaller<LinkedInConnections>();
		try {
			LinkedInConnections conns = unmarshaller.unmarshal(LinkedInConnections.class, xml);
			connsList = conns.getConnections();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return connsList;
	}

	@Override
	public Token getRequestToken() {
		if(mRequestToken == null)
			setRequestToken(mService.getRequestToken());
		
		return mRequestToken;
	}
	
	@Override 
	public Token getAccessToken(Uri uri) {
		if(mAccessToken == null) {
			if(mRequestToken == null)
				getRequestToken();
			Verifier v = new Verifier(uri.getQueryParameter("oauth_verifier"));
			mAccessToken = mService.getAccessToken(mRequestToken, v);
		}
		
		return mAccessToken;
	}
	
	public void getAccessToken(URI accessTokenURI) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String getAuthorizationUrl() {
		return mService.getAuthorizationUrl(getRequestToken());
	}
	
	public Uri getAuthorizationURI() {
		return Uri.parse(getAuthorizationUrl());
	}
	
	public void setRequestToken(Token requestToken) {
		mRequestToken = requestToken;
	}

	public String getConnectionsRaw() {
		assertIsAuthorized();
		
		Response response = get(GET_CONNECTIONS_QUERY);
		
		return response.getBody();
	}

	private void assertIsAuthorized() {
		if(mAccessToken == null)
			throw new IllegalStateException(ERROR_AUTH);
	}
}