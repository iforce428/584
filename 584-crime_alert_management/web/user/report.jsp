<%@page import="bean.place"%>
<%@page import="bean.crimeType"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@page import="bean.resident"%>
<html lang="en">

    <head>
        <jsp:include page="../segment/head.jsp" />
    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <jsp:include page="../segment/sidebar.jsp" />
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
                        <h1 class="h3 mb-4 text-gray-800">Crime Submission</h1>
                        <form class="user" action="reportController.do" method="POST">
                            <div class="form-group">
                                <label for="crimeName">Crime Name:</label>
                                <input type="text" class="form-control form-control-user" id="crimeName" name="crimeName" placeholder="Crime Name">
                            </div>
                            <div class="form-group">
                                <label for="residentId">Resident ID:</label>
                                <input type="text" class="form-control form-control-user" id="residentId" name="residentId" value="<%= obj.getId()%>" readonly>
                            </div>
                            <div class="form-group">
                                <label for="crimeId">Severity :</label>
                                <select class="form-control" id="crimeId" name="crimeId">
                                    <%
                                        ArrayList<crimeType> types = (ArrayList<crimeType>) (request.getAttribute("crimeType"));

                                        for (int i = 0; i < types.size(); i++) {
                                            out.print("<option value=" + types.get(i).getId() + ">" + types.get(i).getCrimeType() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="placeId">Place :</label>
                                <select class="form-control" id="placeId" name="placeId">
                                    <%
                                        ArrayList<place> places = (ArrayList<place>) (request.getAttribute("place"));

                                        for (int i = 0; i < places.size(); i++) {
                                            out.print("<option value=" + places.get(i).getId() + ">" + places.get(i).getPlaceName() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="notes">Notes (100 characters):</label>
                                <textarea class="form-control form-control-user" id="notes" name="notes" placeholder="Enter notes (100 characters)"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="date">Date:</label>
                                <input type="date" class="form-control form-control-user" id="date" name="date">
                            </div>
                            <button type="submit" class="btn btn-primary btn-user btn-block">Register Crime</button>
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