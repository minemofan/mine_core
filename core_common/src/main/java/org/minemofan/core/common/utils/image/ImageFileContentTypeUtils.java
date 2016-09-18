package org.minemofan.core.common.utils.image;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on  2015-04-14
 * <p>Title:   处理文件扩展名与ContentType工具类</p>
 * <p>Description: 
 * </p>
 * <p>Copyright:   Copyright (c) 2015</p>
 * <p>Company:     雪山金融</p>
 * <p>Department:  科技部</p>
 * @author         莫世宏 moshh@neusoft.com
 * @version        1.0
 */
public class ImageFileContentTypeUtils {
	
	private static Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * Description 图片文件扩展名 与 ContentType的对照 
	 */
    static {
    	map.put(".jpeg","image/jpeg");
    	map.put(".jpg","image/jpeg");
        map.put(".gif","image/gif");
        map.put(".png","image/png");
        map.put(".bmp","image/bmp");
    }
	

    /**
     * Description 根据文件拓展名找出对应的HTTP Content-type
     * @param extension 文件拓展名
     * @return HTTP Content-type，如果不存在将返回空
     * @author mosh
     */
    public static String getContentTypeByExtension(String extension) {
    	extension = "." + extension;
        return map.get(extension);
    }

    
    /**
     * Description 根据文件名找出对应的HTTP Content-type
     * @param fileName 文件名
     * @return HTTP Content-type，如果不存在将返回空
     * @author mosh
     */
    public static String getContentTypeByFileName(String fileName) {
    	
    	if(fileName.lastIndexOf(".")<=0){
        	return "";
        }
        String extension = fileName.split("\\.")[1];
        return getContentTypeByExtension(extension);
    }
    

    
}
