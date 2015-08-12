<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<div class="jumbotron signin-color drop-shadow">
<div class="container">
<div class="row">
 <div class="col-md-offset-5 col-md-4">
      <form role="form" method="post" action="j_spring_security_check">
      <div class="form-login">
       <h4>Please sign in</h4>
        <input name="j_username" id="j_username" type="text" class="form-control" placeholder="Email address" required autofocus>
        </br>
        <input name="j_password" id="j_password" type="password" class="form-control" placeholder="Password" required>
         </br>
         <div class="wrapper">
         <span class="group-btn" >     
                <button class="btn btn-primary btn-md" type="submit">login <i class="fa fa-sign-in"></i></button>
            </span>
            </div>
             </br>
             <span class="group-btn" >   
            <a href="${forgotPasswordURL}" class="btn btn-default btn-block">Help to login</a>
            </span>
            </div>
      </form>
</div>
</div>
</div> <!-- /container -->
</div>