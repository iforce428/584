<!DOCTYPE html>
<%@page import="bean.admin"%>
<%@page import="bean.resident"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">



    <head>
        <jsp:include page="../segment/head.jsp" />
        <style>
            .table-bordered input[type='text'] {
                border: none;
            }
        </style>
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
                            admin obj = (admin) (request.getAttribute("adminData"));
                        %>
                        <!-- Page Heading -->
                        <h1 class="h3 mb-4 text-gray-800">Welcome <%= obj.getId()%></h1>

                        <!-- Display other resident information as needed -->

                        <div class="container-fluid">

                            <!-- Page Heading -->

                            <!-- DataTales Example -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">All Crimes</h6>
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>ID</th>
                                                <th>IC</th>
                                                <th>NAME</th>
                                                <th>PHONE NUMBER</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                ArrayList<resident> Allresident = (ArrayList<resident>) request.getAttribute("obj");

                                                for (int i = 0; i < Allresident.size(); i++) {
                                            %>
                                        <form action='editResidentServlet.do' method='post'>
                                            <tr>
                                                <th scope='row'><%= (i + 1)%></th>
                                                <td> <input type='text' name='id'  readonly value='<%= Allresident.get(i).getId()%>' > </td>
                                                <td> <input type='text' name='ic' readonly value='<%= Allresident.get(i).getIc()%>' > </td>
                                                <td> <input type='text' name='name' readonly value='<%= Allresident.get(i).getName()%>' > </td>
                                                <td> <input type='text' name='phone' readonly value='<%= Allresident.get(i).getPhone()%>' > </td>
                                                <input type='hidden' name='c' readonly value='<%= Allresident.get(i).getPassword()%>' >
                                                
                                                <td>
                                                    <input type='submit' class='btn btn-primary flex-row-reverse' value='edit'>
                                                    <input type='submit' class='btn btn-primary flex-row-reverse' formaction='deleteCrime.do' value='delete'>
                                                </td>
                                            </tr>
                                        </form>
                                        <%
                                            }
                                        %>
                                        </tbody>

                                    </table>
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