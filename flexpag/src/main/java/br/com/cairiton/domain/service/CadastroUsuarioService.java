package br.com.cairiton.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cairiton.domain.model.Usuario;
import br.com.cairiton.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CadastroUsuarioService {
	
	private UsuarioRepository usuarioRepository;
	

	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void excluir(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
	}

}
