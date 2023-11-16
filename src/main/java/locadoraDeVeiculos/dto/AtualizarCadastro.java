package locadoraDeVeiculos.dto;

import jakarta.validation.constraints.NotNull;
import locadoraDeVeiculos.enums.Cor;
import locadoraDeVeiculos.model.Veiculos;

public record AtualizarCadastro(
		@NotNull
		Long id,
		String nomeCliente,			
		String telefone, 	
		String modelo,
		Cor cor,
		String placa,		 
		String dataDaEntrega	
		
		
		
		
		
		) {

	public AtualizarCadastro(Veiculos atualize) {
		this(atualize.getId(),
				atualize.getNomeCliente(),
				atualize.getTelefone(),
				atualize.getModelo(),
				atualize.getCor(),
				atualize.getPlaca(),
				atualize.getDataDaEntrega());
				
	}

}
