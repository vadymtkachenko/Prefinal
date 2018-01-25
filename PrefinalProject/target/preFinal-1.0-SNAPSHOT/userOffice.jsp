<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
    <title>Login</title>
    <title>Hello ${user.name}, you are logged with nickName ${user.login}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Login"/>
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class"/>
    <meta name="author" content="Codrops"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/LoginRegistrationForm/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/LoginRegistrationForm/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/LoginRegistrationForm/css/animate-custom.css"/>
</head>
<body>
<div class="container">
    <!-- Codrops top bar -->
    <div class="codrops-top">
        <a href="">
            <strong>&laquo; Previous Demo: </strong>Responsive Content Navigator
        </a>
        <span class="right">
                    <a href=" http://tympanus.net/codrops/2012/03/27/login-and-registration-form-with-html5-and-css3/">
                        <strong>Back to the Codrops Article</strong>
                    </a>
                </span>
        <div class="clr"></div>
    </div><!--/ Codrops top bar -->
    <header>
        <h1>Hello ${user.name}, you are logged with nickName ${user.login}</h1>
        <nav class="codrops-demos">
        </nav>
    </header>
</div>
</body>
</html>
