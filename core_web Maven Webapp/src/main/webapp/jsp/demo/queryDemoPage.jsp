<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.minemofan.core.common.utils.StringUtil"%> 
<%@ taglib prefix="m" uri="http://www.mofan.org/apptag"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = StringUtil.removeSprit(request.getContextPath());

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'queryDemoPage.jsp' starting page</title>
    <m:appjs type="type1"/>
	<script type="text/javascript">
	
	
	
	function queryClick(){
		var uri = "<%= path%>/demoController/fanye.do";
		alert($("#q1").val());
	
	
		$.ajax({
	          url: uri,
			  type: 'POST',
	          cache: false,
	          success: function(html,status){
	          	alert("html:"+html+",status:"+status);
	          },
			  error:function(html){
			  	alert("error-html2:"+html);
			  }
	        });
		alert($("#q1").val());
	}
	
	
	</script>
  </head>
  <body>
    	<input id="q1" name="qname" type="button" value="查 询" onclick="queryClick()"></input>
    	
    	
    	
  </body>
</html>
