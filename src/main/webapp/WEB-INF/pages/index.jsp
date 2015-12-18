<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:template>
    <sec:authorize access="isAuthenticated()">
    <a href="calc"><img src="${pageContext.request.contextPath}/resources/img/calc.jpg" width="217" height="217">Калькулятор</a>
    <a href="product"><img src="${pageContext.request.contextPath}/resources/img/st.jpg" width="217" height="217">Продукция</a>
    <a href="contact"><img src="${pageContext.request.contextPath}/resources/img/VCard.png" width="217" height="217">Контакты</a>
    </sec:authorize>
</t:template>
