package com.mrmachine.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrmachine.app.domain.service.UsuarioService;
import com.mrmachine.app.persistence.entity.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usrService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAll() {
		return new ResponseEntity<List<Usuario>>(usrService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/usuario-email/{email}")
	public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable("email") String email) {
		return usrService.findByEmail(email)
				.map( u -> new ResponseEntity<>(u, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
}
