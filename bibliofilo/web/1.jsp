<%@ include file="template/header.jsp" %>

<%
    Float sueldo = Float.valueOf((String) session.getAttribute("sueldo"));

%>
<div class=" panel panel-primary">
    <div class="panel-heading">Consulte sus libros:</div>
    <div class="panel-group panel-body">
        <form class="form-horizontal" action="./show.jsp" method="POST">

            <fieldset>


                <div class="col-md-2">
                    <span>Sueldo Extra: <h1><%=sueldo%></h1></span>
                </div>
                <div class="col-lg-4">
                     <div class="form-group">
                    <label for="sueldo" class="col-lg-2 control-label">Sueldo extra:</label>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="extra" name="extra" placeholder="EX: 2000.00  " required>
                        <button class="btn btn-default"type="reset">Limpiar</button>
                    </div>
                </div>



                    <div class="col-md-8">
                        <input type="text" id="opcion" name="opcion" value="1" hidden="true" >

                        <button type="submit" class="btn btn-primary btn-lg">Aceptar <span class="glyphicon glyphicon-floppy-saved"></span></button>

                    </div>
                </div>


            </fieldset>
        </form>







    </div>

</div>

<%@ include file="template/footer.jsp"%>