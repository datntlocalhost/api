package jp.app.run.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	/*
	 * Convert object to json string.
	 * 
	 * @param obj.
	 *        The object want to convert to json string.
	 * @return string
	 *         The json string.
	 */
	public static String ObjectToJson(Object obj) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			stringBuilder.append(objectMapper.writeValueAsString(obj));
		} catch (JsonProcessingException e) {}
		
		return stringBuilder.toString();
	}
}
