<%@ include file="common/header.jspf"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/welcome.jsp"%>
<div class="flex-container">
    <div class="left">
        <%@ include file="common/navigation.jspf"%>
    </div>
    <div class="right">
        <h2>My Requests</h2>
        <div id="errorMsg">
            ${error.message}
        </div>
        <table class="table table-striped">
            <caption>My Requests</caption>
            <thead>
            <tr>
                <th>Request Number</th>
                <th>Date Submitted</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requests}" var="request">
                <tr>
                    <td><label id="reqNo${request.id}">${request.id}</label></td>
                    <td><label id="empNo${request.id}"><fmt:formatDate pattern="dd-MM-yyyy"
                                                                       value="${request.submittedDate}" /></label></td>
                    <td><label id="empName${request.id}">${request.status}</label></td>
                    <td>
                        <a id="edit${request.id}" type="button" class="btn btn-primary" href="editrequest?id=${request.id}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<%@ include file="common/footer.jspf"%>