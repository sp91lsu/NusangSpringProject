<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">

	<c:forEach var="friend" items="${user.friendList}">
		<c:if test="${friend.friendType == 'REALATIONSHIP' }">
			<form action="/chat/go_chatroom">
				<div>${friend.user.nickname }
					<button name="chat_userno" class="btn-chat btn btn-primary" value="${friend.user.userno }">${friend.user.userno }채팅하기</button>
				</div>
			</form>
		</c:if>
	</c:forEach>

</div>
<br />

<%@ include file="../layout/footer.jsp"%>
</body>

<script type="text/javascript" src="/js/user/allUserList.js">
	
</script>
</html>


