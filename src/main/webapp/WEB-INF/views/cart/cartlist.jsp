<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:forEach items="${list}" var="p" varStatus="i">
	<div class="col-4">
		<div class="card" style="width: 18rem;">
			<div class="card-header">
				<input type="checkbox" data-pn="${p.productNum}" id="ch${i.index}"
					class="dlist">
				<button id="del" class="btn btn-info del">삭제</button>
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