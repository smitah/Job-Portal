<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Recruiter Page</title>
</head>
<body>
<h3> Please fill the below info for the job</h3>
<form action = "mainJob" method = "get">
  
  
  <textarea rows="1" cols="20" name = "name" hidden> ${name} </textarea></pre>
  <fieldset>
  <pre> <b>1. Job Title:</b>   <input type="text" name="JobTitle" required></pre>
  <pre> <b>2. Preferred Job Skills:</b>
<textarea rows="4" cols="50" name = "skills" required></textarea></pre>
 <pre> <b>3. Job Category:</b>   <select name = "category" >
  <option   value="Management">Management</option>
  <option  value="Finance">Finance</option>
  <option  value="InformationTechnology">Information Technology</option>
  <option   value="Engineering">Engineering</option>
</select></pre>
  <pre> <b>4. Number of Positions:</b>  <input type = "number" min = "1" max = "10" name="positions" required> </pre>
  <pre> <b>5. Job Type :</b> <input type="radio" name="preference" value="Part-Time" checked> Part-Time    <input type="radio" name="preference" value="Full-Time"> Full-Time</pre>
  <pre> <b>6. Candidate Preference:</b> <input type="radio" name="experience" value="Experienced" checked> Experienced    <input type="radio" name="experience" value="Fresher"> Fresher </pre> 
<button type="submit" >Post Job</button>
 
</form>
</fieldset>

</body>
</html>

