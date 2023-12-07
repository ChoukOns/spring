<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Ajouter un Employe</title>
</head>
<body>
<form action="saveEmploye" method="post">
<pre>
nom : <input type="text" name="nomEmploye">
salaire : <input type="text" name="salaire">
<input type="submit" value="ajouter">
</pre>
</form>
${msg}
<br/>
<br/>
<a href="ListeEmployees">Liste Employees</a>
</body>
</html>