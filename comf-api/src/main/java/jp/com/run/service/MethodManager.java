package jp.com.run.service;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.com.run.model.ClassModel;
import jp.com.run.model.LibraryModel;
import jp.com.run.model.MethodModel;
import jp.com.run.model.MethodParamModel;
import jp.com.run.util.FileUtil;
import jp.com.run.util.YamlUtil;

/**
 * The Class MethodManager.
 */
public class MethodManager {

    /** The Constant YAML_FILE_NAME. */
    private static final String[] YAML_FILE_NAME = {"string-validation.yml", "date-validation.yml", "number-validation.yml"};

    /** The Constant JAR_FILE_NAME. */
    private static final String JAR_FILE_NAME = "ValidationCommon.jar";

    /** The instance. */
    private static MethodManager instance;

    /** The library. */
    private LibraryModel library;

    /** The methods. */
    private Map<Class<?>, Map<String, Method>> methods;

    /** The is loading. */
    private boolean isLoading;

    /**
     * Instantiates a new method manager.
     */
    private MethodManager() {
        this.isLoading = false;
        init();
    }

    /**
     * Gets the single instance of MethodManager.
     *
     * @return single instance of MethodManager
     */
    public static MethodManager getInstance() {
        if (instance == null) {
            instance = new MethodManager();
        }
        return instance;
    }

    /**
     * Inits the.
     */
    public void init() {
        if (this.isLoading) {
            return;
        }

        this.isLoading = true;

        this.cleanUp();
        this.loadLibrary();
        this.loadMethod();

        this.isLoading = false;
    }

    /**
     * Gets the all class.
     *
     * @return the all class
     */
    public List<ClassModel> getAllClass() {

        if (this.library == null || this.library.getClazz() == null) {
            return new ArrayList<ClassModel>();
        }

        return this.library.getClazz();
    }

    /**
     * Gets the method.
     *
     * @param clazz the clazz
     * @param methodId the method id
     * @return the method
     */
    public Method getMethod(Class<?> clazz, String methodId) {

        if (clazz == null || methodId == null) {
            return null;
        }

        return this.methods.get(clazz).get(methodId);
    }

    /**
     * Gets the classz.
     *
     * @param className the class name
     * @return the classz
     */
    public Class<?> getClassz(String className) {

        for (Class<?> clazz : this.methods.keySet()) {
            if (clazz.getName().equals(className)) {
                return clazz;
            }
        }
        return null;
    }

    /**
     * Load library model.
     */
    private void loadLibrary() {
        this.library = new LibraryModel();
        this.library.setClazz(new ArrayList<ClassModel>());
        
        for (String yamlName : YAML_FILE_NAME) {
            LibraryModel lib = (LibraryModel) YamlUtil.loadYamlToObject(FileUtil.getFilePathResource(yamlName),
                LibraryModel.class);
            
            if (lib != null && lib.getClazz() != null && lib.getClazz().size() > 0) {
                this.library.getClazz().add(lib.getClazz().get(0));
            }
        }
    }

    /**
     * Load method.
     */
    private void loadMethod() {

        if (this.library == null || this.library.getClazz() == null || this.library.getClazz().isEmpty()) {
            return;
        }

        this.methods = new HashMap<Class<?>, Map<String, Method>>();

        URLClassLoader urlClassLoader = null;
        String path = FileUtil.getFilePathResource(JAR_FILE_NAME);

        if (path == null || path.length() == 0) {
            return;
        }

        try {

            File file = new File(path);
            URL fileUrl = file.toURI().toURL();
            String jarUrl = "jar:" + fileUrl + "!/";
            URL urls[] = {new URL(jarUrl)};
            urlClassLoader = new URLClassLoader(urls);

            for (ClassModel clazzModel : this.library.getClazz()) {

                try {

                    List<MethodModel> methodModels = clazzModel.getMethods();

                    if (methodModels != null && methodModels.size() > 0) {

                        Class<?> clazz = Class.forName(clazzModel.getName(), true, urlClassLoader);

                        this.methods.put(clazz, new HashMap<>());

                        for (MethodModel methodModel : methodModels) {
                            for (Method method : clazz.getMethods()) {
                                if (matchMethod(methodModel, method)) {
                                    this.methods.get(clazz).put(methodModel.getId(), method);
                                }
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Match method.
     *
     * @param sample1 the sample 1
     * @param sample2 the sample 2
     * @return true, if successful
     */
    private boolean matchMethod(MethodModel sample1, Method sample2) {

        if (sample1 == null || sample2 == null || !sample1.getName().equals(sample2.getName())
            || !sample1.getReturns().getType().equalsIgnoreCase(sample2.getReturnType().getSimpleName())) {
            return false;
        }

        List<MethodParamModel> params1 = sample1.getParams();
        Parameter[] params2 = sample2.getParameters();

        if (params1 == null || params2 == null || params1.size() != params2.length) {
            return false;
        }

        for (int i = 0; i < params1.size(); i++) {
            if (params1.get(i).getType() == null || params1.get(i).getType().isEmpty()
                || !params1.get(i).getType().equalsIgnoreCase(params2[i].getType().getSimpleName())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Clean up.
     */
    private void cleanUp() {
        if (this.methods != null) {
            this.methods.clear();
        }
    }
}
