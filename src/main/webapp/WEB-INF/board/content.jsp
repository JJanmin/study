<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 <table class="table" style="width: 650px;">
   <caption><b>내용보기</b></caption>
   <tr>
      <th style="text-align: left;">
         <span style="text-align: left;"><b style="text-align: left;">${dto.subject }</b></span>
         <span style="color: #ddd;font-size: 0.8em;float: right;"><b>
            <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
         </b></span>
      </th>
   </tr>
   <tr>
      <th>
         <span style="text-align: left;"><b>${dto.writer }(${dto.id })</b></span>
         <span style="color: #ddd;font-size: 0.8em;float: right;"><b>
            <span class="glyphicon glyphicon-eye-open"></span>${dto.readcount }
         </b></span>
      </th>
   </tr>
   <tr>
      <td>
         <div>
            <c:if test="${dto.uploadname!='no' }">
               <c:forTokens var="f" items="${dto.uploadname}" delims=",">
                  <div>
                  <a href="download?clip=${f}">
                     <span class="glyphicon glyphicon-download-alt"></span>
                     <span>${f}</span>
                  </a>
                  </div>
               </c:forTokens>
            </c:if>
         </div>
         <div style="width: 300px;">${dto.content }</div>
         <div>
            <c:forTokens items="${dto.uploadname }" delims="," var="photo">
               <c:if test="${photo=='no' }">
                  <b></b>
               </c:if>
               <c:if test="${photo!='no' }">
                     <img src="../image/${photo }" style="width: 200px;" class="image">
               </c:if>
            </c:forTokens>
         </div>
      </td>
   </tr>
      <tr>
         <td align="right">
            <c:if test="${sessionScope.loginok!=null}">
				<button type="button" class="btn btn-info" style="margin-left: 10px;"
				onclick="location.href='form?num=${dto.num}&reg=${dto.reg}&restep=${dto.restep}&relevel=${dto.relevel}&pageNum=${pageNum}'">
				답글쓰기</button>
			</c:if>
  <c:if test="${sessionScope.myid==dto.id}">
               <button type="button" class="btn btn-success"style="width: 80px;"
               onclick="location.href='updateform?num=${dto.num}&pageNum=${pageNum}'">수정</button>
               <button type="button" class="btn btn-success"style="width: 80px;"
               onclick="location.href='delete?num=${dto.num}&pageNum=${pageNum}'">삭제</button>
            </c:if>
            
            <button type="button" class="btn btn-success"style="width: 80px;"
            onclick="location.href='list?pageNum=${pageNum}'">목록</button>
         </td>
         </tr>   
   </table>
</body>
</html>