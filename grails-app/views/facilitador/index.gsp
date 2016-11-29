<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 07/11/16
  Time: 09:38
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="Facilitador" />
        <title><g:message code="default.home.label" args="[entityName]" /></title>
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
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:form url="[resource: laboratorioInstance]">
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="laboratorio"></label>
                        <g:select id="laboratorio" name="laboratorio" from="${residuosquimicos.Laboratorio.list()}" optionKey="id" optionValue="laboratorio" required="" value="${laboratorioInstance?.id}" class="many-to-one"/>
                    </div>
                    <div class="fieldcontain">
                        <label for="date"></label>
                        <g:datePicker name="date" precision="day" value="${params.date}"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton id="remove" formaction="removeAllSince" name="removeAllSince" class="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
                    <g:submitButton id="relatory" formaction="relatory" name="Relatory" class="relatory" action="relatory" value="${message(code: 'default.button.list.label', default: 'Relatory')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
