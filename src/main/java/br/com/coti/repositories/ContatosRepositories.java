package br.com.coti.repositories;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.coti.entities.Contato;
import br.com.coti.factories.ConnectionFactory;

public class ContatosRepositories {

	public void cadastrarContato(Contato contato) throws Exception {

		var connection = ConnectionFactory.getConnection();
		var statement = connection.prepareStatement("INSERT INTO CONTATO(NOME,TELEFONE,EMAIL) VALUES(?,?,?)");

		try {
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getTelefone());
			statement.setString(3, contato.getEmail());

			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new Exception("Erro ao cadastrar o contato: " + e.getMessage());
		} finally {
			connection.close();
		}
	}

	public void atualizarContato(Contato contato) throws SQLException {
		
		var connection = ConnectionFactory.getConnection();
		
		try {
			var statement = connection.prepareStatement("UPDATE CONTATO SET NOME = ?, TELEFONE = ?, EMAIL = ? WHERE ID = ?");

			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getTelefone());
			statement.setString(3, contato.getEmail());
			statement.setInt(4, contato.getId());

			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new SQLException("Erro ao atualizar o contato: " + e.getMessage());
		} finally {
			connection.close();
		}

	}

	public void excluirContato(int idContato) throws Exception {
		
		var connection = ConnectionFactory.getConnection();
		
		try {
			var statement = connection.prepareStatement("DELETE FROM CONTATO WHERE ID = ?");
			statement.setInt(1, idContato);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

	public ArrayList<Contato> listarContatos() throws Exception {
		
		var connection = ConnectionFactory.getConnection();
		var contatos = new ArrayList<Contato>();
		
		try {
			var statement = connection.prepareStatement("SELECT * FROM CONTATO");
			var result = statement.executeQuery();

			while (result.next()) {
				var contato = new Contato();
				contato.setId(result.getInt("ID"));
				contato.setNome(result.getString("NOME"));
				contato.setTelefone(result.getString("TELEFONE"));
				contato.setEmail(result.getString("EMAIL"));

				contatos.add(contato);
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connection.close();
		}
		return contatos;
	}
		
		

	public Contato consultarContatoPorId(int idContato) throws Exception {
		var connection = ConnectionFactory.getConnection();
		var contato = new Contato();
		
		try {
			var statement = connection.prepareStatement("SELECT * FROM CONTATO WHERE ID = ?");
			statement.setInt(1, idContato);
			var result = statement.executeQuery();

			if (result.next()) {
				
				contato.setId(result.getInt("ID"));
				contato.setNome(result.getString("NOME"));
				contato.setTelefone(result.getString("TELEFONE"));
				contato.setEmail(result.getString("EMAIL"));

				return contato;
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connection.close();
		}
		
		return contato;		
	}

}
