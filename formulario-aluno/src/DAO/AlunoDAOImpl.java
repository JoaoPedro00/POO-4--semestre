package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Aluno;

public class AlunoDAOImpl implements AlunoDAO{
	
private Connection c;
	
	public AlunoDAOImpl() throws ClassNotFoundException, SQLException {
		IGenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	

	@Override
	public void adicionar(Aluno a) throws DAOException {
		try {
		String sql = "INSERT INTO aluno"
				+ "(ra, nome, idade, nascimento)"
				+ " VALUES (?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getRa());
		ps.setString(2, a.getNome());
		ps.setInt(3, a.getIdade());
		long t = a.getNascimento().getTime();
		java.sql.Date d = new java.sql.Date(t);
		ps.setDate(4, d);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		
		
	}

	@Override
	public void atualizaAluno(Aluno a) throws DAOException {
		try {
			String sql = "UPDATE aluno SET nome = ? , idade = ?, nascimento = ?"
					+ " WHERE ra = ?";
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setString(1, a.getNome());
					ps.setInt(2, a.getIdade());
					long t = a.getNascimento().getTime();
					java.sql.Date d = new java.sql.Date(t);
					ps.setDate(3, d);
					ps.setString(4, a.getRa());
					ps.execute();
					ps.close();
					}
			catch(SQLException e){
				e.printStackTrace();
				throw new DAOException(e);
			}
		
	}

	@Override
	public void excluiAluno(Aluno a) throws DAOException {
		try {
			String sql = "DELETE aluno WHERE ra = ?";
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setString(1, a.getRa());
					ps.execute();
					ps.close();
			} catch(SQLException e){
				e.printStackTrace();
				throw new DAOException(e);
			}
		
	}

	@Override
	public List<Aluno> pesquisarPorRA(String RA) throws DAOException {
		List<Aluno> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM aluno "
					+ "WHERE ra = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, RA );
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setRa(rs.getString("ra"));
				a.setNome(rs.getString("nome"));
				a.setIdade(rs.getInt("idade"));
				a.setNascimento(rs.getDate("nascimento"));
				
				lista.add(a);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
				e.printStackTrace();
				throw new DAOException(e);
			}
	  return lista;
		}

}
