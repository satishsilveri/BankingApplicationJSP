<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>

<%
session.invalidate();
response.sendRedirect("index.jsp");
%>

<BODY onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">
 