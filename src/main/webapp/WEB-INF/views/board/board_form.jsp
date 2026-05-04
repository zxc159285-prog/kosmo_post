<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
   <link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
    
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">
			
			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">공지 작성</h1>
					<div>
					<form  method="post" enctype="multipart/form-data">
					<input type="hidden" value="${update.boardNum}" name="boardNum">
						  <div class="form-group">
						    <label for="boardTitle">제목</label>
						    <input type="text" name="boardTitle" value="${update.boardTitle}" class="form-control" id="boardTitle">
						  </div>
						  
						  <div class="form-group">
						    <label for="boardWriter">작성자</label>
						    <input type="text" name="boardWriter"  value="${update.boardWriter}"class="form-control" id="boardWriter">
						  </div>
											 										 
						  <div class="form-group">
						    <label for="boardContents">내용</label>
						    <textarea rows="15" cols="60" name="boardContents" class="form-control" id="boardContents">${update.boardContents}</textarea>
						  </div>
						  
						  <div class="form-group">
							<button type="button" id="add">File Add</button>
						  </div>
						  <div class="form-group" id="result" data-file-size="${update.list.size()} ">
						  	<label id=>첨부파일</label>
						  	<c:forEach items="${update.list}" var="f">
						  	<div>
						  		<span>${f.oriName}</span> <button type="button">x</button>
						  	</div>
						  	</c:forEach>
						  </div>
						  
						  <button type="submit" class="btn btn-primary">저장하기</button>
						
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
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
	   <script>
      $('#boardContents').summernote({
        placeholder: '내용을 작성하세요',
        tabsize: 2,
        height: 100
      });
    </script>
    <script src="/js/board/form.js"></script>
</body>
</html>