<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<body>
<table width="90%" height="90%">
<tr height="10%">
<td colspan="10" bgcolor="white" align="center">
<tiles:insertAttribute name="HEADER"/>
</td></tr>
<tr height="80%">
<td width="20%" bgcolor="blue" align="left">
<tiles:insertAttribute name="LMENU"/>
</td>
<td width="80%" bgcolor="black" align="center">
<tiles:insertAttribute name="BODY"/>
</td>
</tr>
<tr height="10%">
<td colspan="3" bgcolor="red" align="center">
<tiles:insertAttribute name="FOOTER"/>
</td></tr>
</table>
</body>
</html>
</body>
</html>