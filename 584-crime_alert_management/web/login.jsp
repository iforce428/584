
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="./segment/head.jsp" />s
</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Welcome to Crime Alert System</h1>
                                    </div>
                                      <% 
                                        String errorMsgs = (String) request.getAttribute("errMessage");
                                        String success = (String) session.getAttribute("success");
                                        if(success != null){
                                        %>
                                        <p> 
                                            <font color='blue'>
                                             <%= success %>
                                             <%
                                                // Remove the session attribute after displaying it to avoid showing it again on subsequent requests
                                                session.removeAttribute("success");
                                            %>
                                            </font>
                                        </p>
                                        <% } %>    
                                    <%   
                                        if(errorMsgs != null){
                                    %>
                                        <p> 
                                            <font color='red'>Error:
                                             <%= errorMsgs %>
                                            </font>
                                        </p>
                                        <% } %>
                                    <form action="LoginServlet" method="POST" class="user">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                 name="username" aria-describedby="emailHelp"
                                                placeholder="Enter username">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                 name="password" placeholder="Password">
                                        </div>
                                        <input type="submit" value="Login"  class="btn btn-primary btn-user btn-block"/>
<!--                                        <a href="index.html" class="btn btn-primary btn-user btn-block">
                                            Login
                                        </a>-->
                                        <hr>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="register.jsp">Create an Account!</a>
                                    </div>
                                </div>
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