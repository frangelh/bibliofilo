<%@ include file="template/header.jsp" %>
<div class=" panel panel-primary">
    <div class="panel-heading">Consulte sus libros:</div>
    <div class="panel-group">
        <form class="form-horizontal" action="#" method="POST">
            <fieldset>
                <legend>Formulario de consulta: </legend>
                <div class="form-group">
                    <label for="sueldo" class="col-lg-2 control-label">Sueldo Extra:</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="sueldo" name="sueldo" placeholder="EX: 2000.00  ">
                        <button class="btn btn-default"type="reset">Limpiar</button>
                    </div>
                </div>

                <div class="form-group">


                    <div class="list-group col-lg-10 col-lg-offset-2">                      

                        <button type="submit" class="btn btn-primary">Libros 7 dias</button>   

                        <button type="submit" class="btn btn-primary">10%,Categoria &  <span class="glyphicon glyphicon-star"></span></button>
                        <button type="submit" class="btn btn-primary">Usados, con 50%</button>
                        <button type="submit" class="btn btn-primary">Categoria, 20%, Autor</button>
                        <button type="submit" class="btn btn-primary">Categoria,Mes, & <span class="glyphicon glyphicon-star">5</span> </button>
                        
                    </div>


                </div>
            </fieldset>
        </form>  


    </div>

</div>

<%@ include file="template/footer.jsp"%>