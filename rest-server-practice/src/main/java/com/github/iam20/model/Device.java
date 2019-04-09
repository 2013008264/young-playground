package com.github.iam20.model;

public class Device {
	private Integer id;
	private String state;

	public Device() {
	}

	public Device(Integer id) {
		this.id = id;
	}

	public Device(String state) {
		this.state = state;
	}

	public Device(Integer id, String state) {
		this.id = id;
		this.state = state;
	}

	public static DeviceBuilder builder() {
		return new DeviceBuilder();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "{ \"id\" : \"" + id + "\" , \"state\" : \"" + state + "\" }";
	}
}
