<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="http://www.mofan.org/apptag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
System.out.println("path:"+path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'queryDemo.jsp' starting page</title>
    <m:appjs/>
	<script type="text/javascript">
	</script>
  </head>
  <body>
  	<%= path%>
  	<form action="<%= path%>/demoController/queryAll.do" method="post">
  		<input type="hidden" id="testParam" name="testParam" value="测试参数" />
    	<input type="submit"  value="查询" />
    </form>
    <hr>
  	<strong>总数：</strong>${infoCount}
  	<hr>
    <strong>map：</strong>${rmap.mkey1},${rmap.mkey2}
    <hr>
    <strong>list-map：</strong>${rlist}
    <br>
    <c:forEach items="${rlist}" var="rl">
    	<br>
    	<span>结果：</span>
    	<c:if test="${rl.mkey1_1 != null }"><span style="color: blue;">${rl.mkey1_1}</span>,</c:if>
    	<c:if test="${rl.mkey1_2 != null }"><span style="color: blue;">${rl.mkey1_2}</span>,</c:if>
    	<c:if test="${rl.mkey2_1 != null }"><span style="color: blue;">${rl.mkey2_1}</span>,</c:if>
    	<c:if test="${rl.mkey2_2 != null }"><span style="color: blue;">${rl.mkey2_2}</span>,</c:if>
    </c:forEach>
    <hr>
    <strong>list-obj：</strong>${list}
    <br>
    <c:forEach items="${list}" var="l">    
    	<span>结果：</span><br>
    	<span style="color: blue;">${l.demoId}</span><br>
    	<span style="color: blue;">${l.demoName}</span><br>
    	<span style="color: blue;">${l.demoType}</span><br>
    	<span style="color: blue;">${l.demoMoney}</span><br>
    	<span style="color: blue;">${l.demoDate}</span><br>
    	<span style="color: blue;">${l.demoTime}</span><br>
    </c:forEach>
   
    <hr>
  </body>
</html>
