package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Animal;

public class AnimalDAOImpl implements AnimalDAO{
	
	private Connection c;
	
	public AnimalDAOImpl() throws ClassNotFoundException, SQLException {
		IGenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void adicionar(Animal a) throws DAOException {
		String sql = "INSERT INTO animal"
				+ "(id, nome, nascimento, peso)"
				+ " VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setLong(1, a.getId());
			ps.setString(2, a.getNome());
			long t = a.getNascimento().getTime();
			java.sql.Date d = new java.sql.Date(t);
			ps.setDate(3, d);
			ps.setFloat(4, a.getPeso());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		
	}

	@Override
	public List<Animal> pesquisarPorNome(String nome) throws DAOException {
		List<Animal> lista = new ArrayList<Animal>();
		try {
			String sql = "SELECT * FROM animal " + 
					"WHERE nome LIKE ?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%" +nome+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Animal a = new Animal();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				a.setNascimento(rs.getDate("nascimento"));
				a.setPeso(rs.getFloat("peso"));
				
				lista.add(a);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DAOException(e1);	
		}
		return lista;

	}
}
