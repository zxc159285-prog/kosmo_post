<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>


<table class="table">
	<thead class="thead-dark">
		<!-- 제목은 힌번 나오면 됨 -->
		<tr>
			<th>상품평</th>
			<th>평점</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th></th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${list}" var="d">
			<!-- 포이치 반복문 돌리는것 리스트에서꺼낸걸 d라는변수에 담자-->

			<tr>
				<td>${d.reviewContents}</td>
				<td>${d.reviewStar}</td>
				<td>${d.username}</td>
				<td>
				<fmt:parseDate value="${d.reviewDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
				<fmt:formatDate value="${parsedDateTime}" pattern="yyyy-MM-dd HH:mm" />
				</td>
				<td data-review-num="${d.reviewNum}">
				<button class="btn btn-outline-success review_update" data-toggle="modal" data-target="#reviewModal">수정</button>
				<button class="btn btn-outline-success review_delete">삭제</button>
				</td>

			</tr>

		</c:forEach>

	</tbody>
</table>