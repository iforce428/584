<!DOCTYPE html>
<%@page import="bean.place"%>
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

                        <!-- Page Heading -->
                        <h1 class="h3 mb-4 text-gray-800">Place Submission</h1>
                        <form class="user" action="ePlace.do" method="POST">
                            <%
                                place obj = (place) (request.getAttribute("place"));
                            %>
                            <div class="form-group">
                                <label for="crimeName">Place ID:</label>
                                <input type="text" class="form-control form-control-user" id="placeId" name="placeId" placeholder="Place Id" value="<%= obj.getId()%>">
                            </div>
                            <div class="form-group">
                                <label for="residentId">Place Name:</label>
                                <input type="text" class="form-control form-control-user" id="placename" name="placename" value="<%= obj.getPlaceName()%>">
                            </div>
                            <button type="submit" class="btn btn-primary btn-user btn-block">Register Place</button>
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