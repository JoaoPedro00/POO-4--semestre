package curso;

import java.util.Date;

public class Curso {
	
	private long id;
	private String nome;
	private String descricao;
	private boolean ativo;
	private Date horario_inicio;
	private Date horario_fim;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Date getHorario_inicio() {
		return horario_inicio;
	}

	public void setHorario_inicio(Date horario_inicio) {
		this.horario_inicio = horario_inicio;
	}
	public Date getHorario_fim() {
		return horario_fim;
	}

	public void setHorario_fim(Date horario_fim) {
		this.horario_fim = horario_fim;
	}
	
}
	
	