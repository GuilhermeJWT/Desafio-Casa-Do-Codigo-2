package br.com.systemsgs.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.casadocodigo.model.ModelLivro;

@Repository
public interface LivroRepository extends JpaRepository<ModelLivro, Long>{

}
