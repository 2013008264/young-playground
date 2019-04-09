package com.github.iam20;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

import com.github.iam20.config.DbConfig;
import org.json.JSONException;
import com.sun.net.httpserver.HttpServer;

public class Server {

	private static int port = 8282;
	private static HttpServer server;

	public static void main(String args[]) throws IOException {
		DbConfig.dataSourceInit();
		server = HttpServer.create(new InetSocketAddress(port), 100); // backlog num is 100
		server.createContext("/mir-iot/", (ex) -> {
			String methodType = ex.getRequestMethod();
			URI uri = ex.getRequestURI();
			String[] uriParse = uri.toString().split("/");
			if (methodType.equals("GET")) {
				String firstResource = uriParse[2];
				switch (firstResource) {
					case "devices":
						try {
							RestHandler.getDeivceInfo(ex);
						} catch (JSONException e) {
							e.printStackTrace();
							RestHandler.notFoundMessage(ex);
						}
						break;
					default:
						try {
							RestHandler.notFoundMessage(ex);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}

			} else if (methodType.equals("PUT")) {
				String firstResource = uriParse[2];
				switch (firstResource) {
					case "devices" :
						String id = uriParse[3];
						try {
							RestHandler.putControlState(ex, id);
						} catch (JSONException e) {
							RestHandler.notFoundMessage(ex);
							e.printStackTrace();
						}
						break;
					default :
						RestHandler.notFoundMessage(ex);
				}
			} else if (methodType.equals("POST")) {
				String firstResource = uriParse[2];
				switch (firstResource) {
					case "devices" :
						try {
							RestHandler.postDeviceInfo(ex);
						} catch (JSONException e) {
							RestHandler.notFoundMessage(ex);
							e.printStackTrace();
						}
						break;
					default :
						RestHandler.notFoundMessage(ex);
				}
			} else {
				RestHandler.notFoundMessage(ex);
			}
		});

		System.out.println("### Rest Server ON... ");

		server.start();

	}

}
