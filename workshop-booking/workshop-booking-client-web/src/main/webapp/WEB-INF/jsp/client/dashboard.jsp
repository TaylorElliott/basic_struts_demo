<%
    System.out.println("### JSP Render running");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<html lang="en">
    <head> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta charset="utf-8">  
        <meta name="viewport" content="width=device-width, initial-scale=1">                
        <title>Archetype UIS JSP</title>  
        <!-- Bootstrap core CSS -->
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <h1>Dashboard</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <s:url action="studentHomeLoadAction" var="studentHomeUrl" />
                    <a href='<s:property value="studentHomeUrl"/>'>Go To Student Home Page </a>
                </div>
            </div>
        </div> <!-- /main container -->
        <!-- JS -->
        <script src="js/tether.min.js"></script>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- End JS -->
    </body>
</html>

