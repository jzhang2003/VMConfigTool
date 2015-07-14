<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.minli.web.form.SearchMainForm"%>
<%@ page import="com.minli.persistence.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
String strOutputUserName= request.getParameter("userName");
String strOutputPassword = request.getParameter("password");
String strOutputConfMode = request.getParameter("confMode");
List<TaskLog> taskLogList = (List<TaskLog>)request.getAttribute("taskLogList");

%>

   <link href="./css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link href="./css/font-awesome.min.css" rel="stylesheet" media="screen">
    <link href="./css/buttons.css" rel="stylesheet" media="screen">
    <link href="./css/typeahead.js-bootstrap.css" rel="stylesheet" media="screen">
    <link href="./css/bootstrap-select.css" rel="stylesheet" media="screen">
    <style type="text/css" title="currentStyle">
			@import "./css/demo_page.css";
			@import "./css/demo_table.css";
			.widgetGroup{
				
			}
			.form-group {
				margin-bottom: 15px;
				margin-left: 0px;
				margin-right: 0px;
			}
			.contentContainer{
				padding-left: 30px;
				padding-right: 30px;
			}
			.control-label {
				text-align: right;
				margin-right: 10px;
				width: 35%;
			}
	</style>
	
<script type="text/javascript" src="./js/jquery.js" charset="UTF-8"></script>
<!-- <script type="text/javascript" src="./js/jquery-1.9.1.js" charset="UTF-8"></script> -->
<script type="text/javascript" src="./js/jquery.dataTables.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="./js/bootstrap-typeahead.js"></script>
<script type="text/javascript" src="./js/bootstrap-select.js"></script>
<script type="text/javascript" src="./js/buttons.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/highcharts.js" charset="UTF-8"></script> 

<title>Main Page</title>
</head>
<body>
<div class="contentContainer">
    <form action="SearchMain" class="form-horizontal" role="form" onsubmit="return validateForm()">
     <fieldset>
     <br>
     
   		<div class="form-group">
   			<div style="width: 25%;float:left;" class="widgetGroup">
  				<label class="control-label">confMode</label>
  				
			  	<select class="selectpicker" id="confModeSelectpicker" name="confMode" data-width="60%">
   					 <option value="mode1" <%if("v3apicscore".equals(strOutputConfMode)) { %>SELECTED <% } %>>mode1</option>
   					 <option value="mode2" <%if("v3apics1core".equals(strOutputConfMode)) { %>SELECTED <% } %>>mode2</option>					 
  				</select>
  			</div>
  			
   			<div style="width: 45%;float:left;" class="widgetGroup">
				<label class="control-label" style="width: 30%;float: left;">UserName</label>
				<input id="userName" style="width: 65%;" type="text" class="form-control span3" placeholder="Please input UserName" value= "${userName}" data-provide="typeahead" name="userName" autocomplete="off">
			</div>

   			<div style="width: 45%;float:left;" class="widgetGroup">
				<label class="control-label" style="width: 30%;float: left;">password</label>
				<input id="password" style="width: 65%;" type="text" class="form-control span3" placeholder="Please input Password" value= "${password}" data-provide="typeahead" name="password" autocomplete="off">
			</div>
			
			<div style="width: 25%;float:left;" class="widgetGroup">
            	<input type="submit" value="search" name = "Submit1" class="button button-pill button-primary" style="margin-left:40px;"/>
                &nbsp;
  				&nbsp;
				<input type="submit" value="export" name = "Submit2" class="button button-pill button-primary" style="margin-left: 10px;"/>
			</div>	
		</div>    
     
     
     
     </fieldset>

	</form>
	
	
	<label>${userName} ${password} ${confMode}</label>
	<label>${resultStr}</label>
	
	
	      <div>
      <br/>
           	<table class="table table-bordered table-striped table-hover table-condensed" id = "apiErrortable">
      		<thead>
      			<tr class="success">
      				<th>TaskId</th>
      				<th>TaskStatus</th>
      				<th>LogData</th>
      			</tr>
      		<thead>
      
      		 <tbody>
           <c:forEach items="${taskLogList}" var="taskLogForm">
           
      			<tr>
      				<td>${taskLogForm.taskLogId}</td>
      				 <td>${taskLogForm.taskStatus}</td>
      				
      				<td>${taskLogForm.logData}</td>
      			</tr>    
			 </c:forEach>
			 </tbody>
      
      	</table>
      </div>   
	
	
</div>




<script type="text/javascript">





</script>

</body>
</html>