package com.mrmachine.app.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrmachine.app.persistence.crud.UsuarioCrudRepository;
import com.mrmachine.app.persistence.entity.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioCrudRepository usrCrud;

	public List<Usuario> getAll() {
		return (List<Usuario>) usrCrud.findAll();
	}
	
	public Optional<Usuario> findByEmail(String email) {
		return usrCrud.findById(email);
	}
	
	
}
