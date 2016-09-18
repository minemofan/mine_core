package org.minemofan.core.common.utils.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class ImageFileUtil {
	
	private Log log = LogFactory.getLog(ImageFileUtil.class);
	
	/**
	 * Description 获得图片 宽 、高、大小
	 * @param str
	 * @return 
	 */
	public Map<String,Object> getImageInfo(String imgPath){
		
		Map<String,Object> rmap = new HashMap<String,Object>();
		
		File picture = new File(imgPath);  
	    BufferedImage sourceImg;
	    String imgSize = "";
	    int imgWidth = 0;
	    int imgHeight = 0;
		try {
			sourceImg = ImageIO.read(new FileInputStream(picture));
			imgSize = String.format("%.1f",picture.length()/1024.0);
			imgWidth = sourceImg.getWidth();
			imgWidth = sourceImg.getHeight();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		rmap.put("size", imgSize);
		rmap.put("width", imgWidth);
		rmap.put("height", imgHeight);
		
		return rmap;
	}
	
	
	public static void main(String[] args) {
		
		 File picture = new File("D:/360Downloads/287138.jpg");  
	     BufferedImage sourceImg;
		try {
			sourceImg = ImageIO.read(new FileInputStream(picture));
			
			System.out.println(String.format("%.1f",picture.length()/1024.0) + "KB");  
			System.out.println(sourceImg.getWidth());  
			System.out.println(sourceImg.getHeight());  
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	    
		
	}
}
