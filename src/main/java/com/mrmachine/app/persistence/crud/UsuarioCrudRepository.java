package com.mrmachine.app.persistence.crud;

import com.mrmachine.app.persistence.entity.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	public Optional<Usuario> findById(@Param("email") String email);
}
