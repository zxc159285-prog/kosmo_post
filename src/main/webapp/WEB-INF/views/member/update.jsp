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
					<h1 class="h3 mb-4 text-gray-800">정보 수정</h1>

					<div>
					<form:form method="post" modelAttribute="memberDTO" enctype="multipart/form-data">
							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text">이름</span>
								</div>
								<form:input path="name" cssClass="form-control" id="name1"/>
							</div>
							<div id="name2" class="error-msg"></div>
							<form:errors path="name"></form:errors>
								
							
							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text">PhoneNumber</span>
								</div>
								<form:input path="phone" cssClass="form-control" id="phone"/>
							</div>
							<form:errors path="phone"></form:errors>
							
							
							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text">email</span>
								</div>
								<form:input path="email" cssClass="form-control" id="email"/>
							</div>
							<form:errors path="email"></form:errors>
							
							<div class="mb-3">
								<label for="birth" class="form-label">생년월일</label> <input value="${member.birth}"
									type="date" class="form-control" id="birth" name="birth">
							</div>
							<form:errors path="birth"></form:errors>
							
							<div class="form-group">
								<label>프로필사진</label> <input type="file" name="attach" class="form-control">
							</div>

							<button type="submit" id="btn" class="btn btn-primary">수정</button>
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
	
	<script type="text/javascript"></script>
	<!-- <script src="/js/member/join.js"></script> -->
</body>
</html>