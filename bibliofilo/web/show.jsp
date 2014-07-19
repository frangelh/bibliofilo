<%@page import="bibliofilo.classes.book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bibliofilo.feed.Prolog"%>
<%@ include file="template/header.jsp" %>

<%
    Float sueldo = Float.valueOf((String) session.getAttribute("sueldo"));
    Prolog pl = new Prolog(); //ConsultarProlog("sueldo10pociento("+Sueldo+",\'"+Categoria+"\')");
    String categoria = request.getParameter("select");
    System.out.print(categoria);
    ArrayList<book> consulta = pl.ConsultarProlog("sueldo10pociento(" + sueldo + ",\'" + categoria + "\')");
    for (book actual : consulta) {
        System.out.print(actual.GetBook());
%>

<div class=" panel panel-primary">
    <div class="panel-heading">Consulte sus libros:</div>
    <div>
        
        <%=actual.GetBook()%>  

    </div>

</div>

<% }%>
<%@ include file="template/footer.jsp"%>