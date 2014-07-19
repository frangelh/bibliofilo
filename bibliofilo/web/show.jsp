<%@ include file="template/header.jsp" %>

<%
Float sueldo =Float.valueOf((String)session.getAttribute("sueldo"));

%>
<div class=" panel panel-primary">
    <div class="panel-heading">Consulte sus libros:</div>
    <div class="panel-group panel-body">


        <label for="sueldo" class="col-lg-2 ">Sueldo Extra:</label>
        <div class="col-lg-2">
            <span> Su sueldo extra es: <h1><%=sueldo %></h1></span>

            <button class="btn btn-default"type="reset">Falta Implementar</button>
        </div>







    </div>

</div>

<%@ include file="template/footer.jsp"%>