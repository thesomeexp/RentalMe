<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
名字:${targetUser.username}</br>
 简介:${targetUser.userDetail.brief}<br>
其他人的评价: <br>
<table>
<tr>
<td>用户</td>
<td>评价</td>
<td>满意度</td>
<td>评价时间</td>
</tr>
<c:forEach items="${targetReviewList}" var="review">
<tr>
<td>${review.fromUser.username}</td>
<td>${review.content}</td>
<c:if test="${review.review == 0}"><td>差评</td></c:if>
<c:if test="${review.review == 1}"><td>好评</td></c:if>
<td>${review.submitdate}</td>
</tr>
</c:forEach>
</table><br>
用户最新发布的商品<br>
<table>
<c:forEach items="${item}" var="item" varStatus="s">

      <c:if test="${s.index%6 ==0}">
      <tr>
      </c:if> 
<td>
<img id='imgSize1Imp' src="${picPath}${item.firstImage.pic}"  height="100" width="100" /><br>
标题：${item.title}<br>租用价格：${item.basepayment}<br>
<a href="${picPath}/itemDetailPage/${item.id}">查看详情</a>
</td>
      <c:if test="${s.index%6 ==5}">
      </tr>
      </c:if>
      
</c:forEach>
</table>
</div>
</body>
</html>