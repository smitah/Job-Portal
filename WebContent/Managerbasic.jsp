<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>
<p> Welcome, ${managername}</p>
<p> To post new jobs .</p>
<form id="main" method="post" name="main" action="" onsubmit="change(this);">
<button type="submit"> Click Here </button>
</form>
<p> To check the status of the previously posted jobs.<p>
<form action = "previousjobs" method = "post">
<input type="text" hidden name="candidate" value="name">
<button type="submit"> Click Here </button>
</form>

<script>
function change(elem){
	
	elem.setAttribute("action","managerPage.jsp");
    elem.submit();	
}
     
</script>
</body>
</html>

>