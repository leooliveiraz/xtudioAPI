package leorocha.xtudioAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import leorocha.xtudioAPI.model.Servico;

@Repository
public interface ServicoRps  extends CrudRepository<Servico, Integer>{
	
}
