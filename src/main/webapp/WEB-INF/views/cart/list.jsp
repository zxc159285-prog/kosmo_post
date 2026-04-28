<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">장바구니 List Page</h1>
					
						<!-- 검색 폼 -->
					<div>
					<form action="./list" method="get">
					<div class="input-group mb-3">
					</form>
					</div>
					<div class="row">
						<div>
							<input id="all" type="checkbox">
							<button class="btn btn-danger" id="allDel">선택삭제</button>
							<button class="btn btn-primary">선택가입</button>
						</div>
					</div>

					<div class="row">
					
					
						<c:forEach items="${list}" var="p" varStatus="i">
							<div class="col-4">
								<div class="card" style="width: 18rem;">
								<div class="card-header">
									<input type="checkbox" id="ch${i.index}" class="dlist"><button id="del" class="btn btn-info">삭제</button>
								</div>
									<img src="/files/product/${name}/${p.productFileDTO.fileName}"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">${p.productName}</h5>

										<a href="./detail?productNum=${p.productNum}"
											class="btn btn-primary">상세보기</a>
									</div>
								</div>
							</div>

						</c:forEach>
					

					</div>
					<div><a href="./create" class="btn btn-danger">상품등록</a></div>
					<div class="row justify-content-center">
					
					
						
					</div>
				</div>
				<!-- End Page container-fluid -->

			</div>
			<!-- End page Content -->
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		</div>
		<!-- End Content wrapper -->
	</div>
	<!-- End Wrapper -->

	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>

	<script src="/js/cart/list.js"></script>

</body>
</html>