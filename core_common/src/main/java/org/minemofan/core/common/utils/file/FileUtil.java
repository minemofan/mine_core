package org.minemofan.core.common.utils.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 2015-04-01
 * <p>Title:       String工具类（扩展Apache FileUtils）</p>
 * <p>Description: 
 * 
 * Apache FileUtils:
 * 		写入一个文件
 * 		从文件读
 * 		做一个目录包括父目录
 * 		复制文件和目录
 * 		删除文件和目录
 * 		转换从一个URL
 * 		清单文件和目录的过滤和扩展
 * 		比较文件内容
 * 		文件最后修改日期		
 * </p>
 * <p>Copyright:   Copyright (c) 2015</p>
 * <p>Company:     东软软件股份有限公司</p>
 * <p>Department:  软件开发事业部</p>
 * @author         mosh
 * @version        1.0
 */
public class FileUtil extends FileUtils{
	
	private static Logger log = LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * Title	强制创建一个新的文件
	 * Description		如果文件已经存在，则删除后，新增。
	 * @param filePath
	 * @return
	 * @throws Exception 
	 */
	public static boolean compelNewFile(String filePath) throws Exception{
		File file = new File(filePath);
		if(!file.isFile()){
			log.error("[fileUtil]非文件类型，无法操作！");
			return false;
		}
		if(file.exists()){
			boolean delFlag = file.delete();
			log.info("[fileUtil]删除旧文件:"+ delFlag);
			if(delFlag){
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error("[fileUtil]创建文件异常！"+ e.getMessage());
					throw new Exception(e);
				}
			}
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("[fileUtil]创建文件异常！"+ e.getMessage());
				throw new Exception(e);
			}
		}
		return true;
	}
	
	
	/**
	 * Description 递归删除目录下的所有文件以及子目录下所有的文件
	 * @param fileDir 将要删除的文件目录
	 * @return
	 * @author Administrator
	 */
	public static boolean clearDir(File dir){
		
		if(!dir.isDirectory() && !dir.isFile()){
			log.info("[FileUtil]目录或文件不存在！");
			return false;
		}
		if(dir.isDirectory()){
			String[] childrenDir = dir.list();
			log.debug("[FileUtil]子目录："+ childrenDir.length);
			//递归删除目录中的子目录下
			for(String child : childrenDir){
				boolean succ = clearDir(new File(dir, child));				
				log.debug("[FileUtil]删除："+ dir +",child:"+ child +",flag:"+ succ);
				if(!succ){
					return false;
				}
			}
		}else{
			System.out.println("================");
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}
	
	
	
	
	public static void main(String[] args) {
		String str = "D:\\a\\b";
		try {
			FileUtils.cleanDirectory(new File(str));
			//boolean flag = FileUtil.clearDir(new File(str));
			//System.out.println("flag:"+ flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
