<%@ include file="template/header.jsp" %>

<div class=" panel panel-primary">
    <div class="panel-heading">Consulte sus libros: </div>

    <div class="panel-group">

        <form class="form-horizontal" action="./selectOption" method="POST">

            <fieldset>
                <legend>Formulario de consulta: </legend>
                <a href="./UpdateData"><span class="btn btn-success btn-lg col-lg-offset-10">Actualizar datos <span class="glyphicon glyphicon-refresh"></span></span></a>




                <div class="form-group">
                    <label for="sueldo" class="col-lg-2 control-label">Sueldo:</label>
                    <div class="col-lg-2">
                        <input type="number" class="form-control" id="sueldo" name="sueldo" placeholder="EX: 2000.00  " required>
                        <button class="btn btn-default"type="reset">Limpiar</button>
                    </div>
                </div>

                <div class="form-group">


                    <div class="col-lg-10">                      

                        <div class="form-group">
                            <label for="select" class="col-lg-2 control-label">Seleccione la opcion de su preferencia</label>
                            <div class="col-lg-5">
                                <select class="form-control" id="select" name="select">
                                    <option>Libros Ultimos 7 Dias</option>
                                    <option>10% sueldo, Categoria y Estrellas</option>
                                    <option>Libros Usados, 50% en otras y sueldo</option>
                                    <option>Categoria, 20% Sueldo, Autor</option>
                                    <option>Categoria, Mes y que sea 5 Estrellas</option>
                                    <option>Categoria, rango de estrellas</option>
                                    <option>Comming Soon</option>
                                    <option>Total Autor</option>

                                </select>
                                <br>                            
                            </div>

                            <button type="submit" class="btn btn-primary btn-lg col-lg-offset-1">Aceptar <span class="glyphicon glyphicon-floppy-saved"></span></button>
                        </div>



                    </div>


                </div>
            </fieldset>
        </form>  


    </div>

</div>

<%@ include file="template/footer.jsp"%>