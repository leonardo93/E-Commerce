<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Commerce - Registration</title>
</head>
<body><center>
REGISTRE-SE
<br><br>
<form action="RegistrationServlet" method="post">
<table>
<tr><td>Nome:</td><td><input type="text" name="txtNome"></td></tr>
<tr><td>Sobrenome:</td><td><input type="text" name="txtSobrenome"></td></tr>
<tr><td>Email:</td><td><input type="text" name="txtEmail"></td></tr>
<tr><td>Senha:</td><td><input type="password" name="txtSenha"></td></tr>
<tr><td>Confirme a senha:</td><td><input type="password" name="txtConfirmSenha"></td></tr>
<tr><td>País:</td><td><input type="text" name="txtPais"></td></tr>
<tr><td>Cidade:</td><td><input type="text" name="txtCidade"></td></tr>
</table>
<input type="submit" value="Registrar"><input type="submit" value="Voltar" name="cancel">
</form></center>
</body>
</html>