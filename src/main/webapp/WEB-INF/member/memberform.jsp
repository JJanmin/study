<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btncheck").click(function(){
			var id=$("#id").val();
			$.ajax({
				type:"get",
				url: "idcheck",
				dataType:"json",
				data:{"id":id},
				success:function(data){
					if(data.count==1){
						alert("이미 가입된 아이디입니다. \n 다시 입력해주세요");
						$("#id").val("");
						$("#id").focus();
					}else{
						alert("가입 가능한 아이디입니다.");
					}
				}
			})
		})
	})

</script>
</head>
<body>
<form action="insert" method="post" class="form-inline" >
	<table class="table table-bordered" style="width: 500px;">
		<caption><b>회원가입</b></caption>
		<tr>
			<th bgcolor="tomato" width= "120">회원명</th>
			<td>
			<input type="text" class="form-control" name="name" placeholder="이름"
			required="required" style="width: 130px;">
			</td>	
		</tr>
		<tr>
			<th bgcolor="tomato" width= "120">아이디</th>
			<td>
			<input type="text" class="form-control" name="id" id="id" placeholder="아이디"
			required="required" style="width: 130px;">
			<button type="button" class="btn btn-danger" id="btncheck">중복체크</button>
			</td>	
		</tr>
		<tr>
			<th bgcolor="tomato" width= "120">휴대폰</th>
			<td>
			<input type="text" class="form-control" name="hp" placeholder="휴대폰"
			required="required" style="width: 200px;">
			</td>	
		</tr>
		<tr>
			<th bgcolor="tomato" width= "120">비밀번호</th>
			<td>
			<input type="password" class="form-control" name="pass" placeholder="비밀번호"
			required="required" style="width: 150px;">
			</td>	
		</tr>
		<tr>
		<td colspan="2" align="center">
		<button type="submit" class="btn btn-info" >회원가입</button>
		<button type="button" class="btn btn-info" onclick="location.href='list'">회원명단</button>
		</td>	
		</tr>
	</table>
</form>
</body>
</html>