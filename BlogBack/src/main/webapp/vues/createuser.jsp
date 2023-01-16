<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<%@include file="navbar.html"%>
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><p>Forms</p>
                  <li class="breadcrumb-item active" aria-current="page">Create User</li>
                </ol>
              </nav>
            </div>
            <div class="row">
              <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Create User</h4>
                    <p class="card-description"> </p>
                    <form class="forms-sample" method="post" action="/user/save">
                      <div class="form-group">
                        <label for="exampleInputUsername1">Username</label>
                        <input type="text" value="${user.username}" class="form-control" id="username" name="username" placeholder="Username">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control" value="${address.text}" id="address" name="text" placeholder="Address">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" Value="${user.password}" class="form-control" id="password" name="password" placeholder="Password">
                      </div>
                      <div class="form-group">
						<label for="specs" >Specilizations : </label>
				             <select name="spec" class="form-control" multiple required>
                              <option hidden>Choose here</option>
                              <c:forEach items="${specs}" var="s">
                                <option value="${s.idSpec}" <c:forEach items="${user.spec}" var="u"> <c:if test="${u.idSpec==s.idSpec}">selected="true"</c:if>  </c:forEach>>${s.spec}</option>
                              </c:forEach>
                            </select>
						</div>
											<input type=hidden name=id value="${produit.id}">
                      <button type="submit" class="btn btn-primary mr-2">Submit</button>
                    </form>
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
