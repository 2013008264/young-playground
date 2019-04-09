package com.github.iam20;

import static com.github.iam20.model.DeviceDao.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.net.URI;
import java.util.List;

import com.github.iam20.model.Device;
import com.github.iam20.model.DeviceBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestHandler {
	private static final Logger log = LoggerFactory.getLogger(RestHandler.class);
	private static Headers headers;
	private static InputStreamReader isr;
	private static BufferedReader br;
	private static String query;

	public static HashMap<String, String> deviceData = new HashMap<>();

	private static void initExchangeInformation(HttpExchange ex) throws IOException {
		headers = ex.getRequestHeaders();
		isr = new InputStreamReader(ex.getRequestBody(), "utf-8");
		br = new BufferedReader(isr);

		StringBuilder buf = new StringBuilder();
		while (br.ready()) {
			buf.append((char)br.read());
		}
		query = buf.toString();

		log.info("SERVER URI TEST : {}", ex.getRequestURI());
		log.info("SERVER HEADER TEST : {}", headers.toString());
		log.info("SERVER METHOD TEST : {}", ex.getRequestMethod());
		log.info("SERVER QUERY TEST : {}", query);
	}

	public static void getDeivceInfo(HttpExchange ex) throws IOException, JSONException {
		initExchangeInformation(ex);
		List<Device> devices = getDevices();
		JSONArray jsonObject = new JSONArray(devices);


		log.info("Send below message");
		log.info(jsonObject.toString());
		OutputStream out;

		ex.sendResponseHeaders(200, 0);
		out = ex.getResponseBody();
		out.write(jsonObject.toString().getBytes());
		out.close();
	}

	public static void postDeviceInfo(HttpExchange ex) throws IOException {
		initExchangeInformation(ex);
		JSONObject json = new JSONObject(query);
		String state = json.get("state").toString();

		log.info("### device state check : {}", state);
		int numRow = insertDevice(state);

		sendResponseForPutPost(ex, json, numRow);
	}


	public static void putControlState(HttpExchange ex, String id) throws IOException, JSONException {
		initExchangeInformation(ex);
		JSONObject json = new JSONObject(query);

		String state = json.get("state").toString();

		log.info("### device id check : {}", id);
		log.info("### device state check : {}", state);

		Device device = DeviceBuilder.create()
				.id(Integer.parseInt(id))
				.state(state)
				.build();

		int numRow = updateDevice(device);
		JSONObject jsonObject = new JSONObject(device);

		sendResponseForPutPost(ex, jsonObject, numRow);
	}

	private static void sendResponseForPutPost(HttpExchange ex, JSONObject jsonObject, int numRow) throws IOException {
		OutputStream out;
		if (numRow == 0) {
			ex.sendResponseHeaders(404, 0);
			out = ex.getResponseBody();
			out.write("{ NOT FOUND }".getBytes());
			out.close();
		} else {
			ex.sendResponseHeaders(200, 0);
			out = ex.getResponseBody();
			out.write(jsonObject.toString().getBytes());
			out.close();
		}
	}

	public static void notFoundMessage(HttpExchange ex) throws IOException, JSONException {
		initExchangeInformation(ex);
		String wrongMsg = "Not Found";
		ex.sendResponseHeaders(404, 0);
		OutputStream out = ex.getResponseBody();

		// Headers responHead = ex.getResponseHeaders();
		out.write(wrongMsg.getBytes());
		out.close();
	}
}
