package br.com.fiap.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.java.beans.Contato;
import br.com.fiap.java.factory.ConnectionFactory;

public class LoginDAO {

	Connection conn = null;

	public LoginDAO() {

		try {
			conn = ConnectionFactory.getConnection();
		} catch (SQLException e) {
		}
	}

	public boolean verificaLogin(String email, String pw) {

		String sql = "SELECT * FROM LOGIN WHERE EMAIL='" + email + "' AND PW='"
				+ pw + "'";

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs.next())
				return true;

		} catch (SQLException ex) {

		}

		return false;

	}

	public void createLogin(Contato c) {

		String sql = "INSERT INTO ECOMMERCE.LOGIN(NAME,LAST_NAME,EMAIL,PW,COUNTRY,CITY) VALUES (?,?,?,?,?,?)";

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, c.getName());
			stmt.setString(2, c.getLastName());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getPassword());
			stmt.setString(5, c.getCountry());
			stmt.setString(6, c.getCity());

			stmt.executeUpdate();

		} catch (SQLException ex) {
		}

	}

	public boolean verificaRegistro(String email) {

		String sql = "SELECT * FROM LOGIN WHERE EMAIL='" + email + "'";

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs.next())
				return true;

		} catch (SQLException ex) {

		}

		return false;

	}

	public Contato pegaLogin(String email) {

		String sql = "SELECT * FROM LOGIN WHERE EMAIL='" + email + "'";

		Contato contato = new Contato();

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			contato.setName(rs.getString("NAME"));
			contato.setLastName(rs.getString("LAST_NAME"));
			contato.setId(rs.getInt("ID"));
			contato.setEmail(rs.getString("EMAIL"));
			contato.setPassword(rs.getString("PW"));
			contato.setCity(rs.getString("CITY"));
			contato.setCountry(rs.getString("COUNTRY"));

			System.out.println(contato.getEmail());

		} catch (SQLException ex) {

		}

		return contato;

	}

	public void fecharConexao() {

		try {
			conn.close();
		} catch (SQLException ex) {

		}
	}
}
