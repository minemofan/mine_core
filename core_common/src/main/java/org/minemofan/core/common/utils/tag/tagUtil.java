package org.minemofan.core.common.utils.tag;

public class tagUtil {
	
	/**
	 * @Description 创建js引入标签
	 */
	public static String getJavaScriptTag(String path,String jsFileName){
		String src = path + jsFileName;
		return "<script type=\"text/javascript\" src=\""+ src +"\"></script>";
	}
	
	/**
	 * @Description 创建css引入标签
	 */
	public static String getCSSTag(String path,String jsFileName){
		String href = path + jsFileName;
		return "<link rel=\"stylesheet\" type=\"text/css\" href=\""+ href +"\"/>";
	}
	
}
