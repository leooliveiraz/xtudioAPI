package leorocha.xtudioAPI.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
@Entity
public class Agendamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String cliente;
	private LocalDate data;
	private LocalTime horaInicial;
	private LocalTime horaFinal;
	@Column(scale=3)
	private BigDecimal valor;
	@ManyToOne
	@JoinColumn(name = "forma_pagamento")
	private FormaPagamento formaPagamento;
	private Boolean pago;
	private Boolean anamnese;
	private Boolean confirmado;
	private Boolean excluido;
	private String observacao;

}
