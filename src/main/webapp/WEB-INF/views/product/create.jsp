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
					<h1 class="h3 mb-4 text-gray-800">상품 등록</h1>

					<div>
						<form action="./create" method="Post" enctype="multipart/form-data">
							
							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text" id="productName">이름</span>
								</div>
								<input type="text" class="form-control" name="productName"
									aria-label="productName" aria-describedby="addon-wrapping">
							</div>
							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text" id="productContents">설명</span>
								</div>
								<input type="text" class="form-control" name="productContents"
									aria-label="productContents" aria-describedby="addon-wrapping">
							</div>

							<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text" id="productType">종류</span>
								</div>
								<input type="text" class="form-control" name="productType"
									aria-label="productType" aria-describedby="addon-wrapping">
							</div>
								<div class="input-group flex-nowrap">
								<div class="input-group-prepend">
									<span class="input-group-text" id="productRate">이자율</span>
								</div>
								<input type="text" class="form-control" name="productRate"
									aria-label="productRate" aria-describedby="addon-wrapping">
							</div>
						
							<div class="form-group">
								<label>첨부파일</label> <input type="file" name="attach"
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