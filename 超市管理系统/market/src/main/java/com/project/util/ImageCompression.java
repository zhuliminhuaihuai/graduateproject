package com.project.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * ClassName: ImageCompression 
 * @Description: 图片压缩类
 * @author whd
 * @date 2016年1月22日
 */
public class ImageCompression {
	
	/**
	 *  按长宽进行压缩
	 *  
	 * @param f
	 *            图片输出路径
	 * @param filelist
	 *            图片路径
	 * @param ext
	 *            缩略图扩展名
	 * @param n
	 *            图片名
	 * @param w
	 *            目标宽
	 * @param h
	 *            目标高
	 * @param per
	 *            百分比
	 */
	public static void toSmallerpic(File oldFile, File newFile, int width, int height,
			float quality) {
		if (!newFile.getParentFile().exists()) {
			newFile.getParentFile().mkdirs();
		}
		System.out.println(oldFile.toString());
		Image src = null;
		BufferedImage tag = null;
		FileOutputStream newimage = null;
		try {
			try {
				src = ImageIO.read(oldFile); // 构造Image对象
			} catch (Exception e) {
				e.printStackTrace();
//				try {
//					 ThumbnailConvert convert=new ThumbnailConvert();
//					 //convert.setCMYK_COMMAND(oldFile.getPath());
//					 String CMYK_COMMAND =
//					 "mogrify -colorspace RGB -quality 100 file1";//转换cmyk格式
//					 convert.exeCommand(CMYK_COMMAND.replace("file1",oldFile.getPath()));
//					 src =
//					 Toolkit.getDefaultToolkit().getImage(oldFile.getPath());
//					 MediaTracker mediaTracker = new MediaTracker(new
//					 Container());
//					 mediaTracker.addImage(src, 0);
//					 mediaTracker.waitForID(0);
//					 src.getWidth(null);
//					 src.getHeight(null);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
			}
			// ,String ext 保留字段 缩略图拼接字段
			// String img_midname=newFile;
			int old_w = src.getWidth(null) == -1 ? width : src.getWidth(null); // 得到源图宽
			int old_h = src.getHeight(null) == -1 ? height : src
					.getHeight(null);
			int new_w = 0;
			int new_h = 0; // 得到源图长
			double w2 = (old_w * 1.00) / (width * 1.00);
			double h2 = (old_h * 1.00) / (height * 1.00);
			// 图片调整为方形结束
			if (old_w > width)
				new_w = (int) Math.round(old_w / w2);
			else
				new_w = old_w;
			if (old_h > height)
				new_h = (int) Math.round(old_h / h2);// 计算新图长宽
			else
				new_h = old_h;
			tag = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
			// tag.getGraphics().drawImage(src,0,0,new_w,new_h,null); //绘制缩小后的图
			tag.getGraphics().drawImage(
					src.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0,
					0, null);
			newimage = new FileOutputStream(newFile); // 输出到文件流
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			/* 压缩质量 */
			jep.setQuality(quality, true);
			encoder.encode(tag, jep);
			// encoder.encode(tag); //近JPEG编码
			newimage.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println(oldFile.getName() + "图片压缩问题;" + ex);
			// Logger.getLogger(File:mpress.class.getName()).log(Level.SEVERE,
			// null, ex);
		} finally {
			if (newimage != null) {
				try {
					newimage.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (tag != null) {
				tag.flush();
			}
		}
	}

	
	/**
	 * @Description: 按比例进行压缩（文件）
	 * @param @param imgInputStream 
	 * @param @param imgOutputStream
	 * @param @param scale   
	 * @return void  
	 * @throws
	 * @author whd
	 * @date 2016年1月22日
	 */
	public static void scaleImage(InputStream imgInputStream,
			OutputStream imgOutputStream, int scale) {
		try {

			Image src = ImageIO.read(imgInputStream);
			int width = (int) (src.getWidth(null) * scale / 100);
			int height = (int) (src.getHeight(null) * scale / 100);
//			System.out.println(width+":"+height);
//			int width=1080;
//			int height = 1920;
			BufferedImage bufferedImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);

			bufferedImage.getGraphics().drawImage(
					src.getScaledInstance(width, height, Image.SCALE_SMOOTH),
					0, 0, null);
			JPEGImageEncoder encoder = JPEGCodec
					.createJPEGEncoder(imgOutputStream);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(bufferedImage);
			/* 压缩质量 */
			jep.setQuality(1.0f, true);
			encoder.encode(bufferedImage);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: 按比例进行压缩（图片路径）
	 * @param @param imgSrc
	 * @param @param imgDist
	 * @param @param scale   
	 * @return void  
	 * @throws
	 * @author whd
	 * @date 2016年1月22日
	 */
	public static void scaleImage(String imgSrc, String imgDist, int scale) {
		try {
			File file = new File(imgSrc);
			if (!file.exists()) {
				return;
			}
			InputStream is = new FileInputStream(file);
			OutputStream os = new FileOutputStream(imgDist);
			scaleImage(is, os, scale);
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String oldpath = "D:\\1.jpg";
//		File picture = new File(oldpath); 
//		BufferedImage sourceImg =ImageIO.read(new FileInputStream(picture));   
//        System.out.println(String.format("%.1f",picture.length()/1024.0));  
//        System.out.println(sourceImg.getWidth());  
//        System.out.println(sourceImg.getHeight());  
		String newpath = "D:\\4.jpg";
		File picture = new File(oldpath);
		BufferedImage sourceImg =ImageIO.read(picture);
		float width = sourceImg.getWidth();  
        float height = sourceImg.getHeight();
//		ImageCompression.toSmallerpic(new File(oldpath), new File(newpath), 1536, 1024, 1f);
        int scale=0;
        scale = (int) (480 / width *100);
//        height = height *scale;
		ImageCompression.scaleImage(oldpath,newpath,scale);
//        ImageCompression.toSmallerpic(new File(oldpath), new File(newpath), 320, height, 1f);
	}
	 
}