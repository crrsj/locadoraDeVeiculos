package locadoraDeVeiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import locadoraDeVeiculos.dto.AtualizarCadastro;
import locadoraDeVeiculos.dto.BuscarCliente;
import locadoraDeVeiculos.dto.CadastrarVeiculos;
import locadoraDeVeiculos.model.Veiculos;
import locadoraDeVeiculos.repository.VeiculosRepository;

@RestController
@RequestMapping("veiculos")
public class VeiculosController {
	@Autowired
	private VeiculosRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CadastrarVeiculos>cadastrar(@RequestBody @Valid CadastrarVeiculos cadastro, UriComponentsBuilder uriBuilder ){
	var cadastrar = (new Veiculos(cadastro));	
	repository.save(cadastrar);
	var uri = uriBuilder.path("/veiculs/{id}").buildAndExpand(cadastrar.getId()).toUri();
	return ResponseEntity.created(uri).body(cadastro);
	
   } @GetMapping
     public ResponseEntity<List<BuscarCliente>>buscar(){
    	 var busca = repository.findAllByOperanteTrue().stream().map(BuscarCliente::new).toList();
    	 return ResponseEntity.ok(busca);
    	 
     }
    
   @GetMapping("/{id}")
   public ResponseEntity<BuscarCliente>BuscaPorId(@PathVariable Long id){
	   var buscarId = repository.getReferenceById(id);
	   return ResponseEntity.ok(new BuscarCliente(buscarId));
	   
   }
   @PutMapping
   @Transactional
   public ResponseEntity<AtualizarCadastro>atualizar(@RequestBody @Valid AtualizarCadastro atualizar){
	   var atualize = repository.getReferenceById(atualizar.id());
	   atualize.update(atualizar);
	   return ResponseEntity.ok(new AtualizarCadastro(atualize));
   }
   @DeleteMapping("{id}")
   @Transactional
   public ResponseEntity<Void>excluir(@PathVariable Long id){
	   repository.deleteById(id);	   
	   return ResponseEntity.noContent().build();
	   
   }
   @DeleteMapping("desativando/{id}")
   @Transactional
   public ResponseEntity<BuscarCliente>desativarRegistro(@PathVariable Long id){
	   var desativar  = repository.getReferenceById(id);
	   desativar.ativado();
	   return ResponseEntity.noContent().build();
   }
   @PutMapping("ativando/{id}")
   @Transactional
   public ResponseEntity<Void>ativar(@PathVariable Long id){
	   var reativar  = repository.getReferenceById(id);
	   reativar.desativado();
	   return ResponseEntity.ok().build();
   }
}
