<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:template>
    <a href="/">Главная</a>
    <form:form method="post" action="addContact" commandName="contact">
        <table>
            <tr>
                <td>
                    <form:label path="phone">Phone</form:label>
                </td>
                <td><form:input path="phone"/></td>
                <td><from:errors cssClass="error" path="phone"></from:errors></td>
            </tr>
            <tr>
                <td>
                    <form:label path="email">Email</form:label>
                </td>
                <td><form:input path="email"/></td>
                <td><from:errors cssClass="error" path="email"></from:errors></td>
            </tr>

            <tr>
                <td>
                    <form:label path="fio">F.I.O.</form:label>
                </td>
                <td><form:input path="fio"/></td>
                <td><from:errors cssClass="error" path="fio"></from:errors></td>
            </tr>

            <tr>
                <td>
                    <form:label path="note">Заметки</form:label>
                </td>
                <td><form:input path="note"/></td>
                    <td><from:errors cssClass="error" path="note"></from:errors></td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" value="add"/></td>
            </tr>
        </table>
    </form:form>
</t:template>
