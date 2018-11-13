package br.com.centauro.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="DASHBOARD_HORAS_FUNC")
@SequenceGenerator(name="funcionario", sequenceName= "SQ_DASHBOARD_HORAS_FUNC", allocationSize=1)
public class Funcionario {
	
	@Id
	@GeneratedValue(generator="funcionario", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@NotBlank
	private String matricula;
	
	@NotBlank
	private String nome;

	private int qtdHorasAtual;
	
	public Funcionario() { super();}

	public Funcionario(String matricula, String nome, int qtdHorasAtual) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.qtdHorasAtual = qtdHorasAtual;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdHorasAtual() {
		return qtdHorasAtual;
	}

	public void setQtdHorasAtual(int qtdHorasAtual) {
		this.qtdHorasAtual = qtdHorasAtual;
	}
}