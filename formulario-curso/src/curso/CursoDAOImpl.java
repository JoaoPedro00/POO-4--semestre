package curso;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO{

	@Override
	public void adicionar(Curso c) {
		try {
			Connection con = DBUtils.getInstance().getConnection();
			String sql = "insert into curso values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getDescricao());
			ps.setBoolean(4, c.isAtivo());
			ps.setDate(5, new Date(c.getHorario_inicio().getTime())); 
			ps.setDate(6, new Date(c.getHorario_fim().getTime()));
			ps.execute();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Curso pesquisarPorNome(String nome) {
		Curso c = new Curso();
		try {
			Connection con = DBUtils.getInstance().getConnection();
			String sql = "select * from curso where nome = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setDescricao(rs.getString("descricao"));
				c.setAtivo(rs.getBoolean("ativo"));
				c.setHorario_inicio(rs.getDate("horario_inicio"));
				c.setHorario_fim(rs.getDate("horario_fim"));
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Curso> listar() {
		List<Curso> listaCurso = new ArrayList<Curso>();
		try {
			Connection con = DBUtils.getInstance().getConnection();
			String sql = "select * from curso";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Curso c = new Curso();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setDescricao(rs.getString("descricao"));
				c.setAtivo(rs.getBoolean("ativo"));
				c.setHorario_inicio(rs.getDate("horario_inicio"));
				c.setHorario_fim(rs.getDate("horario_fim"));
				listaCurso.add(c);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaCurso;
	}
	
}
