/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.kernel.mobile.device;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class represents unknown device
 *
 * @author Milen Dyankov
 * @author Michael C. Han
 */
public class NoKnownDevices implements KnownDevices {

	public static NoKnownDevices getInstance() {
		return _instance;
	}

	public Set<VersionableName> getBrands() {
		return _brands;
	}

	public Set<VersionableName> getBrowsers() {
		return _browsers;
	}

	public Map<Capability, Set<String>> getDeviceIds() {
		return Collections.emptyMap();
	}

	public Set<VersionableName> getOperatingSystems() {
		return _operatingSystems;
	}

	public Set<String> getPointingMethods() {
		return _pointingMethods;
	}

	public void reload() {
	}

	private NoKnownDevices() {
		_brands.add(VersionableName.UNKNOWN);

		_brands = Collections.unmodifiableSet(_brands);

		_browsers.add(VersionableName.UNKNOWN);

		_browsers = Collections.unmodifiableSet(_browsers);

		_operatingSystems.add(VersionableName.UNKNOWN);

		_operatingSystems = Collections.unmodifiableSet(_operatingSystems);

		_pointingMethods.add(VersionableName.UNKNOWN.getName());

		_pointingMethods = Collections.unmodifiableSet(_pointingMethods);
	}

	private static NoKnownDevices _instance = new NoKnownDevices();

	private Set<VersionableName> _brands = new HashSet<VersionableName>();
	private Set<VersionableName> _browsers = new HashSet<VersionableName>();
	private Set<VersionableName> _operatingSystems =
		new HashSet<VersionableName>();
	private Set<String> _pointingMethods = new HashSet<String>();

}