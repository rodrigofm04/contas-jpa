package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movimentacao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;
	@Temporal(TemporalType.DATE)
	private Calendar data;
	private String descricao;

	@ManyToOne
	private Conta conta;

	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipo) {
		this.tipoMovimentacao = tipo;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDataFormatada(Calendar data){
		return new SimpleDateFormat("dd-MM-yyy").format(data.getTime());
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {

		return "Movimentacao ["
				+ "id=" + this.conta.getId()
				+ ", titular=" + this.conta.getTitular()
				+ ", banco=" + this.conta.getBanco()
				+ ", agencia=" + this.conta.getAgencia()
				+ ", numero="+ this.conta.getNumero()
				+ ", valor=" + this.valor
				+ ", movimentacao="+this.tipoMovimentacao
				+ ", data="+getDataFormatada(this.data)
				+ ", descricao="+this.descricao
				+"]";
	}
}
