package com.practica.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practica.exceptions.ResourceNotFoundException;
import com.practica.model.Usuario;
import com.practica.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;	


	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}

	public Usuario saveUser(Usuario user) {
		return usuarioRepository.save(user);
	}

	public Usuario updateUsuario(Usuario usuario) throws ResourceNotFoundException {
		Optional<Usuario> optionalOldUser = usuarioRepository.findUserByUsername(usuario.getUsername());
		if (optionalOldUser.isPresent()) {
			Usuario oldUser = optionalOldUser.get();
			oldUser.setName(usuario.getName());
			oldUser.setPassword(usuario.getPassword());
			oldUser.setEmail(usuario.getEmail());
			oldUser.setUsername(usuario.getUsername());
			return usuarioRepository.save(oldUser);
		} else {
			throw new ResourceNotFoundException("Recurso no encontrado!");
		}
	}

	public Optional<Usuario> getUserByUsernameAndPassword(String username, String password) throws ResourceNotFoundException {
		Optional<Usuario> user = usuarioRepository.findUserByUsernameAndPassword(username, password);
		if(!user.isPresent()) {
			throw new ResourceNotFoundException("Recurso no encontrado!");
		}
		return usuarioRepository.findUserByUsernameAndPassword(username, password);
	}

	public void deleteUserById(Integer id)throws ResourceNotFoundException {
		Optional<Usuario> student = usuarioRepository.findById(id);
		if(!student.isPresent()) {
			throw new ResourceNotFoundException("El servicio no se ha encontrado!");
		}else {
			usuarioRepository.deleteById(id);
		}
	}
}
