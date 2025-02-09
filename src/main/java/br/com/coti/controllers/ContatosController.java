package br.com.coti.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coti.entities.Contato;
import br.com.coti.repositories.ContatosRepositories;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos")
public class ContatosController {

	@Operation(summary = "Serviço para listar todos os contatos")
	@GetMapping()
	public List<Contato> listarContatos() {
		var contatoRepository = new ContatosRepositories();

		try {
			return contatoRepository.listarContatos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Operation(summary = "Serviço para consultar um contato pelo ID")
	@GetMapping("/{idContato}")
	public Contato consultarContato(@PathVariable int idContato) {
		var contatoRepository = new ContatosRepositories();

		try {
			return contatoRepository.consultarContatoPorId(idContato);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Operation(summary = "Serviço para cadastrar um novo contato")
	@PostMapping()
	public void cadastrarContato(@RequestBody Contato contato) {
		var contatoRepository = new ContatosRepositories();

		try {
			contatoRepository.cadastrarContato(contato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Operation(summary = "Serviço para atualizar um contato")
	@PutMapping()
	public void atualizarContato(@RequestBody Contato contato) {
		var contatoRepository = new ContatosRepositories();

		try {
			contatoRepository.atualizarContato(contato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Operation(summary = "Serviço para excluir um contato")
	@DeleteMapping("/{idContato}")
	public void excluirContato(@PathVariable int idContato) {
		var contatoRepository = new ContatosRepositories();

		try {
			contatoRepository.excluirContato(idContato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
