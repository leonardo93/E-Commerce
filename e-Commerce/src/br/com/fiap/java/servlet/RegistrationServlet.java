package br.com.fiap.java.servlet;

import java.io.IOException;
//import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.java.beans.Contato;
import br.com.fiap.java.dao.LoginDAO;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			requestHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			requestHandler(request, response);
	}
	
	protected void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");

		String nome = request.getParameter("txtNome");
		String sobrenome = request.getParameter("txtSobrenome");
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtSenha");
		String repassword = request.getParameter("txtConfirmSenha");
		String pais = request.getParameter("txtPais");
		String cidade = request.getParameter("txtCidade");
		String cancel = request.getParameter("cancel");

		String vazio = "";
		String pagina = "login.jsp";
		String erro = "";

		LoginDAO login = new LoginDAO();

			if (cancel != null) {
				pagina = "login.jsp";
			} else {

				if (login.verificaRegistro(email)) {
					erro += "O usuário já existe. <br/>";
					pagina = "error.jsp";
				}

				if (email == null || password == null || email.equals(vazio)
						|| password.equals(vazio)) {
					erro += "A senha ou o usuário não foram preenchidos. <br/>";
					pagina = "error.jsp";
				}
				if (!password.equals(repassword)) {
					erro += "Confirmação da senha é diferente da senha escolhida. <br/>";
					pagina = "error.jsp";
				}

			}

			Contato contato = new Contato();

			contato.setName(nome);
			contato.setLastName(sobrenome);
			contato.setEmail(email);
			contato.setPassword(password);
			contato.setCountry(pais);
			contato.setCity(cidade);

			login.createLogin(contato);


		request.setAttribute("error", erro);

		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);

		// <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	}

}
