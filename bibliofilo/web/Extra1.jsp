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


                </div>
                <div class="form-group">
                    <input type="text" id="opcion" name="opcion" value="6" hidden="true" >
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

                <div class="col-lg-offset-2">
                    <div class="form-group">
                        <label class="col-md-2 control-label">Cantidad minima</label>
                        <div class="col-lg-5">
                            <div class="col-md-1">
                                <label>
                                    <input type="radio"  id="minima" name="minima" value="1" >
                                    <span class="glyphicon glyphicon-star" >1</span>
                                </label>
                            </div>

                            <div class="col-md-1">
                                <label>
                                    <input type="radio"  id="minima" name="minima" value="2" >
                                    <span class="glyphicon glyphicon-star" >2</span>

                                </label>
                            </div>
                            <div class="col-md-1">
                                <label>
                                    <input type="radio"  id="minima" name="minima" value="3" >
                                    <span class="glyphicon glyphicon-star" >3</span>

                                </label>
                            </div>
                            <div class="col-md-1">
                                <label>
                                    <input type="radio"  id="minima" name="minima" value="4" >
                                    <span class="glyphicon glyphicon-star" >4</span>

                                </label>
                            </div>
                            <div class="col-md-1">
                                <label>
                                    <input type="radio"  id="minima" name="minima" value="5" >
                                    <span class="glyphicon glyphicon-star" >5</span>

                                </label>
                            </div>
                        </div>
                    </div>  

                    <div class="form-group">
                        <label class="col-md-2 control-label">Cantidad Maxima</label>
                        <div class="col-lg-5">
                            <div class="col-md-1">
                                <label>
                                    <input type="radio"  id="maximo" name="maximo" value="1" >
                                    <span class="glyphicon glyphicon-star" >1</span>
                                </label>
                            </div>

                            <div class="col-md-1">
                                <label>
                                    <input type="radio"  id="maximo" name="maximo" value="2" >
                                    <span class="glyphicon glyphicon-star" >2</span>

                                </label>
                            </div>
                            <div class="col-md-1">
                                <label>
                                    <input type="radio"  id="maximo" name="maximo" value="3" >
                                    <span class="glyphicon glyphicon-star" >3</span>

                                </label>
                            </div>
                            <div class="col-md-1">
                                <label>
                                    <input type="radio"  id="maximo" name="maximo" value="4" >
                                    <span class="glyphicon glyphicon-star" >4</span>

                                </label>
                            </div>
                            <div class="col-md-1">
                                <label>
                                    <input type="radio"  id="maximo" name="maximo" value="5" >
                                    <span class="glyphicon glyphicon-star" >5</span>

                                </label>
                            </div>
                        </div>
                    </div>


                </div>
            </fieldset>
        </form>
    </div>
</div>





<%@ include file="template/footer.jsp"%>