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

import leorocha.xtudioAPI.dto.FuncionarioDTO;
import leorocha.xtudioAPI.model.Funcionario;
import leorocha.xtudioAPI.service.FuncionarioSvc;

@RestController
@RequestMapping(path="funcionario")
public class FuncionarioCtr {
	@Autowired
	FuncionarioSvc funcionarioSvc;
	
	@PostMapping
	public void salvar(@RequestBody FuncionarioDTO dto) {
		Funcionario funcionario = Funcionario.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.excluido(false)
				.build();
		funcionarioSvc.salvar(funcionario);
	}
	
	@PutMapping
	public void alterar(@RequestBody FuncionarioDTO dto) {
		Funcionario funcionario = Funcionario.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.excluido(false)
				.build();
		funcionarioSvc.salvar(funcionario);
	}

	@GetMapping
	public List<Funcionario> buscar() {
		List<Funcionario> list = funcionarioSvc.findAll();
		return list;
	}

	@GetMapping(path="/{id}")
	public Funcionario buscar(@PathVariable Integer id) throws Exception {
		Funcionario entity = funcionarioSvc.findById(id);
		return entity;
	}
}
