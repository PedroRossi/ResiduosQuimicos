<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 07/11/16
  Time: 09:38
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="residuosquimicos.Laboratorio" %>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="Residuos" />
        <title>Index Facilitador</title>
    </head>
    <body>
        <a href="#list-laboratorio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="resumoSistema"><g:message code="default.resume.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div class="content scaffold-create" role="main">
          <h1><g:message code="default.delete.label" args="[entityName]"/> <g:message code="default.paginate.since"/></h1>
          <g:form url="[resource: laboratorioInstance]">
            <fieldset class="form">
                <div class="fieldcontain">
                    <label for="laboratorio"></label>
                    <g:select id="laboratorio" name="laboratorio" from="${residuosquimicos.Laboratorio.list()}" optionKey="id" optionValue="laboratorio" required="" value="${laboratorioInstance?.laboratorio?.id}" class="many-to-one"/>
                </div>
                <div class="fieldcontain">
                    <label for="date"></label>
                    <g:datePicker name="date" precision="day"/>
                </div>
            </fieldset>
            <fieldset class="buttons">
                <g:actionSubmit id="remove" name="Remove" class="delete" action="removeAllSince" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
                <g:actionSubmit id="relatory" name="Relatory" class="relatory" action="relatory" value="${message(code: 'default.button.list.label', default: 'Relatory')}" />
            </fieldset>
          </g:form>
        </div>
    </body>
</html>
