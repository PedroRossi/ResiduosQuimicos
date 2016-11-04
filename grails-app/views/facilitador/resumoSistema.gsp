<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 04/11/16
  Time: 08:15
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title>Resumo Sistema</title>
    </head>
    <body>
        <a href="#list-residuo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
        <div class="content scaffold-show" role="main">
            <label>Peso total:</label>
            <p name="peso">
                ${peso}
            </p>
            <br>
            <label>Quantidade de residuos:</label>
            <p name="qntResiduos">
                ${qntResiduos}
            </p>
        </div>

    </body>
</html>