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
					<h1 class="h3 mb-4 text-gray-800">회원가입페이지</h1>

					<div>
						<form action="./join" method="Post" enctype="multipart/form-data">
							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text" id="username">ID</span>
								</div>
								<input type="text" class="form-control" name="username"
									aria-label="username" aria-describedby="addon-wrapping">
							</div>
							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text" id="name">이름</span>
								</div>
								<input type="text" class="form-control" name="name"
									aria-label="name" aria-describedby="addon-wrapping">
							</div>
							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text" id="password">PW</span>
								</div>
								<input type="password" class="form-control" name="password"
									aria-label="password" aria-describedby="addon-wrapping">
							</div>

							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text" id="phone">PhoneNumber</span>
								</div>
								<input type="text" class="form-control" name="phone"
									aria-label="phone" aria-describedby="addon-wrapping">
							</div>
							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text" id="email">email</span>
								</div>
								<input type="email" class="form-control" name="email"
									aria-label="email" aria-describedby="addon-wrapping">
							</div>
							<div class="mb-3">
								<label for="birth" class="form-label">생년월일</label> <input
									type="date" class="form-control" id="birth" name="birth">
							</div>
							<div class="form-group">
								<label>프로필사진</label> <input type="file" name="attach"
									class="form-control">
							</div>

							<button type="submit" class="btn btn-primary">가입</button>
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