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
        <title>Student Home</title>  
        <!-- Bootstrap core CSS -->
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <h1>Student Home Page</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <s:url action="dashboardAction" var="dashboardUrl" />
                    <a href='<s:property value="dashboardUrl"/>'>Go To dashboard </a>
                </div>
            </div>
            <br>
            <br>
            <div class="row">
                <div class="col-12">
                    <table class="table table-bordered table-striped table-hover">
                        <th>
                            First Name
                        </th>
                        <th>
                            Last Name
                        </th>
                        <th>
                            Age
                        </th>
                        <th>
                            Link
                        </th>
                        <s:iterator value="studentBeanList">
                            <tr>
                                <td>
                                    <s:property value="firstName" />
                                </td>
                                <td>
                                    <s:property value="lastName" />
                                </td>
                                <td>
                                    <div>
                                       <s:property value="age" /> 
                                    </div>
                                    <div>
                                        <!-- Age is a String data type in the StudentDataBean, but in the expression below, it is
                                        automatically converted to an integer data type. The expression below is written in OGNL (Object Graph Navigation Language) -->
                                        <s:if test="%{age % 2 == 0}">
                                            Age is an EVEN number
                                        </s:if>
                                        <s:else>
                                            Age is an ODD number
                                        </s:else>
                                    </div>
                                </td>
                                <td>
                                    <s:url action="studentEditLoadAction" var="studentEditUrl">
                                        <s:param name="studentPk" value="studentPk" />
                                    </s:url>
                                    <a href='<s:property value="studentEditUrl"/>'>Edit Student</a>
                                </td>
                            </tr>
                        </s:iterator>
                    </table>
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

