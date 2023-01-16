<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<%@include file="navbar.html"%>

		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:../../partials/_navbar.html -->
			<nav class="navbar p-0 fixed-top d-flex flex-row">
				<div
					class="navbar-brand-wrapper d-flex d-lg-none align-items-center justify-content-center">
					<a class="navbar-brand brand-logo-mini" href="../../index.html"><img
						src="../../assets/images/logo-mini.svg" alt="logo" /></a>
				</div>
				<div
					class="navbar-menu-wrapper flex-grow d-flex align-items-stretch">
					<button class="navbar-toggler navbar-toggler align-self-center"
						type="button" data-toggle="minimize">
						<span class="mdi mdi-menu"></span>
					</button>
					<ul class="navbar-nav w-100">
						<li class="nav-item w-100">
							<form class="nav-link mt-2 mt-md-0 d-none d-lg-flex search">
								<input type="text" class="form-control"
									placeholder="Search user">
							</form>
						</li>
					</ul>

					<button
						class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
						type="button" data-toggle="offcanvas">
						<span class="mdi mdi-format-line-spacing"></span>
					</button>
				</div>
			</nav>
			<!-- partial -->

			<div class="col-lg-12 mt-5 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">User Table</h4>
						
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>User ID</th>
										<th>Username</th>
										<th>Specialization</th>
										<th>Articles</th>
									</tr>
									<c:forEach items="${liste}" var="u">
										<tr>
										
										<!--	<td><c:choose>
													<c:when test="${p.photo==''}">
														<img width="50" height="50"
															src="../imagesdata/inconnu.jpg">
													</c:when>
													<c:when test="${p.photo!=''}">
														<img width="50" height="50" src="../imagesdata/${p.photo}">
													</c:when>
												</c:choose></td>-->
											<td>${u.idUser}</td>
											<td>${u.username}</td>
											<td><c:forEach items="${u.spec}" var="s" >${s.spec}&nbsp;</c:forEach>
											</td>
										<td><a href="/user/delete/${u.idUser}"
												class="border-0 btn btn-danger"> <span class="fa fa-trash">
														Delete</span>
											</a> <a href="/user/edit/${u.idUser}"
												class="btn btn-warning"> <span class="fa fa-edit">Edit</span>
											</a></td>
										</tr>
									</c:forEach>

								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- container-scroller -->
			<!-- plugins:js -->
			<script src="../assets/vendors/js/vendor.bundle.base.js"></script>
			<!-- endinject -->
			<!-- Plugin js for this page -->
			<!-- End plugin js for this page -->
			<!-- inject:js -->
			<script src="../assets/js/off-canvas.js"></script>
			<script src="../assets/js/hoverable-collapse.js"></script>
			<script src="../assets/js/misc.js"></script>
			<script src="../assets/js/settings.js"></script>
			<script src="../assets/js/todolist.js"></script>
			<!-- endinject -->
			<!-- Custom js for this page -->
			<!-- End custom js for this page -->
</body>
</html>