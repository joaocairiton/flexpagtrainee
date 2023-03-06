package br.com.cairiton.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cairiton.domain.model.Pagamento;
import br.com.cairiton.domain.model.StatusPagamento;
import br.com.cairiton.domain.model.Usuario;
import br.com.cairiton.domain.repository.PagamentoRepository;
import br.com.cairiton.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PagamentoService {
	
	private UsuarioRepository usuarioRepository;
	private PagamentoRepository pagamentoRepository;
	
	
	@Transactional
	public Pagamento agendar( Pagamento pagamento) {
		
		/*
		 * Usuario usuario = usuarioRepository.findById(pagamento.getUsuario().getId())
		 * .orElseThrow(()-> new NegocioException("nao exist"));
		 * 
		 * 
		 * 
		 * pagamento.setUsuario(usuario);
		 */
		pagamento.setStatus(StatusPagamento.PENDENTE);
		pagamento.setDatapagamento(pagamento.getDatapagamento());
		
		return pagamentoRepository.save(pagamento);
	}
	public void excluir(Long pagamentoId) {
		pagamentoRepository.deleteById(pagamentoId);
	}

}
