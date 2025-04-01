<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<button class="btn btn-primary" type="submit" onclick="test1();">fadeOut</button>
	<button class="btn btn-primary" type="submit" onclick="test2();">fadeIn</button>
	<br><br>
	<img id="img1" src="/img/img1.jpg">
	
	<script type="text/javascript">
		function test1() {
			${"#img1"}.fadeOut(2000);
		}
		function test2() {
			${"#img1"}.fadeIn(2000);
		}
	</script>
</body>
</html>