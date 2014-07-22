<%@ include file="template/header.jsp" %>

<%
    Float sueldo = Float.valueOf((String) session.getAttribute("sueldo"));
    Float extra = (sueldo * 20) / 100;
%>
<div class="row">
    <div class=" panel panel-primary">
        <div class="panel-heading">Consulte sus libros:</div>
        <div class="panel-group panel-body">

            <form class="form-horizontal" action="./show.jsp" method="POST">

                <fieldset>


                    <div class="col-md-2">
                        <span>Sueldo: <h1><%=sueldo%></h1></span>
                        <span>Sueldo 20%: <h1><%=extra%></h1></span>                     
                    </div>
                    <div class="col-lg-4">


                        <div class="col-md-8">
                            <input type="text" id="opcion" name="opcion" value="9" hidden="true" >
                            <button class="btn btn-default "type="reset">Limpiar</button>
                            <button type="submit" class="btn btn-primary btn-lg">Aceptar <span class="glyphicon glyphicon-floppy-saved"></span></button>

                        </div>
                    </div>


                </fieldset>
            </form>
        </div>

    </div>



</div>



<%@ include file="template/footer.jsp"%>