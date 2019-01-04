package jp.co.run.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;

import jp.co.run.validation.StringValidation;

public class ImageUtil {

//    public static boolean resizeImageByResolution(InputStream originalImg, String outputFileName, String extension,
//        int width, int height) {
//
//        if (StringValidation.isNullOrEmpty(outputFileName, extension) || originalImg == null || width < 0
//            || height < 0) {
//            return false;
//        }
//
//        try {
//            BufferedImage image = ImageIO.read(originalImg);
//
//            int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
//
//            BufferedImage resizeImage = new BufferedImage(width, height, type);
//            Graphics2D graphics2d = resizeImage.createGraphics();
//            graphics2d.setComposite(AlphaComposite.Src);
//            graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//            graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//            graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            graphics2d.drawImage(image, 0, 0, width, height, null);
//            graphics2d.dispose();
//
//            ImageIO.write(resizeImage, extension, new File(outputFileName));
//
//        } catch (Exception e) {
//            return false;
//        }
//
//        return true;
//    }
//
//    public static boolean resizeImageByPercentage(InputStream input, String extension, File output, int quality) throws IOException {
//        try {
//            FileUtil.truncateFile(output);
//            ImageInputStream iis = ImageIO.createImageInputStream(input);
//            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
//            ImageReader reader = (ImageReader) readers.next();
//            reader.setInput(iis, false);
//            IIOMetadata metadata = reader.getImageMetadata(0);
//            BufferedImage bi = reader.read(0);
//    
//            final ImageWriter writer = ImageIO.getImageWritersByFormatName("png").next();
//            writer.setOutput(new FileImageOutputStream(output));
//            
//            ImageWriteParam iwParam = writer.getDefaultWriteParam();
//            iwParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//            iwParam.setCompressionQuality(quality / 100f);
//    
//            writer.write(null, new IIOImage(bi, null, metadata), iwParam);
//            writer.dispose();
//            reader.dispose();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static void createJPEG(File input, File output, int quality) throws IOException {
//        FileUtil.truncateFile(output);
//        ImageInputStream iis = ImageIO.createImageInputStream(input);
//        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
//        ImageReader reader = (ImageReader) readers.next();
//        reader.setInput(iis, false);
//        IIOMetadata metadata = reader.getImageMetadata(0);
//        BufferedImage bi = reader.read(0);
//
//        final ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
//        writer.setOutput(new FileImageOutputStream(output));
//
//        ImageWriteParam iwParam = writer.getDefaultWriteParam();
//        iwParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//        iwParam.setCompressionQuality(quality / 100f);
//
//        writer.write(null, new IIOImage(bi, null, metadata), iwParam);
//        writer.dispose();
//        reader.dispose();
//    }

}
