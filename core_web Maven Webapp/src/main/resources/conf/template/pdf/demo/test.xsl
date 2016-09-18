<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
     xmlns:fo="http://www.w3.org/1999/XSL/Format">
<!-- 主模板 -->
<xsl:template match ="root">
<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
<fo:layout-master-set>
  <fo:simple-page-master master-name="A4"
      page-width="210mm" page-height="297mm"
      margin-top="1cm"   margin-bottom="1cm"
      margin-left="1cm"  margin-right="1cm">
      <fo:region-body   margin="2cm"/>
      <fo:region-before extent="2cm"/>
      <fo:region-after  extent="2cm"/>
      <fo:region-start  extent="2cm"/>
      <fo:region-end    extent="2cm"/>
  </fo:simple-page-master>
</fo:layout-master-set>
<fo:page-sequence master-reference="A4" language="zh">
	<fo:flow flow-name="xsl-region-body">
		<fo:block font-size="18pt" font-weight="bold" text-align="center" font-family="宋体">
			<xsl:text>FOP test for images 模板中定义的标题</xsl:text>
		</fo:block>
		<fo:block >
			<fo:external-graphic content-width="50pt" content-height="50pt" src="/style/images/adver.png"/> <!-- 找不到图片 -->
			<fo:external-graphic content-width="50pt" content-height="50pt" src="style/images/adver.png"/><!-- 找不到图片 -->
			<fo:external-graphic content-width="50pt" content-height="50pt" src="E:/MineWorkspaces/SpringMvcMybatis/WebRoot/style/images/adver.png"/><!-- 找到图片 -->
		</fo:block>
		<fo:block>
			<fo:inline font-family="SimHei" font-weight="normal" font-style="normal" space-before.minimum="1em">
				<xsl:value-of select="header"/>
			</fo:inline> 
	  	</fo:block>
	  	<!-- 定义Table -->
	  	<fo:table table-layout="fixed" border-width="0.1mm" border-style="solid">	<!-- table边框线border-width -->
	  		<fo:table-column column-width="77mm"/>		<!-- 定义第一列 -->
	  		<fo:table-column column-width="77mm"/>		<!-- 定义第二列 -->
	  		<!-- 定义table头 -->
	  		<fo:table-header>
			    <fo:table-row>
			      <fo:table-cell border-width="0.1mm" border-style="solid" font-family="SimHei" font-weight="bold">
			        <fo:block font-weight="bold">列-姓名</fo:block>
			      </fo:table-cell>
			      <fo:table-cell border-width="0.1mm" border-style="solid" font-family="SimHei" font-weight="bold">
			        <fo:block font-weight="bold">列-年龄</fo:block>
			      </fo:table-cell>
			    </fo:table-row>
		  	</fo:table-header>
		  	<!-- 定义table体 -->
			<fo:table-body>
		    	<xsl:apply-templates select="persons"/>	<!-- 指定Table模板 -->
		  	</fo:table-body>
		</fo:table>
		<fo:block margin-left="0mm">
			<fo:inline font-family="SimHei" font-weight="normal" font-style="normal">
				<!-- 无法实现保留前后空格 xsl:text，只能通过平移，或者增加一张空白图片来实现  -->
				<fo:external-graphic content-width="50pt" content-height="50pt" src="E:/testWork/nbsp.png"/><xsl:value-of select="foot"/>
			</fo:inline> 
	  	</fo:block>
	</fo:flow>
</fo:page-sequence>
</fo:root>
</xsl:template>
<!-- 定义table体模板  使用for-each来遍历  -->
<xsl:template match="persons">
	<xsl:for-each select="person">
	<fo:table-row>
		<fo:table-cell border-width="0.1mm" border-style="solid">
		<fo:block>
			<fo:inline font-family="宋体" font-weight="normal" font-style="normal">
				<xsl:value-of select="name"/>
			</fo:inline> 
		</fo:block>
		</fo:table-cell>
		<fo:table-cell border-width="0.1mm" border-style="solid">
		<fo:block>
			<xsl:value-of select="age"/>
		</fo:block>
		</fo:table-cell>
   </fo:table-row>
   </xsl:for-each>
</xsl:template>
</xsl:stylesheet>

