<%@page import="bean.place"%>
<%@page import="bean.crimeType"%>
<%@page import="bean.resident"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="../segment/head.jsp" />
    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <jsp:include page="../segment/sidebar_admin.jsp" />
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">


                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <jsp:include page="../segment/topbar.jsp" />
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <%
                            resident obj = (resident) (request.getAttribute("obj"));
                        %>
                        <!-- Page Heading -->

                        <!-- Page Heading -->
                        <h1 class="h3 mb-4 text-gray-800">Crime Edit</h1>
                        <form class="user" action="eResident.do" method="POST">
                            <div class="form-group">
                                <label for="Crime ID">ID:</label>
                                <input type="text" class="form-control form-control-user" id="residentId" name="id" value="<%= obj.getId()%>" readonly>
                            </div>
                            <div class="form-group">
                                <label for="crimeName">IC:</label>
                                <input type="text" class="form-control form-control-user" id="crimeName" name="ic" value="<%= obj.getIc()%>">
                            </div>
                            <div class="form-group">
                                <label for="residentId">Name:</label>
                                <input type="text" class="form-control form-control-user" id="residentId" name="Name" value="<%= obj.getName()%>">
                            </div>
                            <div class="form-group">
                                <label for="residentId">Phone:</label>
                                <input type="text" class="form-control form-control-user" id="residentId" name="Phone" value="<%= obj.getPhone()%>">
                            </div>
                            <div class="form-group">
                                <label for="residentId">Password:</label>
                                <input type="text" class="form-control form-control-user" id="residentId" name="Password" value="<%= obj.getPassword()%>" readonly>
                            </div>

                            <button type="submit" class="btn btn-primary btn-user btn-block">Edit resident</button>
                            <hr>
                        </form>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <jsp:include page="../segment/footer.jsp" />
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <jsp:include page="../segment/Logout.jsp" />

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

    </body>

</html>