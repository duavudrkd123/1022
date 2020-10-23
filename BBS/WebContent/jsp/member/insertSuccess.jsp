<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>${param.id }님가입을 축하드립니다..</h1>
		</div>
		<div>
				<table border="1">
					<tr>
						<th width="150">아 이 디</th>
						<td>${param.id }</td>
					</tr>
					<tr>
						<th width="150">이 름</th>
						<td>${param.name }</td>
					</tr>
					<tr>
						<th width="150">주 소</th>
						<td>${param.address }</td>
					</tr>
					<tr>
						<th width="150">전화번호</th>
						<td>${param.tel }</td>
					</tr>
					<tr>
						<th width="150">가입일자</th>
						<td>${param.enterdate }</td>
					</tr>

				</table>
		</div>
	</div>
</body>
</html>