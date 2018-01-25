<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Register</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sign/ajax.js"></script>
    <link href="${pageContext.request.contextPath}/sign/style.css" rel="stylesheet" type="text/css" media="all"/>

    <style>
        .inputRed {
            border: 1px solid #ff4040;
            background: #ffcece;
        }

        .inputGreen {
            border: 1px solid #83c954;
            background: #e8ffce;
        }</style>
</head>
<%@ include file="/includes/header.jsp" %>
<body>

<div id="register-box">
    <div class="Lright">
        <h1><fmt:message key="login.page.SignUp"/></h1>
        <form name="loginForm" method="POST" action="/register/">
            <input type="hidden" name="command" value="register"/>
            <input type="text" name="name" id=""
                   placeholder="<fmt:message key="register.page.name.label" />"/><span></span>
            <input type="text" name="surname" placeholder="<fmt:message key="register.page.surname.label" />"/>
            <input type="text" name="document" placeholder="<fmt:message key="register.page.document.label" />"/>
            <input type="text" name="login" id="login"
                   placeholder="<fmt:message key="login.page.label.Login" />"/><span></span>
            <input type="password" name="password" id="pass" style="margin-bottom: 2px"
                   placeholder="<fmt:message key="login.page.label.Password" />"/>
            <small style="padding: 4px">Не менее 6 символов</small>
            <input type="text" name="email" id="email"
                   placeholder="<fmt:message key="register.page.email.label" />"/>

            <input type="submit" name="signup_submit" id="submit" value="<fmt:message key="login.page.SignUp" />"
                   />
        </form>
    </div>

    <div class="Lleft">
        <a style="color: snow" href="${pageContext.request.contextPath}/login"><h1><fmt:message
                key="login.page.SignIn"/></h1></a>
    </div>
    <div class="or"><fmt:message key="login.page.OR.label"/></div>
</div>

<%--<script type="text/javascript">--%>
    <%--var login, email, password, password2, loginStat, emailStat, passwordStat;--%>
    <%--$("#login").change(function () {--%>
        <%--login = $("#login").val();--%>
        <%--var expLogin = /^[a-zA-Z]{1,20}$/g;--%>
        <%--var resLogin = login.search(expLogin);--%>
        <%--if (resLogin == -1) {--%>
            <%--$("#login").next().hide().text("Неверный  логин").css("color", "red").css(padding,4 ).fadeIn(400);--%>
            <%--$("#login").removeClass().addClass("inputRed");--%>
            <%--loginStat = 0;--%>
            <%--buttonOnAndOff();--%>
        <%--} else {--%>
            <%--loginStat = 1;--%>
            <%--buttonOnAndOff();--%>
        <%--}--%>
    <%--});--%>
    <%--$("#login").keyup(function () {--%>
        <%--$("#login").removeClass();--%>
        <%--$("#login").next().text("");--%>
    <%--});--%>


<%--//    function buttonOnAndOff() {--%>
<%--//        if (emailStat == 1 && passwordStat == 1 && password2Stat == 1 &&--%>
<%--//                loginStat == 1) {--%>
<%--//            $("#submit").removeAttr("disabled");--%>
<%--//        } else {--%>
<%--//            $("#submit").attr("disabled", "disabled");--%>
<%--//        }--%>
<%--//    }--%>
<%--</script>--%>

</body>
<%@ include file="/includes/footer.jsp" %>
</html>
