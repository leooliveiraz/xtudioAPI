package leorocha.xtudioAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import leorocha.xtudioAPI.model.Funcionario;

@Repository
public interface FuncionarioRps  extends CrudRepository<Funcionario, Integer>{

}
