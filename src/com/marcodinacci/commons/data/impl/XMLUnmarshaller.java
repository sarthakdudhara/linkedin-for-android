package com.marcodinacci.commons.data.impl;

import org.simpleframework.xml.core.Persister;

import com.marcodinacci.commons.data.Unmarshaller;
import com.marcodinacci.commons.data.UnmarshallerException;

public final class XMLUnmarshaller<T> implements Unmarshaller<T> {
	private static Persister mSerializer;

	public XMLUnmarshaller() {
		mSerializer = new Persister();
	}

	@Override
	public T unmarshal(Class<T> rootClass, String data)
			throws UnmarshallerException {
		try {
			// FIXME strict must be true
			return mSerializer.read(rootClass, data, false);
		} catch (Exception e) {
			throw new UnmarshallerException(e.getStackTrace());
		}
	}
}
