package com.bayban.util;

import java.util.Map;

import flexjson.JSONDeserializer;

public class JsonReader {

	public static Object jsonToJava(String json) {
		json = json.replace("\"@type\"", "class");
		return new JSONDeserializer<>().deserialize(json);
	}
	
	@SuppressWarnings("rawtypes")
	public static Map gcmJsonToMap(String jsonString) {
		return new JSONDeserializer<Map>().deserialize(jsonString);
	}
}