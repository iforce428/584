<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-feather2" viewBox="0 0 16 16">
                <path d="M7.5 1.063v9.556L6 8.819V3a2 2 0 0 1 1.5-1.937M8 0a3 3 0 0 0-3 3v6a.5.5 0 0 0 .116.32L7.5 12.181V15.5a.5.5 0 0 0 1 0v-3.319l2.384-2.86A.5.5 0 0 0 11 9V3a3 3 0 0 0-3-3m.5 1.063A2 2 0 0 1 10 3v.293l-1.5 1.5zM10 4.707V8.82l-1.5 1.8V6.207z"/>
            </svg>

        </div>
        <div class="sidebar-brand-text mx-3">Reporting System </div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <a class="nav-link" href="adminServlet">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="crimeAdminServlet" aria-expanded="true" aria-controls="collapseTwo">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-feather2" viewBox="0 0 16 16">
                        <path d="M7.5 1.063v9.556L6 8.819V3a2 2 0 0 1 1.5-1.937M8 0a3 3 0 0 0-3 3v6a.5.5 0 0 0 .116.32L7.5 12.181V15.5a.5.5 0 0 0 1 0v-3.319l2.384-2.86A.5.5 0 0 0 11 9V3a3 3 0 0 0-3-3m.5 1.063A2 2 0 0 1 10 3v.293l-1.5 1.5zM10 4.707V8.82l-1.5 1.8V6.207z"/>
                    </svg>
                    <span>Crime</span>
                </a>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                   aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Places</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="placeAdminServlet.do">view Places</a>
                        <a class="collapse-item" href="placeSubmitServlet.do">Add Places</a>
                    </div>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link collapsed" href="residentAdminServlet.do"
                   aria-expanded="true" aria-controls="collapseUtilities">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
                        <path d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1zm-7.978-1L7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002-.014.002zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4m3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0M6.936 9.28a6 6 0 0 0-1.23-.247A7 7 0 0 0 5 9c-4 0-5 3-5 4q0 1 1 1h4.216A2.24 2.24 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816M4.92 10A5.5 5.5 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275ZM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0m3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4"/>
                    </svg>
                    <span>Resident</span>
                </a>
            </li>

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            </ul>