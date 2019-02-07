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
        <title>Student Edit</title>  
        <!-- Bootstrap core CSS -->
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <h1>Student Edit Page</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <s:url action="studentHomeLoadAction" var="studentHomeUrl" />
                    <a href='<s:property value="studentHomeUrl"/>'>Go To Student Home </a>
                </div>
            </div>
            <br>
            <br>
            <s:form id="studEditForm" action="studentEditExeAction" theme="simple" method="post">
                <div class="row">
                    <div class="col-12">
                        <s:actionmessage/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <s:actionerror/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <s:fielderror name="firstName" />
                        <label>
                        First Name
                        <s:textfield name="studentBean.firstName" />
                        </label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <label>
                        Last Name
                        <s:textfield name="studentBean.lastName" />
                        </label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <label>
                        Age
                        <s:textfield name="studentBean.age" />
                        </label>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-12">
                        <fieldset>
                            <legend style="font-size: medium">
                                Hair Colour
                            </legend>
                            <s:radio name="studentBean.hairColour" list="hairColours" />
                        </fieldset>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-12">
                        <label>
                            Country
                            <s:select name="studentBean.country" list="countries" />
                        </label>
                    </div>
                </div>
                <br>
                <br>
                <div class="row">
                    <div class="col-12">
                        <label>
                            <s:checkbox name="studentBean.organDonor"/>
                            Organ Donor
                        </label>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-12">
                        <s:submit value="Save" cssClass="btn btn-primary btn-lg" name="navButton" />
                    </div>
                </div>
            </s:form>
        </div> <!-- /main container -->
        <!-- JS -->
        <script src="js/tether.min.js"></script>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- End JS -->
    </body>
</html>

