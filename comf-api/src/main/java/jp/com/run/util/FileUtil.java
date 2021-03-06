package jp.com.run.util;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import jp.com.run.common.Constants;

/**
 * The Class FileUtil.
 */
public class FileUtil {

	/**
	 * Gets the resource path.
	 *
	 * @return the resource path
	 */
	public static String getResourcePath() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(FileUtil.class.getClassLoader().getResource(Constants.CONST_STR_BLANK).getFile());
		
		return builder.toString();
	}
	
	/**
	 * Gets the file path resource.
	 *
	 * @param fileName the file name
	 * @return the file path resource
	 */
	public static String getFilePathResource(String fileName) {
		
		StringBuilder builder = new StringBuilder();
		
		URL url = FileUtil.class.getClassLoader().getResource(fileName);
		
		if (fileName == null || fileName.isEmpty() || url == null) {
			return builder.toString();
		}
		
		builder.append(url.getFile());
		
		return builder.toString();
	}
	
	/**
	 * Load file.
	 *
	 * @param folder the folder
	 * @param name the name
	 * @return the file
	 */
	public static File getFile(String folder, String name) {

		if (name == null || name.isEmpty() || folder == null || folder.isEmpty()) {
			return null;
		}

		File file = new File(folder, name);

		if (file.exists() && file.isFile()) {
			return file;
		}

		return null;
	}
	
	public static Resource download(String name) {
	    try {
    	    Path path = Paths.get("/home/datnguyen/temp", name);
    	    Resource resource = new UrlResource(path.toUri());
    	    if (resource.exists()) {
    	        return resource;
    	    }
	    } catch (Exception e) {
        }
	    return null;
	}
}
