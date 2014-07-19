<%@ include file="template/header.jsp" %>

<%
    Float sueldo = Float.valueOf((String) session.getAttribute("sueldo"));
    Float extra = (sueldo * 50) / 100;
%>
<div class=" panel panel-primary">
    <div class="panel-heading">Consulte sus libros:</div>
    <div class="panel-group panel-body">



        <div class="col-lg-2">
            <span>Sueldo Extra: <h1><%=sueldo%></h1></span>
            <span>Sueldo Extra 50%: <h1><%=extra%></h1></span>
            <button class="btn btn-default"type="reset">Falta Implementar</button>
        </div>

        <div class="list-group">
            <label for="select" class="col-lg-5 control-label">Libros usados que cuestan menos del 50% del extra </label>
            <div class="col-lg-6">
                <h1>Deberian salir los libros</h1>
                                           
            </div>
        </div>

        

    </div>
</div>







</div>

</div>

<%@ include file="template/footer.jsp"%>