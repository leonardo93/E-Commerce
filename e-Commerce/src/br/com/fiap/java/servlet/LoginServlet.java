package br.com.fiap.java.servlet;

import java.io.IOException;
//import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.java.beans.Contato;
import br.com.fiap.java.dao.LoginDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}
	
	protected void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		String email = request.getParameter("emailtxt");
		String pw = request.getParameter("pwtxt");

		LoginDAO login = new LoginDAO();
		String pagina = "";
		String erro = "";
		HttpSession session = request.getSession(true);
		Contato contato = new Contato();

			if (login.verificaLogin(email,pw)){
				pagina = "home.jsp";
				contato = login.pegaLogin(email);
				session.setAttribute("cont", contato);
				System.out.println(contato.getEmail());
			}
			else{
				pagina = "error.jsp";
				erro = "Email ou senha incorreta.";
				request.setAttribute("error", erro);
			}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
