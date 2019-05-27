package leorocha.xtudioAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import leorocha.xtudioAPI.model.FormaPagamento;

@Repository
public interface FormaPagamentoRps  extends CrudRepository<FormaPagamento, Integer>{

}
