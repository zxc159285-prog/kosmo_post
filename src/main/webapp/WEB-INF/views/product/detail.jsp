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
					<h1 class="h3 mb-4 text-gray-800">Detail Page</h1>
					
					<h3>상품명 : ${dto.productName}</h3>
					<h3>설명 : ${dto.productContents}</h3>
					<h3>이율 : ${dto.productRate}</h3>
					
					
					<a href="../account/create?productNum=${dto.productNum}" class="btn btn-primary">상품가입</a>
					<button id="cart" data-pn="${dto.productNum}" class="btn btn-danger">담기</button>
					<div id="review_list">
					
					</div>
					<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="reviewStar" value="option5">
  <label class="form-check-label" for="inlineCheckbox1">⭐5</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="reviewStar" value="option4">
  <label class="form-check-label" for="inlineCheckbox2">⭐4</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="reviewStar" value="option3">
  <label class="form-check-label" for="inlineCheckbox3">⭐3</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="reviewStar" value="option2">
  <label class="form-check-label" for="inlineCheckbox4">⭐2</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="reviewStar" value="option1">
  <label class="form-check-label" for="inlineCheckbox5">⭐1</label>
</div>

					<div>
					<textarea id="contents" rows="6" cols=""></textarea>
					<button id="add">등록</button>
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
	<!-- Modal -->
<div>
<div class="modal fade" id="reviewModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <textarea rows="" cols="" id="contents_update"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="close">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" id="update_btn">Save changes</button>
      </div>
    </div>
  </div>
</div>
</div>


	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
	<script src="/js/cart/cart.js"></script>
	<script src="/js/review/reviewlist.js"></script>
</body>
</html>