package br.com.cairiton.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cairiton.domain.model.Usuario;
import br.com.cairiton.domain.repository.UsuarioRepository;
import br.com.cairiton.domain.service.CadastroUsuarioService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioRepository usuarioRepository;
	private CadastroUsuarioService cadastroUsuarioService;

	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario Adicionar(@Valid @RequestBody  Usuario usuario) {
		return cadastroUsuarioService.salvar(usuario);
		
	}
	
	@PutMapping("/{usuarioId}")
	public ResponseEntity<Usuario> Atualizar(@PathVariable Long usuarioId, @Valid @RequestBody Usuario usuario) {
		 if (!usuarioRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
		}
		 usuario.setId(usuarioId);
		usuario = cadastroUsuarioService.salvar(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping("/{usuarioId}")
	public ResponseEntity<Void> remover(@PathVariable Long usuarioId){
		
		if (!usuarioRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();

		}
		cadastroUsuarioService.excluir(usuarioId);
		return ResponseEntity.noContent().build();
		
	}
	

}
