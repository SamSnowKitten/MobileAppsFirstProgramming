<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<c:if test="${!ajaxRequest}">
<html>
<head>
	<title>I-Ping Huang and Songming Liu's 1st programming assignment</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
</head>
<body>
</c:if>
	<div id="formsContent">
		<h2>Forms</h2>
		<form:form id="form" method="post" modelAttribute="formBean" cssClass="cleanform">
			<div class="header">
		  		<h2>Form</h2>
		  		<c:if test="${not empty message}">
					<div id="message" class="success"><c:out value="${message}"/></div>
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">Form has errors</div>
		  			</c:if>
		  		</s:bind>
			</div>
		  	<fieldset>
		  		<legend>To do list</legend>
		  		<form:label path="name">
		  			Name <form:errors path="name" cssClass="error" />
		 		</form:label>
		  		<form:input path="name" />

		  		<form:label path="age">
		  			Age <form:errors path="age" cssClass="error" />
		 		</form:label>
		  		<form:input path="age" />

		  		<form:label path="date">
		  			Birth Date (in form yyyy-mm-dd) <form:errors path="date" cssClass="error" />
		 		</form:label>
		  		<form:input path="date" />

		  		<form:label path="todo">
		  			Todo <form:errors path="todo" cssClass="error" />
		  		</form:label>
		  		<form:input path="todo" />
		  	</fieldset>

			<p><button type="submit">Submit</button></p>
		</form:form>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#form").submit(function() {
					$.post($(this).attr("action"), $(this).serialize(), function(html) {
						$("#formsContent").replaceWith(html);
						$('html, body').animate({ scrollTop: $("#message").offset().top }, 500);
					});
					return false;
				});
			});
		</script>
        <h2>Responses</h2>
        <p>
            All of the current TODOs!
        </p>
        <ul>
            <li>
                <a id="simpleLink" class="textLink" href="<c:url value="/forms" />">GET all forms</a>
            </li>
        </ul>
	</div>
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>
