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
					<h1 class="h3 mb-4 text-gray-800">공지 세부내용</h1>
					<div class="row justify-content-center">
					<div class="col-6">
						
							
								
									<div>제목 : ${detail.boardTitle}</div>
									<div>작성자 : ${detail.boardWriter}</div>
									<div>
										${detail.boardContents}
									</div>
									<div>
										<c:forEach items="${detail.list}" var="f">
										<h6><a href="./down?fileNum=${f.fileNum}"> ${f.oriName} </a></h6>
										</c:forEach>
									</div>
					
						</div>
					</div>
					
					<div ><a class="btn btn-info" href ="./update?boardNum=${detail.boardNum}">공지수정</a>
						<form action="./delete" method="post">
						<input type="hidden" name="boardNum" value="${detail.boardNum}">
						
						<button class="btn btn-warning" type="submit">삭제</button>
					
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