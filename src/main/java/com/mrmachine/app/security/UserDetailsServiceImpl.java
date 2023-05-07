package com.mrmachine.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mrmachine.app.domain.service.UsuarioService;
import com.mrmachine.app.persistence.entity.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UsuarioService usrService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usr = usrService
				.findByEmail(email)
				.orElseThrow( () -> new UsernameNotFoundException("User Not Found with email: " + email));
		
		return new UserDetailsImpl(usr);
	}
	
}
