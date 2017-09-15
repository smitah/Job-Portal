<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>
<p> Candidate_id ${candidate_id }</p>
<p> To apply to the new jobs.</p>
<form action = "candidate_jobinfo" method = "get">
<button type="submit"> Click Here </button>
</form>
<p> To check the jobs you have applied to.<p>
<form action = "candidate_joblist" method = "post">
<input type="text" hidden name="candidate" value="name">
<button type="submit"> Click Here </button>
</form>


</body>
</html>

>