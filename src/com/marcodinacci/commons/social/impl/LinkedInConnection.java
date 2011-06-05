package com.marcodinacci.commons.social.impl;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import android.content.ContentValues;
import android.net.Uri;

import com.marcodinacci.commons.social.Connection;
import com.marcodinacci.commons.social.Location;
import com.marcodinacci.commons.social.impl.LinkedInLocation;

@Root(name="person")
public class LinkedInConnection implements Connection {
	
	@Element(name="id")
	private String mId;
	
	@Element(name="last-name")
	private String mLastName;
	
	@Element(name="first-name")
	private String mFirstName;
	
	@Element(name="headline")
	private String mHeadline;
	
	@Element(name="location")
	private LinkedInLocation mLocation;
	
	/*
	@Element(name="")
	private String url;
	
	@Element(name="picture-url")
	private String mPicUrl;
	
	*/
	
	@Override
	public String getId() {
		return mId;
	}
	
	@Override
	public String getFirstName() {
		return mFirstName;
	}

	@Override
	public String getLastName() {
		return mLastName;
	}

	@Override
	public String getHeadline() {
		return mHeadline;
	}

	@Override
	public Location getLocation() {
		return mLocation;
	}

	@Override
	public Uri getUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri getPictureUri() {
		return null; //return Uri.parse(mPicUrl);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nID: " + mId);
		sb.append("\nFirst name: " + mFirstName);
		sb.append("\nLast name: " + mLastName);
		sb.append("\nHeadline: " + mHeadline);
		sb.append("\nLocation : " + mLocation.toString());
		
		return sb.toString();
		
	}

	/* See sql.xml for column names */
	@Override
	public ContentValues toContentValues() {
		ContentValues values = new ContentValues();
		
		values.put(KEY_LINKEDIN_ID, mId);
		values.put(KEY_FIRST_NAME, mFirstName);
		values.put(KEY_LAST_NAME, mLastName);
		values.put(KEY_HEADLINE, mHeadline);
		values.put(KEY_LOCATION, mLocation.toString());
		//values.put("pic_uri", "");
		//values.put("web_uris", "");
		
		return values;
	}
}
