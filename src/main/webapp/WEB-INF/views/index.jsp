<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kosmo Post - Welcome</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
<style>
    /* Toss-like UI Overrides */
    body#page-top {
        background-color: #f2f4f6 !important;
        font-family: 'Pretendard', -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;
    }
    #content {
        background-color: #f2f4f6 !important;
    }
    .container-fluid {
        padding-top: 2rem;
        max-width: 1000px;
    }
    .toss-card {
        background: #ffffff;
        border-radius: 24px;
        padding: 24px;
        margin-bottom: 1.5rem;
        border: none;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.05);
        transition: transform 0.2s ease;
    }
    .toss-card:hover {
        transform: translateY(-2px);
    }
    .toss-title {
        color: #191f28;
        font-weight: 700;
        font-size: 1.5rem;
        margin-bottom: 1rem;
    }
    .toss-text {
        color: #4e5968;
        font-size: 1rem;
        line-height: 1.6;
    }
    .toss-blue {
        color: #3182f6;
    }
    .btn-toss {
        background-color: #3182f6;
        color: white;
        border-radius: 12px;
        padding: 12px 24px;
        font-weight: 600;
        border: none;
        display: inline-block;
        text-decoration: none;
    }
    .btn-toss:hover {
        background-color: #1b64da;
        color: white;
        text-decoration: none;
    }
    .service-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
        gap: 1.5rem;
        margin-bottom: 1.5rem;
    }
    .service-item {
        background: #ffffff;
        border-radius: 20px;
        padding: 20px;
        text-align: center;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.04);
        cursor: pointer;
        text-decoration: none;
        color: inherit;
    }
    .service-item i {
        font-size: 2rem;
        margin-bottom: 12px;
        color: #3182f6;
    }
    .service-item span {
        display: block;
        font-weight: 600;
        color: #191f28;
    }
    #map-container {
        border-radius: 20px;
        overflow: hidden;
        margin-top: 1rem;
    }
</style>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">
			
			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
				<div class="container-fluid">

					<!-- Hero Section -->
					<div class="toss-card">
						<sec:authorize access="isAuthenticated()">
							<h1 class="toss-title">반가워요, <span class="toss-blue">${member.username}</span>님!</h1>
							<p class="toss-text">
								<spring:message code="welcome.login" arguments="${member.username},${member.birth}" argumentSeparator=","></spring:message>
							</p>
						</sec:authorize>
						<sec:authorize access="!isAuthenticated()">
							<h1 class="toss-title">안녕하세요!<br>코스모 포스트에 오신 것을 환영해요.</h1>
							<p class="toss-text mb-4">로그인하시면 더 많은 서비스를 이용할 수 있습니다.</p>
							<a href="/member/login" class="btn-toss">로그인하기</a>
						</sec:authorize>
					</div>

					<!-- Service Grid -->
					<div class="service-grid">
						<a href="/notice/list" class="service-item">
							<i class="fas fa-bullhorn"></i>
							<span>공지사항</span>
						</a>
						<a href="/product/list" class="service-item">
							<i class="fas fa-shopping-bag"></i>
							<span>상품목록</span>
						</a>
						<sec:authorize access="isAuthenticated()">
							<a href="/member/mypage" class="service-item">
								<i class="fas fa-user-circle"></i>
								<span>마이페이지</span>
							</a>
						</sec:authorize>
					</div>

					<!-- Map Section -->
					<div class="toss-card">
						<h2 class="toss-title" style="font-size: 1.25rem;">주변 탐색</h2>
						<p class="toss-text">현재 위치 근처의 정보를 확인해보세요.</p>
						<div id="map-container">
							<div id="map" style="width:100%; height:400px;"></div>
						</div>
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
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4ee70d96f0f5c9b198785aa211dac567"></script>
	<script type="text/javascript">
	const container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	let options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(37.4787, 126.8786), // 가산디지털단지 근처 예시 좌표
		level: 3 //지도의 레벨(확대, 축소 정도)
	};

	let map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
    
    // Resize handling for map
    window.addEventListener('resize', function() {
        map.relayout();
    });
	</script>
</body>
</html>