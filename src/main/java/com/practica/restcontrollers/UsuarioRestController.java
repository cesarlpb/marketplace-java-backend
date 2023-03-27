package com.practica.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practica.exceptions.ResourceNotFoundException;
import com.practica.model.Usuario;
import com.practica.service.UsuarioService;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;
	
	//User List
	@CrossOrigin
	@GetMapping(path = "/list", produces = "application/json")
	public ResponseEntity<List<Usuario>> getAllUsers() {
		List<Usuario> usuariosList = this.usuarioService.getUsuarios();
		return ResponseEntity.ok(usuariosList);
	}
	//Find user by name and password
	@CrossOrigin
	@GetMapping(path = "/validation/{user}/{password}", produces = "application/json")
	public ResponseEntity<Optional<Usuario>> getUsersByUserAndPassword(@PathVariable("user") String username, @PathVariable("password") String password) throws ResourceNotFoundException {
		Optional<Usuario> usuarioOptional = this.usuarioService.getUserByUsernameAndPassword(username, password);
		return new ResponseEntity<Optional<Usuario>>(usuarioOptional, HttpStatus.OK);
	}
	//New user
	@CrossOrigin
	@PostMapping("/new")
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario user) {
		Usuario savedUser = this.usuarioService.saveUser(user);
		return new ResponseEntity<Usuario>(savedUser, HttpStatus.CREATED);
	}
	//Update user
	@CrossOrigin
	@PutMapping("/update/{user}")
	public ResponseEntity<Usuario> updateUser(
			@RequestBody Usuario usuario, 
			@PathVariable("user") String user) 
					throws ResourceNotFoundException {
		Usuario updatedUser = usuarioService.updateUsuario(usuario);
		return new ResponseEntity<Usuario>(updatedUser, HttpStatus.OK);
	}
	//Delete User
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteStudent(@PathVariable int id) throws ResourceNotFoundException{
		this.usuarioService.deleteUserById(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.CREATED);
	}
}
