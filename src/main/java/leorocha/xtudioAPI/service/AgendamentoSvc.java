package leorocha.xtudioAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leorocha.xtudioAPI.model.Agendamento;
import leorocha.xtudioAPI.repository.AgendamentoRps;

@Service
public class AgendamentoSvc {
	@Autowired
	AgendamentoRps agendamentoRps;
	
	public void salvar(Agendamento funcionario) {
		agendamentoRps.save(funcionario);
	}
	public List<Agendamento>findAll() {
		return (List<Agendamento>) agendamentoRps.findAll();
	}

	public Agendamento findById(Integer id) throws Exception {
		Optional<Agendamento> optional = agendamentoRps.findById(id);
		return optional.orElseThrow(() -> new Exception("Agendamento não encontrado"));
	}
}
