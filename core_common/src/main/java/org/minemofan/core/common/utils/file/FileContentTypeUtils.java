package org.minemofan.core.common.utils.file;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on  2015-04-14
 * <p>Title:   处理文件扩展名与Mine(多用途互联网邮件扩展类型)工具类</p>
 * <p>Description: 
 * </p>
 * <p>Copyright:   Copyright (c) 2015</p>
 * <p>Company:     雪山金融</p>
 * <p>Department:  科技部</p>
 * @author         莫世宏 moshh@neusoft.com
 * @version        1.0
 */
public class FileContentTypeUtils {
	
	private static Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * Description 文件扩展名 与 Mine的对照 
	 */
    static {
        map.put("0.001","application/x-001");
        map.put("0.323","text/h323");
        map.put("0.907","drawing/907");
        map.put(".acp","audio/x-mei-aac");
        map.put(".aif","audio/aiff");
        map.put(".aiff","audio/aiff");
        map.put(".asa","text/asa");
        map.put(".asp","text/asp");
        map.put(".au","audio/basic");
        map.put(".awf","application/vnd.adobe.workflow");
        map.put(".bmp","image/bmp");
        map.put(".c4t","application/x-c4t");
        map.put(".cal","application/x-cals");
        map.put(".cdf","application/x-netcdf");
        map.put(".cel","application/x-cel");
        map.put(".cg4","application/x-g4");
        map.put(".cit","application/x-cit");
        map.put(".cml","text/xml");
        map.put(".cmx","application/x-cmx");
        map.put(".crl","application/pkix-crl");
        map.put(".csi","application/x-csi");
        map.put(".cut","application/x-cut");
        map.put(".dbm","application/x-dbm");
        map.put(".dcd","text/xml");
        map.put(".der","application/x-x509-ca-cert");
        map.put(".dib","application/x-dib");
        map.put(".doc","application/msword");
        map.put(".drw","application/x-drw");
        map.put(".dwf","Model/vnd.dwf");
        map.put(".dwg","application/x-dwg");
        map.put(".dxf","application/x-dxf");
        map.put(".emf","application/x-emf");
        map.put(".ent","text/xml");
        map.put(".eps","application/x-ps");
        map.put(".etd","application/x-ebx");
        map.put(".fax","image/fax");
        map.put(".fif","application/fractals");
        map.put(".frm","application/x-frm");
        map.put(".gbr","application/x-gbr");
        map.put(".gif","image/gif");
        map.put(".gp4","application/x-gp4");
        map.put(".hmr","application/x-hmr");
        map.put(".hpl","application/x-hpl");
        map.put(".hrf","application/x-hrf");
        map.put(".htc","text/x-component");
        map.put(".html","text/html");
        map.put(".htx","text/html");
        map.put(".ico","image/x-icon");
        map.put(".iff","application/x-iff");
        map.put(".igs","application/x-igs");
        map.put(".img","application/x-img");
        map.put(".isp","application/x-internet-signup");
        map.put(".java","java/*");
        map.put(".jpe","image/jpeg");
        map.put(".jpeg","image/jpeg");
        map.put(".jpg","application/x-jpg");
        map.put(".jsp","text/html");
        map.put(".lar","application/x-laplayer-reg");
        map.put(".lavs","audio/x-liquid-secure");
        map.put(".lmsff","audio/x-la-lms");
        map.put(".ltr","application/x-ltr");
        map.put(".m2v","video/x-mpeg");
        map.put(".m4e","video/mpeg4");
        map.put(".man","application/x-troff-man");
        map.put(".mdb","application/msaccess");
        map.put(".mfp","application/x-shockwave-flash");
        map.put(".mhtml","message/rfc822");
        map.put(".mid","audio/mid");
        map.put(".mil","application/x-mil");
        map.put(".mnd","audio/x-musicnet-download");
        map.put(".mocha","application/x-javascript");
        map.put(".mp1","audio/mp1");
        map.put(".mp2v","video/mpeg");
        map.put(".mp4","video/mpeg4");
        map.put(".mpd","application/vnd.ms-project");
        map.put(".mpeg","video/mpg");
        map.put(".mpga","audio/rn-mpeg");
        map.put(".mps","video/x-mpeg");
        map.put(".mpv","video/mpg");
        map.put(".mpw","application/vnd.ms-project");
        map.put(".mtx","text/xml");
        map.put(".net","image/pnetvue");
        map.put(".nws","message/rfc822");
        map.put(".out","application/x-out");
        map.put(".p12","application/x-pkcs12");
        map.put(".p7c","application/pkcs7-mime");
        map.put(".p7r","application/x-pkcs7-certreqresp");
        map.put(".pc5","application/x-pc5");
        map.put(".pcl","application/x-pcl");
        map.put(".pdf","application/pdf");
        map.put(".pdx","application/vnd.adobe.pdx");
        map.put(".pgl","application/x-pgl");
        map.put(".pko","application/vnd.ms-pki.pko");
        map.put(".plg","text/html");
        map.put(".plt","application/x-plt");
        map.put(".png","application/x-png");
        map.put(".ppa","application/vnd.ms-powerpoint");
        map.put(".pps","application/vnd.ms-powerpoint");
        map.put(".ppt","application/x-ppt");
        map.put(".prf","application/pics-rules");
        map.put(".prt","application/x-prt");
        map.put(".ps","application/postscript");
        map.put(".pwz","application/vnd.ms-powerpoint");
        map.put(".ra","audio/vnd.rn-realaudio");
        map.put(".ras","application/x-ras");
        map.put(".rdf","text/xml");
        map.put(".red","application/x-red");
        map.put(".rjs","application/vnd.rn-realsystem-rjs");
        map.put(".rlc","application/x-rlc");
        map.put(".rm","application/vnd.rn-realmedia");
        map.put(".rmi","audio/mid");
        map.put(".rmm","audio/x-pn-realaudio");
        map.put(".rms","application/vnd.rn-realmedia-secure");
        map.put(".rmx","application/vnd.rn-realsystem-rmx");
        map.put(".rp","image/vnd.rn-realpix");
        map.put(".rsml","application/vnd.rn-rsml");
        map.put(".rtf","application/msword");
        map.put(".rv","video/vnd.rn-realvideo");
        map.put(".sat","application/x-sat");
        map.put(".sdw","application/x-sdw");
        map.put(".slb","application/x-slb");
        map.put(".slk","drawing/x-slk");
        map.put(".smil","application/smil");
        map.put(".snd","audio/basic");
        map.put(".sor","text/plain");
        map.put(".spl","application/futuresplash");
        map.put(".ssm","application/streamingmedia");
        map.put(".stl","application/vnd.ms-pki.stl");
        map.put(".sty","application/x-sty");
        map.put(".swf","application/x-shockwave-flash");
        map.put(".tg4","application/x-tg4");
        map.put(".tif","image/tiff");
        map.put(".tiff","image/tiff");
        map.put(".top","drawing/x-top");
        map.put(".tsd","text/xml");
        map.put(".uin","application/x-icq");
        map.put(".vcf","text/x-vcard");
        map.put(".vdx","application/vnd.visio");
        map.put(".vpg","application/x-vpeg005");
        map.put(".vsd","application/x-vsd");
        map.put(".vst","application/vnd.visio");
        map.put(".vsw","application/vnd.visio");
        map.put(".vtx","application/vnd.visio");
        map.put(".wav","audio/wav");
        map.put(".wb1","application/x-wb1");
        map.put(".wb3","application/x-wb3");
        map.put(".wiz","application/msword");
        map.put(".wk4","application/x-wk4");
        map.put(".wks","application/x-wks");
        map.put(".wma","audio/x-ms-wma");
        map.put(".wmf","application/x-wmf");
        map.put(".wmv","video/x-ms-wmv");
        map.put(".wmz","application/x-ms-wmz");
        map.put(".wpd","application/x-wpd");
        map.put(".wpl","application/vnd.ms-wpl");
        map.put(".wr1","application/x-wr1");
        map.put(".wrk","application/x-wrk");
        map.put(".ws2","application/x-ws");
        map.put(".wsdl","text/xml");
        map.put(".xdp","application/vnd.adobe.xdp");
        map.put(".xfd","application/vnd.adobe.xfd");
        map.put(".xhtml","text/html");
        map.put(".xls","application/x-xls");
        map.put(".xml","text/xml");
        map.put(".xq","text/xml");
        map.put(".xquery","text/xml");
        map.put(".xsl","text/xml");
        map.put(".xwd","application/x-xwd");
        map.put(".sis","application/vnd.symbian.install");
        map.put(".x_t","application/x-x_t");
        map.put(".apk","application/vnd.android.package-archive");
        map.put("0.301","application/x-301");
        map.put("0.906","application/x-906");
        map.put(".a11","application/x-a11");
        map.put(".ai","application/postscript");
        map.put(".aifc","audio/aiff");
        map.put(".anv","application/x-anv");
        map.put(".asf","video/x-ms-asf");
        map.put(".asx","video/x-ms-asf");
        map.put(".avi","video/avi");
        map.put(".biz","text/xml");
        map.put(".bot","application/x-bot");
        map.put(".c90","application/x-c90");
        map.put(".cat","application/vnd.ms-pki.seccat");
        map.put(".cdr","application/x-cdr");
        map.put(".cer","application/x-x509-ca-cert");
        map.put(".cgm","application/x-cgm");
        map.put(".class","java/*");
        map.put(".cmp","application/x-cmp");
        map.put(".cot","application/x-cot");
        map.put(".crt","application/x-x509-ca-cert");
        map.put(".css","text/css");
        map.put(".dbf","application/x-dbf");
        map.put(".dbx","application/x-dbx");
        map.put(".dcx","application/x-dcx");
        map.put(".dgn","application/x-dgn");
        map.put(".dll","application/x-msdownload");
        map.put(".dot","application/msword");
        map.put(".dtd","text/xml");
        map.put(".dwf","application/x-dwf");
        map.put(".dxb","application/x-dxb");
        map.put(".edn","application/vnd.adobe.edn");
        map.put(".eml","message/rfc822");
        map.put(".epi","application/x-epi");
        map.put(".eps","application/postscript");
        map.put(".exe","application/x-msdownload");
        map.put(".fdf","application/vnd.fdf");
        map.put(".fo","text/xml");
        map.put(".g4","application/x-g4");
        map.put(".","application/x-");
        map.put(".gl2","application/x-gl2");
        map.put(".hgl","application/x-hgl");
        map.put(".hpg","application/x-hpgl");
        map.put(".hqx","application/mac-binhex40");
        map.put(".hta","application/hta");
        map.put(".htm","text/html");
        map.put(".htt","text/webviewhtml");
        map.put(".icb","application/x-icb");
        map.put(".ico","application/x-ico");
        map.put(".ig4","application/x-g4");
        map.put(".iii","application/x-iphone");
        map.put(".ins","application/x-internet-signup");
        map.put(".IVF","video/x-ivf");
        map.put(".jfif","image/jpeg");
        map.put(".jpe","application/x-jpe");
        map.put(".jpg","image/jpeg");
        map.put(".js","application/x-javascript");
        map.put(".la1","audio/x-liquid-file");
        map.put(".latex","application/x-latex");
        map.put(".lbm","application/x-lbm");
        map.put(".ls","application/x-javascript");
        map.put(".m1v","video/x-mpeg");
        map.put(".m3u","audio/mpegurl");
        map.put(".mac","application/x-mac");
        map.put(".math","text/xml");
        map.put(".mdb","application/x-mdb");
        map.put(".mht","message/rfc822");
        map.put(".mi","application/x-mi");
        map.put(".midi","audio/mid");
        map.put(".mml","text/xml");
        map.put(".mns","audio/x-musicnet-stream");
        map.put(".movie","video/x-sgi-movie");
        map.put(".mp2","audio/mp2");
        map.put(".mp3","audio/mp3");
        map.put(".mpa","video/x-mpg");
        map.put(".mpe","video/x-mpeg");
        map.put(".mpg","video/mpg");
        map.put(".mpp","application/vnd.ms-project");
        map.put(".mpt","application/vnd.ms-project");
        map.put(".mpv2","video/mpeg");
        map.put(".mpx","application/vnd.ms-project");
        map.put(".mxp","application/x-mmxp");
        map.put(".nrf","application/x-nrf");
        map.put(".odc","text/x-ms-odc");
        map.put(".p10","application/pkcs10");
        map.put(".p7b","application/x-pkcs7-certificates");
        map.put(".p7m","application/pkcs7-mime");
        map.put(".p7s","application/pkcs7-signature");
        map.put(".pci","application/x-pci");
        map.put(".pcx","application/x-pcx");
        map.put(".pdf","application/pdf");
        map.put(".pfx","application/x-pkcs12");
        map.put(".pic","application/x-pic");
        map.put(".pl","application/x-perl");
        map.put(".pls","audio/scpls");
        map.put(".png","image/png");
        map.put(".pot","application/vnd.ms-powerpoint");
        map.put(".ppm","application/x-ppm");
        map.put(".ppt","application/vnd.ms-powerpoint");
        map.put(".pr","application/x-pr");
        map.put(".prn","application/x-prn");
        map.put(".ps","application/x-ps");
        map.put(".ptn","application/x-ptn");
        map.put(".r3t","text/vnd.rn-realtext3d");
        map.put(".ram","audio/x-pn-realaudio");
        map.put(".rat","application/rat-file");
        map.put(".rec","application/vnd.rn-recording");
        map.put(".rgb","application/x-rgb");
        map.put(".rjt","application/vnd.rn-realsystem-rjt");
        map.put(".rle","application/x-rle");
        map.put(".rmf","application/vnd.adobe.rmf");
        map.put(".rmj","application/vnd.rn-realsystem-rmj");
        map.put(".rmp","application/vnd.rn-rn_music_package");
        map.put(".rmvb","application/vnd.rn-realmedia-vbr");
        map.put(".rnx","application/vnd.rn-realplayer");
        map.put(".rpm","audio/x-pn-realaudio-plugin");
        map.put(".rt","text/vnd.rn-realtext");
        map.put(".rtf","application/x-rtf");
        map.put(".sam","application/x-sam");
        map.put(".sdp","application/sdp");
        map.put(".sit","application/x-stuffit");
        map.put(".sld","application/x-sld");
        map.put(".smi","application/smil");
        map.put(".smk","application/x-smk");
        map.put(".sol","text/plain");
        map.put(".spc","application/x-pkcs7-certificates");
        map.put(".spp","text/xml");
        map.put(".sst","application/vnd.ms-pki.certstore");
        map.put(".stm","text/html");
        map.put(".svg","text/xml");
        map.put(".tdf","application/x-tdf");
        map.put(".tga","application/x-tga");
        map.put(".tif","application/x-tif");
        map.put(".tld","text/xml");
        map.put(".torrent","application/x-bittorrent");
        map.put(".txt","text/plain");
        map.put(".uls","text/iuls");
        map.put(".vda","application/x-vda");
        map.put(".vml","text/xml");
        map.put(".vsd","application/vnd.visio");
        map.put(".vss","application/vnd.visio");
        map.put(".vst","application/x-vst");
        map.put(".vsx","application/vnd.visio");
        map.put(".vxml","text/xml");
        map.put(".wax","audio/x-ms-wax");
        map.put(".wb2","application/x-wb2");
        map.put(".wbmp","image/vnd.wap.wbmp");
        map.put(".wk3","application/x-wk3");
        map.put(".wkq","application/x-wkq");
        map.put(".wm","video/x-ms-wm");
        map.put(".wmd","application/x-ms-wmd");
        map.put(".wml","text/vnd.wap.wml");
        map.put(".wmx","video/x-ms-wmx");
        map.put(".wp6","application/x-wp6");
        map.put(".wpg","application/x-wpg");
        map.put(".wq1","application/x-wq1");
        map.put(".wri","application/x-wri");
        map.put(".ws","application/x-ws");
        map.put(".wsc","text/scriptlet");
        map.put(".wvx","video/x-ms-wvx");
        map.put(".xdr","text/xml");
        map.put(".xfdf","application/vnd.adobe.xfdf");
        map.put(".xls","application/vnd.ms-excel");
        map.put(".xlw","application/x-xlw");
        map.put(".xpl","audio/scpls");
        map.put(".xql","text/xml");
        map.put(".xsd","text/xml");
        map.put(".xslt","text/xml");
        map.put(".x_b","application/x-x_b");
        map.put(".sisx","application/vnd.symbian.install");
        map.put(".ipa","application/vnd.iphone");
        map.put(".xap","application/x-silverlight-app");
        map.put(".tif","image/tiff");
    }
	
	
    
    /**
     * Description 根据文件拓展名找出对应的HTTP Content-type
     * @param extension 文件拓展名
     * @return HTTP Content-type，如果不存在将返回空
     * @author mosh
     */
    public static String getContentTypeByExtension(String extension) {
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
        String extension = "." + fileName.split("\\.")[1];
        return getContentTypeByExtension(extension);
    }
    
    
    
    
    public static void main(String[] args) {
    	FileContentTypeUtils util  = new FileContentTypeUtils();
    	System.out.println(util.getContentTypeByExtension(".png"));
    	System.out.println(util.getContentTypeByFileName("name.png"));
    
	}
    
}
