<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<div class="container"> 
						<div id="signupbox" style="margin-top:50px" class="mainbox col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title">Register</div>
                            <div style="float:right; font-size: 14px; position: relative; top:-10px;"><a href="<c:url value="/signin"/>">Sign In</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form:form method="POST"  class="form-horizontal" role="form" commandName="registrationForm">
                               <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <form:input type="email" class="form-control" name="emailId" placeholder="Email Address" path="emailId" required="required"/>
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="firstname" class="col-md-3 control-label">First Name</label>
                                    <div class="col-md-9">
                                         <form:input type="text" class="form-control" name="firstname" placeholder="First Name" path="firstName" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                    <div class="col-md-9">
                                       <form:input type="text" class="form-control" name="lastname" placeholder="Last Name" path="lastName" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                        <form:input type="password" class="form-control" name="passwd" placeholder="Password" path="password" required="required"/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Usage Type</label>
                                    <div class="col-md-9">
                                        <form:select class="form-control" id="sel1" path="userTypeId" required="required">
													        <form:option value="">Select UserType</form:option>
													        <c:forEach var="item" items="${registrationForm.userTypes}">
													       <form:option value="${item.id}">${item.userType}</form:option>
													       </c:forEach>
													    </form:select>
                                        
                                    </div>
                                </div>
                                                           
                                 <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Job Title</label>
                                    <div class="col-md-9">
                                        <form:input type="text" class="form-control" name="jobTitle" placeholder="Title" path="jobTitle" required="required"/>
                                    </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Organization</label>
                                    <div class="col-md-9">
                                        <form:input type="text" class="form-control"  placeholder="Organization" path="organization" required="required"/>
                                    </div>
                                </div>
                                
                                      
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Employees Count</label>
                                    <div class="col-md-9">
                                        <form:input type="text" class="form-control" placeholder="No of Employees" path="noOfEmployees" required="required"/>
                                    </div>
                                </div>
                                
                               </div>
                               
                               <div class="col-sm-6">
                              
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Address 1</label>
                                    <div class="col-md-9">
                                        <form:input type="text" class="form-control"  placeholder="Address " path="address1" required="required"/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Address 2</label>
                                    <div class="col-md-9">
                                        <form:input type="text" class="form-control"  placeholder="Address " path="address2" required="required"/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Phone</label>
                                    <div class="col-md-9">
                                        <form:input type="text" class="form-control"  placeholder="111-111-1111" path="phoneNumber" required="required"/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">City</label>
                                    <div class="col-md-9">
                                        <form:input type="text" class="form-control"  placeholder="City" path="city" required="required"/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">State</label>
                                    <div class="col-md-9">
                                        <form:input type="text" class="form-control" name="" placeholder="State" path="state" required="required"/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Country</label>
                                    <div class="col-md-9">
                                        <form:input type="text" class="form-control"  placeholder="Country" path="country" required="required"/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Zipcode</label>
                                    <div class="col-md-9">
                                        <form:input type="text" class="form-control" name="jobTitle" placeholder="Zipcode" path="zipcode" required="required"/>
                                    </div>
                                </div>
                               <div class="form-group pull-right">
                                 <div class="col-md-offset-3 col-md-9">
						         <span class="group-btn  " >     
						                <button class="btn btn-primary btn-md" type="submit"> Register <i class="fa fa-sign-in"></i></button>
						            </span>
						           
                                </div>
                                </div>
                               </div>
                                  
                            </form:form>
                         </div>
                    </div>

               
               
                
         </div> 
    </div>
    
    
    
    