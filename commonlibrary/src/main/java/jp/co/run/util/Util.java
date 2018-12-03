package jp.co.run.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

import jp.co.run.validation.StringValidation;

/**
 * The Class Util.
 * 
 * @author datnguyen
 */
public class Util {

    /**
     * Checks if is obj null.
     *
     * @param obj the obj
     * @return true, if is obj null
     */
    public static boolean isObjNull(Object obj) {
        return obj == null;
    }

    /**
     * Checks if is obj null.
     *
     * @param objs the objs
     * @return true, if is obj null
     */
    public static boolean isObjNull(Object... objs) {

        if (objs == null) {
            return true;
        }

        for (Object obj : objs) {
            if (isObjNull(obj)) {
                return true;
            }
        }

        return false;
    }

    public static boolean resizeImageByResolution(InputStream originalImg, String outputFileName, String extension, int width,
        int height) {

        if (StringValidation.isNullOrEmpty(outputFileName, extension) || originalImg == null || width < 0 || height < 0) {
            return false;
        }

        try {
            BufferedImage image = ImageIO.read(originalImg);

            int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();

            BufferedImage resizeImage = new BufferedImage(width, height, type);
            Graphics2D graphics2d = resizeImage.createGraphics();
            graphics2d.setComposite(AlphaComposite.Src);
            graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2d.drawImage(image, 0, 0, width, height, null);
            graphics2d.dispose();

            ImageIO.write(resizeImage, extension, new File(outputFileName));

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
