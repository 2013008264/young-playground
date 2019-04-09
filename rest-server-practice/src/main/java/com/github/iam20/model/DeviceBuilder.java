package com.github.iam20.model;

public class DeviceBuilder {
	private Device device;

	public DeviceBuilder() {
		device = new Device();
	}

	public static DeviceBuilder create() {
		return new DeviceBuilder();
	}

	public DeviceBuilder id(Integer id) {
		device.setId(id);
		return this;
	}

	public DeviceBuilder state(String state) {
		device.setState(state);
		return this;
	}

	public Device build() {
		return device;
	}
}
