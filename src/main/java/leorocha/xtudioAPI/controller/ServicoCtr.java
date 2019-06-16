package leorocha.xtudioAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leorocha.xtudioAPI.dto.ServicoDTO;
import leorocha.xtudioAPI.model.Servico;
import leorocha.xtudioAPI.service.ServicoSvc;

@RestController
@RequestMapping(path="/servico")
public class ServicoCtr {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ServicoSvc servicoSvc;
	
	@PostMapping
	public void salvar(@RequestBody ServicoDTO dto) {
		Servico servico = Servico.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.excluido(false)
				.build();
		servicoSvc.salvar(servico);
		logger.info("Salvando Servico "+dto.toString());
	}
	
	@PutMapping
	public void alterar(@RequestBody ServicoDTO dto) {
		Servico servico = Servico.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.excluido(false)
				.build();
		servicoSvc.salvar(servico);
		logger.info("Alterando Servico "+dto.toString());
	}

	@GetMapping
	public List<ServicoDTO> buscar() {
		Iterable<Servico> list = servicoSvc.findAll();
		List<ServicoDTO> listDTO  = new ArrayList<>();
		list.forEach(i -> 
			listDTO.add(ServicoDTO.builder()
					.id(i.getId())
					.nome(i.getNome())
					.excluido(i.isExcluido()).build()));
		logger.info("Buscando Servico "+listDTO.toString());
		return listDTO;
	}

	@GetMapping(path="/{id}")
	public Servico buscar(@PathVariable Integer id) throws Exception {
		Servico entity = servicoSvc.findById(id);
		logger.info("BuscarServico "+entity.toString());
		return entity;
	}
}
