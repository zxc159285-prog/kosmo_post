<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">

			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">로그인</h1>

					<div>
						<form:form action="./login" modelAttribute="memberDTO" method="post" enctype="multipart/form-data">
								<div class="input-group-prepend">
								<label class="input-group-text" id="username">ID</label>
								<form:input path="username" cssClass="form-control" id="username"/>
								
							</div>
							<div><form:errors path="username"></form:errors></div>
						
								<div class="input-group-prepend">
									<span class="input-group-text" id="password">PW</span>
								<form:password path="password" cssClass="form-control"/>
							</div>
							<div><form:errors path="password"></form:errors></div>
							<button type="submit" class="btn btn-primary">로그인</button>
							
						</form:form>
						



							
						
					</div>

				</div>
				<!-- End Page Container-fluid-->
			</div>
			<!-- End Page Content -->
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		</div>
		<!-- End Content-wrapper -->
	</div>
	<!-- End wrapper -->
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
</body>
</html>