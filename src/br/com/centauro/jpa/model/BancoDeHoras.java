package br.com.centauro.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="DASHBOARD_HORAS_BANCO")
@SequenceGenerator(name="banco", sequenceName="SQ_DASHBOARD_HORAS_BANCO", allocationSize=1)
public class BancoDeHoras {

	@Id
	@GeneratedValue(generator="banco", strategy=GenerationType.SEQUENCE)
	private int id;

	@NotBlank
	@Column(name="qtd_horas")
	private int horas;

	@ManyToOne
	private Funcionario funcionario;

	@ManyToOne
	private Competencia competencia;
	
	public BancoDeHoras() {super();}
	
	public BancoDeHoras(int horas, Funcionario funcionario, Competencia competencia) {
		super();
		this.horas = horas;
		this.funcionario = funcionario;
		this.competencia = competencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Competencia getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
}