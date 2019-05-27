package leorocha.xtudioAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import leorocha.xtudioAPI.model.Agendamento;

@Repository
public interface AgendamentoRps  extends CrudRepository<Agendamento, Integer>{

}
