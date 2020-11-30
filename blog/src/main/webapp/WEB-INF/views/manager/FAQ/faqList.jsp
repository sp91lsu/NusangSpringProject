<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/css/manager/FAQ/faqList.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
<div align = "center" class = "d-flex">
	<div class="container1 p-6 ">
	<c:choose>
		<c:when test="${user.role == 'ADMIN' }">
		
		<br> <br>
		<h3>문의 리스트</h3>
		<%-- <c:choose>
			<c:when test="${user.role == 'ADMIN' }"> --%>
				<div class="btnhidden">줄맞춤용</div>
		<%-- 	</c:when>
		</c:choose> --%>
		<br>
		<table class="table">
			<thead class="thead-dark" align="center">
				<tr>
					<th class="noTh" scope="col">no</th>
					<th class="conTh" scope="col">내용</th>
					<th class="conTh" scope="col">날짜</th>
				</tr>
			</thead>
			<tbody class="qna_list">
				<c:forEach var="dto" items="${qnaList}">
					<tr>
						<td align = "center">
						${dto.no }
						</td>
						<td><a class="titleColor"
							href="/manager/notice/noticeView?no=${dto.no }">${dto.title }</a>
						</td>
						<td>
						${dto.regdate }
						</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
		<%-- <ul class="pagination justify-content-center">
			<c:forEach var="i" begin="1" end="${list.getTotalPages() }">
				<a class="ml-2 mr-2 paging_input">${i}</a>
			</c:forEach>
		</ul> --%>
		</c:when>
	
		<c:otherwise>
			<br> <br>
		<h3>문의하기</h3>
		
		<br>
		<form action="/manager/QNA/qnaWriteOk"></form>
			문의제목&nbsp;&nbsp;&nbsp;<input name= "title" class = "qnaTitle" type="text" />
			<textarea class = "textarea" name="contents" cols="54" rows="10" placeholder="문의내용"></textarea>
			<button type = "submit" class = "btn btn-secondary" style = "float:right;">문의하기</button>
	
		</c:otherwise>
	</c:choose>
	
	</div>
	<div class="container2 p-6">
		<br> <br>
		<h3>FAQ</h3>
		<%-- <c:choose>
			<c:when test="${user.role == 'ADMIN' }"> --%>
				<div class="writeBtn">
					<button class="btn btn-warning"
						onclick="location.href='/manager/FAQ/faqWrite'">글쓰기</button>
				</div>
		<%-- 	</c:when>
		</c:choose> --%>
		<br>
		<form action="/manager/FAQ/faqDeleteOk" method = "post">
		<sec:csrfInput />
		<table class="table">
			<thead class="thead-dark" align="center">
				<tr>
					<th class="noTh" scope="col">no</th>
					<th class="conTh" scope="col">내용</th>
				</tr>
			</thead>
			<tbody class="faq_list">
				<c:forEach var="dto" items="${faqList.toList()}">
					<tr>
						<td align = "center">
						${dto.no }
						</td>
						<td>
						<div class="titleColor">${dto.title }</div>
						<div class = "contents"><br>${dto.contents }<br>
							<button type = "button" class = "btn btn-primary btn-sm" onclick="location.href = '/manager/FAQ/faqUpdate?no=${dto.no}'">수정</button>
							<input type="hidden" name="no" value="${dto.no }" />
							<button type = "submit" class = "btn btn-secondary btn-sm">삭제</button>
						</div>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</form>
		<ul class="pagination justify-content-center">
			<c:forEach var="i" begin="1" end="${faqList.getTotalPages() }">
				<a class="ml-2 mr-2 paging_input">${i}</a>
			</c:forEach>
		</ul>
	</div>
</div>
<script>
    // html dom 이 다 로딩된 후 실행된다.
    $(document).ready(function(){
        // menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
        $(".titleColor").click(function(){
            var submenu = $(this).next("div");
 
            // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
            if( submenu.is(":visible") ){
                submenu.slideUp();
            }else{
                submenu.slideDown();
            }
        });
    });
</script>

<script src="/js/paging/faqPage.js"></script>
	<%@ include file="../manager_footer.jsp"%>
</body>
<script src="/js/paging/noticePage.js"></script>
</html>