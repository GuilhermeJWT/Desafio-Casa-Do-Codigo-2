package br.com.systemsgs.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.casadocodigo.model.ModelAutor;

@Repository
public interface AutorRepisitory extends JpaRepository<ModelAutor, Long>{

}
