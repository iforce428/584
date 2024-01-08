<!DOCTYPE html>
<%@page import="bean.resident"%>
<%@page import="bean.crime"%>
<%@page import="java.util.ArrayList"%>
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
                        <h1 class="h3 mb-4 text-gray-800">Welcome <%= obj.getName()%></h1>

                        <!-- Display other resident information as needed -->

                        <div class="container-fluid">

                            <!-- Page Heading -->

                            <!-- DataTales Example -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Crimes in The Area</h6>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>ID</th>
                                                    <th>CRIME SEVERITY</th>
                                                    <th>PLACE NAME</th>
                                                    <th>RESIDENT ID</th>
                                                    <th>CRIME NAME</th>
                                                    <th>CRIME DATE</th>
                                                    <th>NOTES</th>
                                                    <th>STATUS</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    ArrayList<crime> allCrime = (ArrayList<crime>) (request.getAttribute("crime"));

                                                    for (int i = 0; i < allCrime.size(); i++) {
                                                        out.print("<tr>");
                                                        out.print("<th scope='row'>" + (i + 1) + "</th>");
                                                        out.print("<td>" + allCrime.get(i).getID() + "</td>");
                                                        out.print("<td>" + allCrime.get(i).getCrimetype() + "</td>");
                                                        out.print("<td>" + allCrime.get(i).getPlace() + "</td>");
                                                        out.print("<td>" + allCrime.get(i).getResident_id() + "</td>");
                                                        out.print("<td>" + allCrime.get(i).getCrimename() + "</td>");
                                                        out.print("<td>" + allCrime.get(i).getTime() + "</td>");
                                                        out.print("<td>" + allCrime.get(i).getNotes() + "</td>");
                                                        out.print("<td>" + allCrime.get(i).getStatus() + "</td>");
                                                        out.print("</tr>");
                                                    }
                                                %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>


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