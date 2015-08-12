<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<c:url value="/"/>">docXchange</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href=" <c:url value="/"/>">Home</a></li>
             <security:authorize  ifNotGranted="ROLE_ANONYMOUS">
            <li><a href=" <c:url value="/search"/>">Search</a></li>
             <security:authorize  ifAnyGranted="ROLE_USER,ROLE_ADMIN">
            <li><a href=" <c:url value="/upload"/>">Upload</a></li>
            </security:authorize>
             <security:authorize  ifAnyGranted="ROLE_ADMIN">
            <li><a href=" <c:url value="/dashboard"/>">Dashboard</a></li>
            </security:authorize>
            </security:authorize>
           <!--    <li ><a href="/web101/dashboard">Dashboard</a></li>
            <li class="active" class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">More <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                 <li><a href="/web101/form">Form Submission</a></li>
                <li ><a href="/web101/file">File Upload</a></li>
                <li class="active"><a href="/web101/multifileupload">Multiple File Upload</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Wikipedia</li>
                <li ><a href="/web101/wikisearch">Wiki Search</a></li>
                <li ><a href="/web101/wikiaugmentedreality">Simulated Augmented Reality</a></li>
                 <li class="divider"></li>
                  <li class="dropdown-header">youtube</li>
                <li><a href="/web101/realtimecomment">Realtime Comment System</a></li>                 
              </ul>
            </li>-->
          </ul>
          <ul class="nav navbar-nav navbar-right">
           
              <li><a href="<c:url value="/contact"/>">Contact Us</a></li>
              
              <security:authorize  ifAnyGranted="ROLE_ANONYMOUS">
              <li><a href="<c:url value="/signin"/>">Sign in</a></li>
              <li><a href="<c:url value="/registration"/>">Register</a></li>
              </security:authorize>
              <security:authorize  ifNotGranted="ROLE_ANONYMOUS">
             <li ><a href="<c:url value="/logout"/>">logout</a></li>
             <li><a href="#">Welcome  <security:authentication property="principal.username" /></a></li>
             </security:authorize> 
          </ul>
        <!--    <form:form method="post" action="/web101/search" class="navbar-form navbar-right" role="search">
        <div class="input-group">
            <input type="text" class="form-control" size="35" placeholder="Search" name="q"/>
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form:form>-->
        </div><!--/.nav-collapse -->
      </div>
    </nav>