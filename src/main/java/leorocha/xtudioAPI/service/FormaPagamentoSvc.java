package leorocha.xtudioAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leorocha.xtudioAPI.model.FormaPagamento;
import leorocha.xtudioAPI.repository.FormaPagamentoRps;

@Service
public class FormaPagamentoSvc {
	@Autowired
	FormaPagamentoRps fPagRps;
	
	public void salvar(FormaPagamento formaPagamento) {
		fPagRps.save(formaPagamento);
	}
	public List<FormaPagamento>findAll() {
		return (List<FormaPagamento>) fPagRps.findAll();
	}

	public FormaPagamento findById(Integer id) throws Exception {
		Optional<FormaPagamento> optional = fPagRps.findById(id);
		return optional.orElseThrow(() -> new Exception("Forma de Pagamento não encontrada"));
	}
}
