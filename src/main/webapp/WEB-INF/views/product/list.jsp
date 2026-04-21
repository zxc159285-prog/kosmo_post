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
					<h1 class="h3 mb-4 text-gray-800">Product List Page</h1>
					
						<!-- 검색 폼 -->
					<div>
					<form action="./list" method="get">
					<div class="input-group mb-3">
					  <div class="input-group-prepend">
					  <select name="kind" class="custom-select">
					  <option ${pager.kind eq 'v1'?'selected':''} value="v1" class="dropdown-item">상품명</option>
					  <option ${pager.kind eq 'v2'?'selected':''} value="v2" class="dropdown-item">상품설명</option>
					  <option ${pager.kind eq 'v3'?'selected':''} value="v3" class="dropdown-item">상품종류</option>
					  </select>
					  
					  
					     <input type="text" value="${pager.search}" name="search" class="form-control" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
					  </div>
					  <button class="btn btn-outline-secondary" type="submit" id="button-addon1">검색</button>
					 
					</div>
					</form>
					</div>

					<div class="row">
						<c:forEach items="${list}" var="p">
							<div class="col-4">
								<div class="card" style="width: 18rem;">
									<img src="/files/${name}/${p.productFileDTO.fileName}"
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
					
					<div class="row justify-content-center">
					
					
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item ${pager.pre?'':'disabled'}"><a
									class="page-link"
									href="./list?page=${pager.pre?pager.start-1:pager.start}&search=${pager.search}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach begin="${pager.start}" end="${pager.end}" var="i">
									<li class="page-item"><a class="page-link"
										href="./list?page=${i}&search=${pager.search}">${i}</a></li>
								</c:forEach>
								<li class="page-item  ${pager.next?'':'disabled'}"><a
									class="page-link"
									href="./list?page=${pager.next?pager.end+1:pager.end}&search=${pager.search}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
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

</body>
</html>