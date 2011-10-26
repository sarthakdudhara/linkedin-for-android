package com.marcodinacci.commons.auth;

import org.scribe.model.Token;

import android.net.Uri;

/**
 * Interface to implement for services that uses the OAuth authorization scheme.
 */
public interface OAuthable {
	
	/**
	 * Get the request token, this must be called first.
	 * @return the request Token
	 */
	public Token getRequestToken();
	
	/**
	 * Get the access token, this must be called after obtaining the request token.
	 * @param uri
	 * @return the access Token.
	 */
	public Token getAccessToken(Uri uri);
	
	/**
	 * Get the authorization endpoint 
	 * @return a String describing the endpoint.
	 */
	public String getAuthorizationUrl();
}