package leorocha.xtudioAPI.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Data;
@Data
public class AgendamentoDTO {
	private Integer id;
	private String cliente;
	private LocalDate data;
	private LocalTime horaInicial;
	private LocalTime horaFinal;
	private BigDecimal valor;
	private Integer formaPagamento;
	private Integer funcionario;
	private List<Integer> servicos;
	private Boolean pago;
	private Boolean anamnese;
	private Boolean confirmado;
	private Boolean excluido;
	private String observacao;

}
