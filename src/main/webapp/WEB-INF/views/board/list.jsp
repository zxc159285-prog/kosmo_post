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
					<h1 class="h3 mb-4 text-gray-800">${name}</h1>
					<!-- 내용 담는공간 -->
					<div class="row justify-content-center">
					<div class="col-8">
					
					<!-- 검색 폼 -->
					<div>
					<form action="./list" method="get">
					<div class="input-group mb-3">
					  <div class="input-group-prepend">
					  <select name="kind" class="custom-select">
					  <option ${pager.kind eq 'v1'?'selected':''} value="v1" class="dropdown-item">Title</option>
					  <option ${pager.kind eq 'v2'?'selected':''} value="v2" class="dropdown-item">Contents</option>
					  <option ${pager.kind eq 'v3'?'selected':''} value="v3" class="dropdown-item">Writer</option>
					  </select>
					  
					  
					     <input type="text" value="${pager.search}" name="search" class="form-control" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
					  </div>
					  <button class="btn btn-outline-secondary" type="submit" id="button-addon1">검색</button>
					 
					</div>
					</form>
					</div>
					
						<table class="table">
							<thead class="thead-dark">  <!-- 제목은 힌번 나오면 됨 -->
								<tr>
									<th>공지번호</th>
									<th>제목</th>
									<th>작성일</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${list}" var="d">  <!-- 포이치 반복문 돌리는것 리스트에서꺼낸걸 d라는변수에 담자-->
								
									<tr>
										<td>${d.boardNum}</td>
										<c:catch>
										<td><c:forEach begin="1" end="${d.boardDepth}">--</c:forEach></c:catch><a href="./detail?boardNum=${d.boardNum}">${d.boardTitle}</a></td>
										
										<td>${d.boardDate}</td>
									
									</tr>
									
								</c:forEach>
								
							</tbody>
						</table>
						
						<div>
						<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item ${pager.pre?'':'disabled'}">
      <a class="page-link" href="./list?page=${pager.pre?pager.start-1:pager.start}&search=${pager.search}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach begin="${pager.start}" end="${pager.end}" var="i">
								<li class="page-item"><a class="page-link" href="./list?page=${i}&search=${pager.search}">${i}</a></li>
							</c:forEach>
    <li class="page-item  ${pager.next?'':'disabled'}">
      <a class="page-link" href="./list?page=${pager.next?pager.end+1:pager.end}&search=${pager.search}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
						
							
						</div>
						
						<div>
							<a href ="./create">${name}작성</a>
						</div>
					</div>
					</div>
					<!-- 내용 끝 -->
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