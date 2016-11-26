<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 07/11/16
  Time: 18:04
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main">
        <title><g:message code="default.resume.label"/></title>
    </head>

    <body>
        <a href="#list-residuo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
        <div id="list-residuo" class="content scaffold-list" role="main">
            <g:set var="entityName" value="${message(code: 'residuo.label', default: 'Residuo')}" />
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                <tr>

                    <g:sortableColumn property="nome" title="${message(code: 'residuo.nome.label', default: 'Nome')}" />

                    <g:sortableColumn property="descricao" title="${message(code: 'residuo.descricao.label', default: 'Descricao')}" />

                    <g:sortableColumn property="dataCadastro" title="${message(code: 'residuo.dataCadastro.label', default: 'Data Cadastro')}" />

                    <th><g:message code="residuo.laboratorio.label" default="Laboratorio" /></th>

                    <g:sortableColumn property="peso" title="${message(code: 'residuo.peso.label', default: 'Peso')}" />

                </tr>
                </thead>
                <tbody>
                <g:each in="${residuos}" status="i" var="residuoInstance">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                        <td><g:link action="show" id="${residuoInstance.id}">${fieldValue(bean: residuoInstance, field: "nome")}</g:link></td>

                        <td>${fieldValue(bean: residuoInstance, field: "descricao")}</td>

                        <td><g:formatDate date="${residuoInstance.dataCadastro}" /></td>

                        <td>${fieldValue(bean: residuoInstance, field: "laboratorio.laboratorio")}</td>

                        <td>${fieldValue(bean: residuoInstance, field: "peso")}</td>

                    </tr>
                </g:each>
                </tbody>
            </table>
            <div class="pagination">
                <g:paginate total="${residuoInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>