<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>


<table class="table">
	<thead class="thead-dark">
		<!-- 제목은 힌번 나오면 됨 -->
		<tr>
			<th>댓글번호</th>
			<th>상품평</th>
			<th>작성자</th>
			<th>작성시간</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${list}" var="d">
			<!-- 포이치 반복문 돌리는것 리스트에서꺼낸걸 d라는변수에 담자-->

			<tr>
				<td>${d.reviewNum}</td>
				<td>${d.reviewContents}</td>
				<td>${d.username}</td>
				<td>
				<fmt:parseDate value="${d.reviewDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
				<fmt:formatDate value="${parsedDateTime}" pattern="yyyy-MM-dd HH:mm" />
				</td>

			</tr>

		</c:forEach>

	</tbody>
</table>