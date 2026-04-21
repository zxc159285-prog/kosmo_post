<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

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
						<form action="./create " method="Post"
							>
						

							<div class="input-group flex-nowrap">
							<input type="hidden" name="productNum" value="${param.productNum}">
								<div class="input-group-prepend">
									<span class="input-group-text" id="accountPw">Password</span>
								</div>
								<input type="password" class="form-control" name="accountPw"
									aria-label="accountPw" aria-describedby="addon-wrapping">
							</div>
							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text" id="passwordCheck">Password</span>
								</div>
								<input type="password" class="form-control" name="passwordCheck"
									aria-label="password" aria-describedby="addon-wrapping">
							</div>
						

							<button type="submit" class="btn btn-primary">로그인</button>
						</form>
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