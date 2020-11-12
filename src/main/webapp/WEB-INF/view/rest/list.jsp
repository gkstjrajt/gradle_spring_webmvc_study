<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 보기</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.get("memberList", function(json){
			var dataLength = json.length;
			if(dataLength >= 1){
				var sCont ="";
				for(i=0; i < dataLength; i++){
					sCont += "<tr>";
					sCont += "<td>" + json[i].id + "</td>";
					sCont += "<td>" + json[i].name + "</td>";
					sCont += "<td>" + json[i].email + "</td>";
					sCont += "<td>" + json[i].registerDateTime + "</td>";
					sCont += "</tr>";
				}
				$("#load").append(sCont);
			}
		});
	});
</script>
</head>
<body>
	<h2>목록</h2>
	<table border="1">
		<thead>
			<td>아이디</td><td>이름</td><td>이메일</td><td>생성일</td>
		</thead>
		<tbody id="load">
		</tbody>
	</table>
</body>
</html>