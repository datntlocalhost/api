package jp.co.run.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The Class ResponseUtil.
 */
public class ResponseUtil {
	
	/** The Constant RESULT_KEY. */
	private static final String RESULT_KEY = "result";
	
	/** The Constant ERROR_KEY. */
	private static final String ERROR_KEY  = "error";

	/**
	 * Creates the result.
	 *
	 * @param data the data
	 * @return the map
	 */
	public static Map<String, Object> createResult(@JsonSerialize Object data) {
		
		Map<String, Object> response = new HashMap<>();
		
		response.put(RESULT_KEY, data);
		
		return response;
	}
	
	/**
	 * Creates the error.
	 *
	 * @param error the error
	 * @return the map
	 */
	public static Map<String, Object> createError(@JsonSerialize Object error) {
		
		Map<String, Object> response = new HashMap<>();
		
		response.put(ERROR_KEY, error);
		
		return response;
	}
}
