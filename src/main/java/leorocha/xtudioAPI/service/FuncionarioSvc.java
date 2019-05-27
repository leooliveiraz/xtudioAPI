package leorocha.xtudioAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leorocha.xtudioAPI.model.Funcionario;
import leorocha.xtudioAPI.repository.FuncionarioRps;

@Service
public class FuncionarioSvc {
	@Autowired
	FuncionarioRps funcionarioRps;
	
	public void salvar(Funcionario funcionario) {
		funcionarioRps.save(funcionario);
	}
	public List<Funcionario>findAll() {
		return (List<Funcionario>) funcionarioRps.findAll();
	}

	public Funcionario findById(Integer id) throws Exception {
		Optional<Funcionario> optional = funcionarioRps.findById(id);
		return optional.orElseThrow(() -> new Exception("Funcionário não encontrado"));
	}
}
