<%-- 
    Document   : books
    Created on : Jun 30, 2014, 10:23:29 AM
    Author     : frangel
--%>

<%@page import="bibliofilo.feed.FeedReader"%>
<%@page import="bibliofilo.feed.FeedMessage"%>
<%@page import="bibliofilo.feed.Feed"%>
<%@page import="bibliofilo.feed.FeedParser"%>
<%@page import="bibliofilo.feed.FiltroRSS"%>
<%@page import="bibliofilo.feed.Prolog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="template/header.jsp" %>
<ul class="list-group">



    <div class="list-group-item">
        <!--                <div class="photo">
                            <img src="http://lorempixel.com/350/260/technics/" class="img-responsive" alt="a" />
                        </div>-->
        <%FeedReader Pagina = new FeedReader();%>
        <%=Pagina.imprimir()%>
        <%Pagina.Save();%>

    </div>




    <ul


        <%@ include file="template/footer.jsp"%>
