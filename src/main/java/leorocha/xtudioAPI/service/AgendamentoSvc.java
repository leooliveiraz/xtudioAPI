package leorocha.xtudioAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leorocha.xtudioAPI.model.Agendamento;
import leorocha.xtudioAPI.model.FormaPagamento;
import leorocha.xtudioAPI.model.Funcionario;
import leorocha.xtudioAPI.repository.AgendamentoRps;

@Service
public class AgendamentoSvc {
	@Autowired
	AgendamentoRps agendamentoRps;
	@Autowired
	FormaPagamentoSvc formaPagamentoSvc;
	@Autowired
	FuncionarioSvc funcionarioSvc;
	@Autowired
	ServicoSvc servicoSvc;
	
	public void salvar(Agendamento agendamento) throws Exception {
		FormaPagamento formaPagamento = formaPagamentoSvc.findById(agendamento.getFormaPagamento().getId());
		Funcionario funcionario = funcionarioSvc.findById(agendamento.getFuncionario().getId());
		agendamento.getServicos().forEach(s -> {
			try {
				s = servicoSvc.findById(s.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}});
		agendamento.setFormaPagamento(formaPagamento);
		agendamentoRps.save(agendamento);
	}
	public List<Agendamento>findAll() {
		return (List<Agendamento>) agendamentoRps.findAll();
	}

	public Agendamento findById(Integer id) throws Exception {
		Optional<Agendamento> optional = agendamentoRps.findById(id);
		return optional.orElseThrow(() -> new Exception("Agendamento não encontrado"));
	}
}
