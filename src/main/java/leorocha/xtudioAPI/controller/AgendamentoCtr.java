package leorocha.xtudioAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leorocha.xtudioAPI.dto.AgendamentoDTO;
import leorocha.xtudioAPI.model.Agendamento;
import leorocha.xtudioAPI.model.FormaPagamento;
import leorocha.xtudioAPI.model.Funcionario;
import leorocha.xtudioAPI.model.Servico;
import leorocha.xtudioAPI.service.AgendamentoSvc;

@RestController
@RequestMapping(path="agendamento")
public class AgendamentoCtr {
	@Autowired
	AgendamentoSvc agendamentoSvc;
	
	@PostMapping
	public void salvar(@RequestBody AgendamentoDTO dto) throws Exception {

		List<Servico> servicos = new ArrayList<>();
		if(dto.getServicos() != null && !dto.getServicos().isEmpty()) {
			dto.getServicos().forEach(s -> {servicos.add(Servico.builder().id(s).build());});
		}
		Agendamento entity = Agendamento.builder()
				.id(dto.getId())
				.cliente(dto.getCliente())
				.data(dto.getData())
				.horaInicial(dto.getHoraInicial())
				.horaFinal(dto.getHoraFinal())
				.valor(dto.getValor())
				.formaPagamento(FormaPagamento.builder().id(dto.getFormaPagamento()).build())
				.funcionario(Funcionario.builder().id(dto.getFuncionario()).build())
				.servicos(servicos)
				.pago(dto.getPago())
				.anamnese(dto.getAnamnese())
				.confirmado(dto.getConfirmado())
				.excluido(false)
				.build();
		agendamentoSvc.salvar(entity);
	}
	
	@PutMapping
	public void alterar(@RequestBody AgendamentoDTO dto) throws Exception {
		
		List<Servico> servicos = new ArrayList<>();
		if(dto.getServicos() != null && !dto.getServicos().isEmpty()) {
			dto.getServicos().forEach(s -> {servicos.add(Servico.builder().id(s).build());});
		}
		System.out.println(dto.toString());
		Agendamento entity = Agendamento.builder()
				.id(dto.getId())
				.cliente(dto.getCliente())
				.data(dto.getData())
				.horaInicial(dto.getHoraInicial())
				.horaFinal(dto.getHoraFinal())
				.valor(dto.getValor())
				.formaPagamento(FormaPagamento.builder().id(dto.getFormaPagamento()).build())
				.funcionario(Funcionario.builder().id(dto.getFuncionario()).build())
				.servicos(servicos)
				.pago(dto.getPago())
				.anamnese(dto.getAnamnese())
				.confirmado(dto.getConfirmado())
				.excluido(false)
				.build();
		agendamentoSvc.salvar(entity);
	}

	@GetMapping
	public List<Agendamento> buscar() {
		List<Agendamento> list = agendamentoSvc.findAll();
		return list;
	}

	@GetMapping(path="/{id}")
	public Agendamento buscar(@PathVariable Integer id) throws Exception {
		Agendamento entity = agendamentoSvc.findById(id);
		System.out.println(entity.toString());
		return entity;
	}
}
