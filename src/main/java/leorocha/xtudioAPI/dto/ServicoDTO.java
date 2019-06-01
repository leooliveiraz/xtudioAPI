package leorocha.xtudioAPI.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicoDTO {
	private Integer id;
	private String nome;
	private boolean excluido;
}
