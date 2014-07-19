<%@ include file="template/header.jsp" %>

<%
    Float sueldo = Float.valueOf((String) session.getAttribute("sueldo"));
    Float extra = (sueldo * 10) / 100;
%>
<div class=" panel panel-primary">
    <div class="panel-heading">Consulte sus libros:</div>
    <div class="panel-group panel-body">



        <div class="col-lg-2">
            <span>Sueldo Extra: <h1><%=sueldo%></h1></span>
            <span>Sueldo Extra 10%: <h1><%=extra%></h1></span>
            <button class="btn btn-default"type="reset">Falta Implementar</button>
        </div>

        <div class="form-group">
            <label for="select" class="col-lg-2 control-label">Seleccione la categoria</label>
            <div class="col-lg-5">
                <select class="form-control" id="select" name="select">
                    <option>Libros Ultimos 7 Dias</option>
                    <option>10% sueldo, Categoria y Estrellas</option>
                    <option>Libros Usados, Con 50% sueldo</option>
                    <option>Categoria, 20% Sueldo, Autor</option>
                    <option>Categoria, Mes y que sea 5 Estrellas</option>
                </select>
                <br>                            
            </div>
        </div>

        <div class="form-group">       
            <div class="col-lg-10">
                <label for="select" class="col-lg-3 control-label">Cantidad de estrellas</label>
                <div class="radio">
                    <label class="col-md-1">
                        <input type="radio" name="estrellas" id="1" value="1">
                        <span class="glyphicon glyphicon-star">1</span>
                    </label>
                    <label class="col-md-1">
                        <input type="radio" name="estrellas" id="2" value="2">
                        <span class="glyphicon glyphicon-star">2</span>
                    </label>
                    <label class="col-md-1">
                        <input type="radio" name="estrellas" id="3" value="3">
                        <span class="glyphicon glyphicon-star">3</span>
                    </label>
                    <label class="col-md-1">
                        <input type="radio" name="estrellas" id="4" value="4">
                        <span class="glyphicon glyphicon-star">4</span>
                    </label>
                    <label class="col-md-1">
                        <input type="radio" name="estrellas" id="5" value="5">
                        <span class="glyphicon glyphicon-star">5</span>
                    </label>

                </div>
                <button type="submit" class="btn btn-primary btn-lg col-lg-offset-1">Aceptar <span class="glyphicon glyphicon-floppy-saved"></span></button>

            </div>
        </div>

    </div>
</div>







</div>

</div>

<%@ include file="template/footer.jsp"%>