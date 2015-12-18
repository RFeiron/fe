<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:template>
  <a href="/">Главная</a>
  <c:if test="${!empty contact}">
    <table class="book-list-table">
      <tr>
        <th>Дата</th>
        <th>Телефон</th>
        <th>Эл. Почта</th>
        <th>Ф.И.О, Название орг-ии</th>
        <th>Заметки</th>
        <sec:authorize access="hasRole('admin')">
        <th>&nbsp;</th>
        </sec:authorize>
      </tr>
      <c:forEach items="${contact}" var="contact">
        <tr>
          <td>${contact.date_cr}</td>
          <td>${contact.phone}</td>
          <td>${contact.email}</td>
          <td>${contact.fio}</td>
          <td>${contact.note}</td>
          <sec:authorize access="hasRole('admin')">
          <td><a href="javascript:ContactUtils.deleteContact(${contact.id})">Delete</a></td>
          </sec:authorize>
        </tr>
      </c:forEach>
    </table>
  </c:if>
  <sec:authorize access="isAuthenticated()">
    <a href="addContact">Добавить контакт</a>
  </sec:authorize>

</t:template>
