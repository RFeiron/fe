<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:template>
    <a href="/">Главная</a>

    <c:if test="${!empty lists}">
        <table class="book-list-table">
            <tr>
                <th>Название</th>
                <th>Рабочая ширина</th>
                <th>Общая ширина</th>
                <sec:authorize access="hasRole('admin')">
                    <th>&nbsp;</th>
                </sec:authorize>


            </tr>
            <c:forEach items="${lists}" var="pn">
                <tr>
                    <td>${pn.name}</td>
                    <td>${pn.work_b}</td>
                    <td>${pn.base_b}</td>
                    <sec:authorize access="hasRole('admin')">
                        <td><a href="javascript:PnUtils.deletePn(${pn.id})">Delete</a></td>
                    </sec:authorize>

                </tr>
            </c:forEach>
        </table>
    </c:if>
    <sec:authorize access="isAuthenticated()">
        <a href="addProduct">Add Product</a>
    </sec:authorize>

</t:template>
