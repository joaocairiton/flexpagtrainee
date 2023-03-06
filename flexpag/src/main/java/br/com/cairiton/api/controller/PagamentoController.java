package br.com.cairiton.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cairiton.domain.model.Pagamento;
import br.com.cairiton.domain.repository.PagamentoRepository;
import br.com.cairiton.domain.service.PagamentoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
	
	private PagamentoService pagamentoService;
	private PagamentoRepository pagamentoRepository;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pagamento agendar( @RequestBody Pagamento pagamento) {
		
		return pagamentoService.agendar(pagamento);
	}
	
	
	@PutMapping("/{pagamentoId}")
	public ResponseEntity<Pagamento> atualizar(@PathVariable Long pagamentoId, @Valid @RequestBody Pagamento pagamento) {
		 if (!pagamentoRepository.existsById(pagamentoId)) {
				return ResponseEntity.notFound().build();
			}
			 pagamento.setId(pagamentoId);
			pagamento = pagamentoService.agendar(pagamento);
			return ResponseEntity.ok(pagamento);
		}
	
	@DeleteMapping("/{pagamentoId}")
	public ResponseEntity<Void> remover(@PathVariable Long pagamentoId){
		
		if (!pagamentoRepository.existsById(pagamentoId)) {
			return ResponseEntity.notFound().build();

		}
		pagamentoService.excluir(pagamentoId);
		return ResponseEntity.noContent().build();
		
	}
		
		
	}
	
	
	

	
	


