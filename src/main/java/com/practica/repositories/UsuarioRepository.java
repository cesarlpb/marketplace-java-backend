package com.practica.repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practica.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	
    public Optional<Usuario> findUserByUsernameAndPassword(String username, String password);
    public Optional<Usuario> findUserByUsername(String username);
    
}