<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-Commerce - Login</title>
</head>
<body>
<center>
LOGIN
<form action="LoginServlet" method="post">
<table>
<tr><td>Email:</td><td><input type="text" name="emailtxt"></td></tr>
<tr><td>Senha:</td><td><input type="password" name="pwtxt"></td></tr>
</table>
<input type="submit" value="Logar"><br><br>
</form>
<a href="registration.jsp">Ainda n�o tem uma conta? Clique aqui para se registrar!</a>
</center>

</body>
</html>

