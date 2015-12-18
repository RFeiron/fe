<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<jsp:directive.page contentType="text/html;charset=Utf-8"/>

<t:template>

    <form:form method="get" action="calc">
        <a href="<c:url value="/"/>">Главная</a>

        <h1 id="header">Калькулятор односкатной кровли</h1>
        <table>
            <div id="nav">
            <ol>
                <li>
                    <a href="calc">Односкатная</a>
                </li>
                <li><a href="calc1">Двускатная</a> </li>
                <li><a href="#">Ломаная</a> </li>
                <li><a href="#">Вальмовая</a> </li>
                <li><a href="#">Мансардная</a> </li>
                <li><a href="#">Плоская</a> </li>
                <li><a href="#">Забор</a> </li>
            </ol>
            </div>
            <img src="\resources\img\i.jpg">
            <div>
            <tr>
                <td>
                    <form><label path="a"> Длина </label></form>
                </td>
                <td><input type="text" name="a" value="${pn.a}"/></td>
            </tr>

            <tr>
                <td>
                    <form><label path="b"> Ширина </label></form>
                </td>
                <td><input type="text" name="b" value="${pn.b}"/></td>
            </tr>

            <tr>
                <td>
                    <form><label path="work_B"> Полезная ширина листа </label></form>
                </td>
                <td><input type="text" name="work_B" value="${pn.work_b}"/></td>
            </tr>


            <tr>
                <td>
                    <form><label path="bas_B">Общая ширина листа</label></form>
                </td>
                <td><input type="text" name="bas_B" value="${pn.base_b}"/></td>

            </tr>
            </div>

            <td><p>Количество профнастила:</p>
            <input type="text" name="result" value="${result}"/>м.кв.
            <p>Количество саморезов: </p>
            <input type="text" name="sam" value="${sam}"/>шт.
                <p>Количество листов:</p>
                <input type="text" name="kl" value="${kl}"/>шт.</td>

            <td colspan="2"><input type="submit" value="считать"/></td>
        </table>
    </form:form>
</t:template>

