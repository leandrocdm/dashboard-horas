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

@Entity
@Table(name="DASHBOARD_HORAS_COMP")
@SequenceGenerator(name="competencia", sequenceName="SQ_DASHBOARD_HORAS_COMP", allocationSize=1)
public class Competencia {
	
	@Id
	@GeneratedValue(generator="competencia", strategy=GenerationType.SEQUENCE)
	private int id;
	

	@Column(name="ds_mes", nullable=false)
	private String mes;
	
	@Column(name="ds_ano", nullable=false)
	private int ano;
	
	@Column(name="qtd_horas_uteis", nullable=false)
	private int horasUteis;
	
	@OneToMany(mappedBy="competencia")
	private List<BancoDeHoras> bancosdehoras;
		
	public Competencia() { super(); }

	public Competencia(String mes, int ano, int horasUteis) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.horasUteis = horasUteis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getHorasUteis() {
		return horasUteis;
	}

	public void setHorasUteis(int horasUteis) {
		this.horasUteis = horasUteis;
	} 
	
	public List<BancoDeHoras> getBancosdehoras() {
		return bancosdehoras;
	}

	public void setBancosdehoras(List<BancoDeHoras> bancosdehoras) {
		this.bancosdehoras = bancosdehoras;
	}
}