package br.com.centauro.jpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="DASHBOARD_HORAS_AREA")
@SequenceGenerator(name="area", sequenceName="SQ_DASHBOARD_HORAS_AREA", allocationSize=1)
public class Area {
	
	@Id
	@GeneratedValue(generator="area", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@NotBlank
	@Column(name="nm_area", nullable=false)
	private String nome;
	
	@NotBlank
	@Column(name="nm_gestor", nullable=false)
	private String gestor;
	
	@OneToMany(mappedBy="area")
	private List<Funcionario> funcionarios;
	
	public Area() { super(); }

	public Area(String nome, String gestor) {
		super();
		this.nome = nome;
		this.gestor = gestor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}