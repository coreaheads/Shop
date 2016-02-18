<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원 결제</h1>


<br><br><br>
<form>
우편번호 <input type = "text" name = "postCode1"> - <input type = text name = "postCode2"><br>
주소<textarea rows="1" cols="100" name="addr1"></textarea><br>
상세주소<textarea rows="1" cols="100" name="addr2"></textarea><br>
연락처<input type = "text" name = "celNum"> ('-' 없이 입력하세요. )<br>
총가격<input type = text name = "totalPrice"><br>
입금자<input type = text name = "depositor"><br>
결제방식
<input type="radio" name="payment_no">결제1
<input type="radio" name="payment_no">결제2
<input type="radio" name="payment_no">결제3

<input type = "submit" value = "결제하기">
</form>


 

</body>
</html>