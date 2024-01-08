
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="./segment/head.jsp" />
    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                        <div class="col-lg-7">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                                </div>
                                <%
                                    List errorMsgs = (List) request.getAttribute("errorMsgs");
                                    if (errorMsgs != null) {
                                %>
                                <p> 
                                    <font color='red'>Please correct the following error:
                                <ul>
                                    <% Iterator items = errorMsgs.iterator();
                                        while (items.hasNext()) {
                                            String message = (String) items.next();
                                    %>
                                    <li><%= message%></li>
                                        <% } %>
                                </ul>
                                </font>
                                </p>
                                <% }%>
                                <form action="UserController" method="POST" class="user">
                                    <!--                                <div class="form-group row">
                                                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                                                            <input type="text" class="form-control form-control-user" id="exampleFirstName"
                                                                                placeholder="First Name">
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <input type="text" class="form-control form-control-user" id="exampleLastName"
                                                                                placeholder="Last Name">
                                                                        </div>
                                                                    </div>-->
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" id="exampleInputUsername" name="ic"
                                               placeholder="Enter IC">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user"
                                               id="exampleInputPassword" name="password" placeholder="Enter password">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                               id="exampleInputUsername" name="name" placeholder="Enter name">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                               id="exampleInputUsername" name="phone" placeholder="Enter phone number">
                                    </div>

                                    <!--                                <div class="form-group row">
                                                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                                                            <input type="password" class="form-control form-control-user"
                                                                                id="exampleInputPassword" placeholder="Password">
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <input type="password" class="form-control form-control-user"
                                                                                id="exampleRepeatPassword" placeholder="Repeat Password">
                                                                        </div>
                                                                    </div>-->

                                    <input type="submit" class="btn btn-primary btn-user btn-block" value="Register Account"/>
                                    <input type="hidden" name="method" value="add"/>

                                    <hr>

                                </form>
                                <hr>
                                <!--                            <div class="text-center">
                                                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                                                            </div>-->
                                <div class="text-center">
                                    <a class="small" href="login.jsp">Already have an account? Login!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

    </body>

</html>