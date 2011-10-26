package com.marcodinacci.commons.social;

import com.marcodinacci.commons.social.Location;

import android.content.ContentValues;
import android.net.Uri;

public interface Connection {

	public static final String KEY_CONNECTION_ID = "_id";
	public static final String KEY_LINKEDIN_ID = "linkedin_id";
	public static final String KEY_FIRST_NAME = "first_name";
	public static final String KEY_LAST_NAME = "last_name";
	public static final String KEY_PHONE = "phones";
	public static final String KEY_ADDRESS = "address";
	public static final String KEY_LOCATION = "location";
	public static final String KEY_HEADLINE = "headline";
	public static final String KEY_EMAIL = "email";
	public static final String KEY_WWW_URIS = "www_uris";
	public static final String KEY_PIC_URI = "pic_uri";
	public static final String KEY_NOTES = "notes";
	
	public String getId();
	
	public String getFirstName();
	
	public String getLastName();
	
	public String getHeadline();
	
	public Location getLocation();
	
	/* TODO change to getUris ? */
	public Uri getUri();
	
	public Uri getPictureUri();

	/**
	 * Returns the current connection as a <b>ContentValues</b> object in order
	 * to insert it in a database.
	 * 
	 * @return the ContentValues object.
	 */
	public ContentValues toContentValues();
}
