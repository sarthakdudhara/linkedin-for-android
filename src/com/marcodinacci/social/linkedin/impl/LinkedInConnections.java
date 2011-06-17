package com.marcodinacci.social.linkedin.impl;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.marcodinacci.commons.social.Connections;
import com.marcodinacci.social.linkedin.impl.LinkedInConnection;

@Root(name="connections", strict=false)
public class LinkedInConnections implements Connections {
	
	@ElementList(type=LinkedInConnection.class, entry="person", inline=true)
	private List<LinkedInConnection> people;
	
	@Attribute
	private String total;

	@Override
	public List<LinkedInConnection> getConnections() {
		return people;
	}
	
	public int getCount() {
		return Integer.parseInt(total);
	}
}
