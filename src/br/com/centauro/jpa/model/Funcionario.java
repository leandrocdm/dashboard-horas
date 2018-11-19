package br.com.centauro.jpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="DASHBOARD_HORAS_FUNC")
@SequenceGenerator(name="funcionario", sequenceName= "SQ_DASHBOARD_HORAS_FUNC", allocationSize=1)
public class Funcionario {
	
	@Id
	@GeneratedValue(generator="funcionario", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@NotBlank
	@Column(name="ds_matricula", nullable=false)
	private String matricula;
	
	@NotBlank
	@Column(name="nm_funcionario", nullable=false)
	private String nome;

	@NotNull
	@Column(name="qtd_horas_atual")
	private int qtdHorasAtual;
	
	@ManyToOne
	private Area area;
	
	@OneToMany(mappedBy="funcionario")
	private List<BancoDeHoras> bancosdehoras;
	
	public Funcionario() { super();}

	public Funcionario(String matricula, String nome, int qtdHorasAtual, Area area) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.qtdHorasAtual = qtdHorasAtual;
		this.area = area;
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
	
	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}

	public List<BancoDeHoras> getBancosdehoras() {
		return bancosdehoras;
	}

	public void setBancosdehoras(List<BancoDeHoras> bancosdehoras) {
		this.bancosdehoras = bancosdehoras;
	}
}