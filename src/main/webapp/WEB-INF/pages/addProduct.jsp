<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:template>
    <a href="/">Главная</a>

    <form:form method="post" action="addProduct" commandName="pn">
        <table>
            <tr>
                <td>
                    <form:label path="name"> Name </form:label>
                </td>
                <td><form:input path="name"/></td>
                <td><from:errors cssClass="error" path="name"/></td>
            </tr>

            <tr>
                <td>
                    <form:label path="work_b"> Rabochaya Shirina </form:label>
                </td>
                <td><form:input path="work_b"/></td>
                <td>
                        <from:errors cssClass="error" path="work_b"/>
                <td>
            </tr>

            <tr>
                <td>
                    <form:label path="base_b"> Obshaya Shirina</form:label>
                </td>
                <td><form:input path="base_b"/></td>
                <td><from:errors cssClass="error" path="base_b"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="add"/></td>

            </tr>
        </table>
    </form:form>
</t:template>
