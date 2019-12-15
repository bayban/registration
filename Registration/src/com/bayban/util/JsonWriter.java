package com.bayban.util;

import flexjson.JSONSerializer;

public class JsonWriter {

	public static String objectToJson(Object o) {
		String json = new JSONSerializer().prettyPrint(true).deepSerialize(o);
		return json.replace("\"class\"", "\"@type\"");
	}
	
	public static String objectToJsonForGCM(Object o) {
		String json = new JSONSerializer().exclude("class").prettyPrint(true).deepSerialize(o);
		return json;
	}

	public static String objectToJsonExcludeClass(Object o) {
		String json = new JSONSerializer().exclude("*.class").prettyPrint(true).deepSerialize(o);
		return json;
	}
	
	public static String objectToJsonExcludeNull(Object o) {
		String json = new JSONSerializer().exclude("*.class").transform(new NullExcludeTransformer(), void.class).serialize(o);
		return json;
	}
}
