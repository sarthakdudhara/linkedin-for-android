package com.marcodinacci.commons.auth;

import org.scribe.model.Response;

/**
 * Perform GET and POST requests returning a Response object.
 */
public interface OAuthConnector {

	public Response get(String query);

	public Response post(String query);
}
