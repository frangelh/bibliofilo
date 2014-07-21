<%@page import="bibliofilo.classes.book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bibliofilo.feed.Prolog"%>
<%@ include file="template/header.jsp" %>

<%
    Float sueldo = Float.valueOf((String) session.getAttribute("sueldo"));


%>
<div class=" panel panel-primary">
    <div class="panel-heading">Consulte sus libros:</div>
    <div class="panel-group panel-body">

        <form class="form-horizontal" action="./show.jsp" method="POST">

            <fieldset>

                <div class="col-lg-2">
                    <span>Sueldo Extra: <h1><%=sueldo%></h1></span>

                    <button class="btn btn-default"type="reset">Falta Implementar</button>
                </div>

                <div class="form-group">
                    <input type="text" id="opcion" name="opcion" value="5" hidden="true" >
                    <label for="select" class="col-lg-2 control-label">Seleccione la categoria</label>
                    <div class="col-lg-5">
                        <select class="form-control" id="select" name="select">
                            <option>Biographies & Memoirs</option>
                            <option>Business & Money</option>
                            <option>Children's Books</option>
                            <option>Computers & Technology</option>
                            <option>Cookbooks, Food & Wine</option>
                            <option>Dance & Electronic</option>
                            <option>History</option>
                            <option>Health, Fitness & Dieting</option>
                            <option>Parenting & Relationships</option>
                            <option>Mystery, Thriller & Suspense</option>
                            <option>Literature & Fiction</option>
                        </select>
                        <br>                            
                    </div>
                    <button type="submit" class="btn btn-primary btn-lg col-lg-offset-1">Aceptar <span class="glyphicon glyphicon-floppy-saved"></span></button>

                </div>

            </fieldset>
        </form>
    </div>
</div>







</div>

</div>

<%@ include file="template/footer.jsp"%>