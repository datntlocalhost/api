package jp.com.run.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**
 * The Class LibraryUtil.
 */
public class YamlUtil {

	/**
	 * Load yaml to object.
	 *
	 * @param pathFileYaml the path file yaml
	 * @param clazz the clazz
	 * @return the object
	 */
	public static Object loadYamlToObject(String pathFileYaml, Class<?> clazz) {
		
		InputStream stream = null;
		
		Object obj = null;
		
		if (pathFileYaml == null || clazz == null) {
			return null;
		}
		
		try {
			
			Yaml yaml = new Yaml(new Constructor(clazz));
		
			stream = new FileInputStream(new File(pathFileYaml));
			
			obj = yaml.load(stream);
			
		} catch (Exception e) {
			
		} finally {
			try {
				stream.close();
			} catch (Exception e) {}
		}
		
		return obj;
	}
}
