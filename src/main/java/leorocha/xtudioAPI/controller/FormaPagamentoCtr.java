package leorocha.xtudioAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leorocha.xtudioAPI.dto.FormaPagamentoDTO;
import leorocha.xtudioAPI.model.FormaPagamento;
import leorocha.xtudioAPI.service.FormaPagamentoSvc;

@RestController
@RequestMapping(path="formapagamento")
public class FormaPagamentoCtr {
	@Autowired
	FormaPagamentoSvc formaPagamentoSvc;
	
	@PostMapping
	public void salvar(@RequestBody FormaPagamentoDTO dto) {
		FormaPagamento formaPagamento = FormaPagamento.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.excluido(dto.getExcluido())
				.build();
		formaPagamentoSvc.salvar(formaPagamento);
	}
	
	@PutMapping
	public void alterar(@RequestBody FormaPagamentoDTO dto) {
		FormaPagamento servico = FormaPagamento.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.excluido(false)
				.build();
		formaPagamentoSvc.salvar(servico);
	}

	@GetMapping
	public List<FormaPagamento> buscar() {
		List<FormaPagamento> list = formaPagamentoSvc.findAll();
		return list;
	}

	@GetMapping(path="/{id}")
	public FormaPagamento buscar(@PathVariable Integer id) throws Exception {
		FormaPagamento entity = formaPagamentoSvc.findById(id);
		return entity;
	}
}
