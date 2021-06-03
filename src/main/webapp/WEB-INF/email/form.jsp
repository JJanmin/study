<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<h2>이메일 보내기</h2>
<b>보낼 메일 주소 : </b>
<input type="text" id="mailaddr"	class="form-control" style="width: 200px;"><br>
<b>메일 내용 : </b>
<input type="text" id="mailcontent" class="form-control" style="width: 400px;"><br>
<button type="button" id="btnsend" class="btn btn-danger">이메일 보내기</button>
<hr>
<h2 id="showmail"></h2>
<script type="text/javascript">
  $("#btnsend").click(function(){
	  //받는 메일 주소
	 var addr=$("#mailaddr").val();
	  //보낼 메세지
	 var message=$("#mailcontent").val();
	 
	  $.ajax({
		 type:"post",
		 dataType:"json",
		 url:"../mail/message",
		 data:{"addr":addr,"message":message},
		 success:function(data){
			 $("#showmail").html(data.mes);
		 }
	  });
	  
  });
</script>
</body>
</html>

  