package jp.co.run.util;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class FileUtil {

//    public static boolean exportCSV(String parent, String fileName, String extension, String encoding, String[] headers,
//        String[] fields, Object[] data) {
//
//        StringBuilder header = new StringBuilder();
//        StringBuilder lines = new StringBuilder();
//        Charset charset = null;
//
//        int index = 0;
//        boolean hasHeader = false;
//        boolean hasData = false;
//
//        File file = new File(parent);
//
//        if (!file.isDirectory() || !file.canWrite()) {
//            return false;
//        }
//
//        file = new File(parent, fileName);
//
//        try {
//            charset = Charset.forName(encoding);
//        } catch (Exception e) {
//            charset = Charset.forName("UTF-8");
//        }
//
//        // build headers
//        if (headers != null && headers.length > 0) {
//            hasHeader = true;
//            while (index < headers.length) {
//
//                if (index == (headers.length - 1)) {
//                    header.append(headers[index]);
//                } else {
//                    header.append(headers[index] + ",");
//                }
//
//                index += 1;
//            }
//        }
//
//        // build data
//        index = 0;
//        if (data != null && fields != null && data.length > 0 && fields.length > 0) {
//
//            hasData = true;
//
//            Class<?> clazz = data[0].getClass();
//
//            while (index < data.length) {
//
//                Object object = data[index];
//                StringBuilder line = new StringBuilder();
//
//                for (String field : fields) {
//
//                    Object value = null;
//
//                    if (field != null && field.length() > 0) {
//                        String methodName = "get"
//                            + field.replace(field.charAt(0), String.valueOf(field.charAt(0)).toUpperCase().charAt(0));
//
//                        try {
//                            for (Method method : clazz.getMethods()) {
//                                if (method.getName().equals(methodName) && method.getParameters().length == 0) {
//                                    value = method.invoke(object);
//                                    break;
//                                }
//                            }
//                        } catch (Exception e) {
//                        }
//                    }
//
//                    if (value != null) {
//
//                        if (value instanceof Collection<?>) {
//                            StringBuilder builder = new StringBuilder("\"[");
//                            Iterator<?> iterator = ((Collection<?>) value).iterator();
//
//                            while (iterator.hasNext()) {
//                                Object obj = iterator.next();
//
//                                builder.append(obj.toString().replaceAll("\"", "\"\""));
//
//                                if (iterator.hasNext()) {
//                                    builder.append(", ");
//                                }
//                            }
//                            builder.append("]\"");
//                            line.append(builder.toString());
//                        } else if (value instanceof Map<?, ?>) {
//                            StringBuilder builder = new StringBuilder("\"{");
//
//                            Set<?> keySet = ((Map<?, ?>) value).keySet();
//
//                            Iterator<?> iterator = keySet.iterator();
//
//                            while (iterator.hasNext()) {
//
//                                Object k = iterator.next();
//                                Object v = ((Map<?, ?>) value).get(k);
//
//                                builder.append(k.toString().replaceAll("\"", "\"\""));
//                                builder.append("=");
//                                builder.append(v.toString().replaceAll("\"", "\"\""));
//
//                                if (iterator.hasNext()) {
//                                    builder.append(", ");
//                                }
//                            }
//
//                            builder.append("}\"");
//                            line.append(builder.toString());
//                        } else {
//                            line.append("\"");
//                            line.append(value.toString());
//                            line.append("\"");
//                        }
//                    }
//
//                    line.append(",");
//                }
//
//                lines.append(line.toString());
//                lines.append("\n");
//                index += 1;
//            }
//        }
//
//        OutputStreamWriter outputStreamWriter = null;
//        BufferedWriter bufferedWriter = null;
//
//        try {
//
//            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
//            bufferedWriter = new BufferedWriter(outputStreamWriter);
//            if (hasHeader) {
//                bufferedWriter.write(header.toString());
//            }
//
//            if (hasData) {
//                bufferedWriter.newLine();
//                bufferedWriter.write(lines.toString());
//            }
//
//        } catch (Exception e) {
//        } finally {
//            try {
//                if (bufferedWriter != null) {
//                    bufferedWriter.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//
//        return true;
//    }
//
//    public static void truncateFile(File file) throws IOException {
//        if (file != null && file.exists() && file.isFile() && file.canWrite()) {
//            FileOutputStream foStream = new FileOutputStream(file, true);
//            FileChannel channel = foStream.getChannel();
//            channel.truncate(0);
//            channel.close();
//            foStream.close();
//        }
//    }
//
//    public static boolean coppyFile(File source, File dest) {
//        FileInputStream iStream = null;
//        FileOutputStream oStream = null;
//        FileChannel iChannel = null;
//        FileChannel oChannel = null;
//        boolean isSuccess = true;
//        try {
//            iStream = new FileInputStream(source);
//            oStream = new FileOutputStream(dest);
//            iChannel = iStream.getChannel();
//            oChannel = oStream.getChannel();
//            oChannel.transferFrom(iChannel, 0, iChannel.size());
//        } catch (Exception e) {
//            isSuccess = false;
//        } finally {
//            try {
//                if (iChannel != null) {
//                    iChannel.close();
//                }
//                if (oChannel != null) {
//                    oChannel.close();
//                }
//                if (iStream != null) {
//                    iStream.close();
//                }
//                if (oStream != null) {
//                    oStream.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//        return isSuccess;
//    }
//
//    public static long writeFile(InputStream inputStream, String fileName, File destDir) {
//        if (inputStream == null || destDir == null || !destDir.isDirectory() || !destDir.canWrite() || fileName == null
//            || fileName.length() == 0) {
//            return 0;
//        }
//
//        long size = 0;
//        OutputStream oStream = null;
//        BufferedOutputStream boStream = null;
//
//        try {
//            File file = new File(destDir.getAbsolutePath(), fileName);
//            oStream = new FileOutputStream(file);
//            boStream = new BufferedOutputStream(oStream);
//            byte[] bytes = new byte[2048];
//            while (inputStream.read(bytes) > 0) {
//                size += bytes.length;
//                boStream.write(bytes);
//                bytes = new byte[1024];
//            }
//        } catch (Exception e) {
//        } finally {
//            try {
//                if (boStream != null) {
//                    boStream.flush();
//                    boStream.close();
//                }
//                if (oStream != null) {
//                    boStream.flush();
//                    oStream.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//        return size;
//    }
//
//    public static String getExtension(String file) {
//        StringBuilder builder = new StringBuilder();
//        if (file == null) {
//            return builder.toString();
//        }
//        String[] array = file.split("\\.");
//        int length = array.length;
//
//        if (length > 1) {
//            builder.append(array[length - 1]);
//        }
//
//        return builder.toString();
//    }
}
