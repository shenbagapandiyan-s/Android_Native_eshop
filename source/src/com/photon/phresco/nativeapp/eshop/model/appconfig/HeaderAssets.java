/*
 * ###
 * PHR_AndroidNative
 * %%
 * Copyright (C) 1999 - 2012 Photon Infotech Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ###
 */

/*
 * Classname: HeaderAssets
 * Version information: 1.0
 * Date: Nov 24, 2011
 * Copyright notice:
 */
package com.photon.phresco.nativeapp.eshop.model.appconfig;


/**
 * Holds the HeaderAssets information of JSON object read from web server
 * @author viral_b
 *
 */
public class HeaderAssets {

	private String name;
	private String urlValue;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the urlValue
	 */
	public String getUrlValue() {
		return urlValue;
	}

	/**
	 * @param urlValue the urlValue to set
	 */
	public void setUrlValue(String urlValue) {
		this.urlValue = urlValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HeaderAssets [name=");
		builder.append(name);
		builder.append(", urlValue=");
		builder.append(urlValue);
		builder.append("]");
		return builder.toString();
	}

}
