package com.marcodinacci.social.linkedin.impl;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.marcodinacci.commons.social.Location;

@Root(name="location", strict=false)
public class LinkedInLocation implements Location {

	@Element(name="name")
	private String mLocation;
	
	@Override
	public String getCountry() {
		return "";
	}

	@Override
	public String getTown() {
		return "";
	}

	@Override
	public String toString() {
		return mLocation;
	}
}
