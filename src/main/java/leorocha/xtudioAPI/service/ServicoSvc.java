package leorocha.xtudioAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leorocha.xtudioAPI.model.Servico;
import leorocha.xtudioAPI.repository.ServicoRps;

@Service
public class ServicoSvc {
	@Autowired
	ServicoRps servicoRps;
	
	public void salvar(Servico servico) {
		servicoRps.save(servico);
	}
	public Iterable<Servico> findAll() {
		return  servicoRps.findAll();
	}

	public Servico findById(Integer id) throws Exception {
		Optional<Servico> optional = servicoRps.findById(id);
		return optional.orElseThrow(() -> new Exception("Serviço não encontrado"));
	}
}
