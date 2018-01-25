<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/sign/style.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<%@ include file="/includes/header.jsp" %>
<body>
<div id="login-box">
    <div class="left">
        <h1><fmt:message key="login.page.SignIn"/></h1>
        <form name="loginForm" method="POST" action="/loginUser">
            <input type="hidden" name="command" value="login"/>

            <input type="text" name="login" placeholder="<fmt:message key="login.page.label.Login" />"/>
            <input type="password" name="password" placeholder="<fmt:message key="login.page.label.Password" />"/>
            <input type="submit" name="signup_submit" value="<fmt:message key="login.page.SignIn" /> "/>
        </form>
    </div>

    <div class="right">
        <a style="color: snow" href="${pageContext.request.contextPath}/register"><h1><fmt:message
                key="login.page.SignUp"/></h1></a>
    </div>
    <div class="or"><fmt:message key="login.page.OR.label"/></div>
</div>
</body>
<%@ include file="/includes/footer.jsp" %>
</html>