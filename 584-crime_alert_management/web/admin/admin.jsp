<%@page import="bean.chart"%>
<%@page import="bean.admin"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="../segment/head.jsp" />
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>

    <body id="page-top">

        <div id="wrapper">
            <jsp:include page="../segment/sidebar_admin.jsp" />

            <div id="content-wrapper" class="d-flex flex-column">
                <div id="content">
                    <jsp:include page="../segment/topbar.jsp" />

                    <%
                        admin obj = (admin) (request.getAttribute("adminData"));
                    %>
                    <div class="container-fluid">
                        <h1 class="h3 mb-2 text-gray-800">Welcome, <%= obj.getId()%></h1>

                        <%
                            ArrayList<chart> reportByYear = (ArrayList<chart>) (request.getAttribute("reportByYear"));
                            ArrayList<chart> reportBySeverity = (ArrayList<chart>) (request.getAttribute("reportBySeverity"));
                            ArrayList<chart> reportByPlace = (ArrayList<chart>) (request.getAttribute("reportByPlace"));
                            chart reportThisMonth = (chart) (request.getAttribute("reportThisMonth"));
                        %>
                        <div class="row">
                            <div class="col-xl-8 col-lg-7">
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Month by Month</h6>
                                    </div>
                                    <div class="card-body">
                                        <div class="chart-area">
                                            <canvas id="areaChart"></canvas>
                                        </div>
                                        <hr>
                                        This line chart shows the crime that has been submitted this year.
                                    </div>
                                </div>

                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">by Severity</h6>
                                    </div>
                                    <div class="card-body">
                                        <div class="chart-bar">
                                            <canvas id="barChart"></canvas>
                                        </div>
                                        <hr>
                                        This chart shows the amount of crime that has been reported by it's severity.
                                    </div>
                                </div>
                            </div>

                            <div class="col-xl-4 col-lg-5">
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">by Places</h6>
                                    </div>
                                    <div class="card-body">
                                        <div class="chart-pie pt-4">
                                            <canvas id="pieChart"></canvas>
                                        </div>
                                        <hr>
                                        This chart shows the amount of crime that has been reported in the area.
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <jsp:include page="../segment/footer.jsp" />
                <!-- End of Footer -->
            </div>
        </div>

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <jsp:include page="../segment/Logout.jsp" />

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                // Example configurations for different charts
                var areaCtx = document.getElementById('areaChart').getContext('2d');
                var areaChart = new Chart(areaCtx, {
                    type: 'line',
                    data: {
                        labels: [<%
                            for (int i = 0; i < reportByYear.size(); i++) {
                                out.println("\"" + reportByYear.get(i).getLabel() + "\",");
                            }
            %>],
                        datasets: [{
                                label: 'Crime Reported This year',
                                data: [<%
                                    for (int i = 0; i < reportByYear.size(); i++) {
                                        out.println("\"" + reportByYear.get(i).getData() + "\",");
                                    }
            %>],
                            }]
                    }
                });

                var barCtx = document.getElementById('barChart').getContext('2d');
                var barChart = new Chart(barCtx, {
                    type: 'bar', // Change the chart type if needed
                    data: {
                        labels: [<%
                            for (int i = 0; i < reportByPlace.size(); i++) {
                                out.println("\"" + reportByPlace.get(i).getLabel() + "\",");
                            }
            %>],
                        datasets: [{
                                label: 'Places',
                                data: [<%
                                    for (int i = 0; i < reportByPlace.size(); i++) {
                                        out.println("\"" + reportByPlace.get(i).getData() + "\",");
                                    }
            %>],
                                backgroundColor: ['#426ff5'],
                            }]
                    }
                });

                var pieCtx = document.getElementById('pieChart').getContext('2d');
                var pieChart = new Chart(pieCtx, {
                    type: 'doughnut',
                    data: {
                        labels: [<%
                            for (int i = 0; i < reportBySeverity.size(); i++) {
                                out.println("\"" + reportBySeverity.get(i).getLabel() + "\",");
                            }
            %>],
                        datasets: [{
                                data: [<%
                                    for (int i = 0; i < reportBySeverity.size(); i++) {
                                        out.println("\"" + reportBySeverity.get(i).getData() + "\",");
                                    }
            %>],
                                backgroundColor: ['#00FF00', '#FFFF00', '#FFA500', '#FF0000'],
                            }]
                    }
                });
            });
        </script>

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="js/sb-admin-2.min.js"></script>

    </body>

</html>
