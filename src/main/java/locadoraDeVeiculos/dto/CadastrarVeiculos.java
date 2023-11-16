package locadoraDeVeiculos.dto;

import java.math.BigDecimal;


import jakarta.validation.constraints.NotBlank;
import locadoraDeVeiculos.enums.Cor;
import locadoraDeVeiculos.enums.Marca;
import locadoraDeVeiculos.model.Veiculos;

public record CadastrarVeiculos(
		@NotBlank
		String nomeCliente,
		@NotBlank
		String cpf,
		@NotBlank
		String telefone,	
		Marca marca,
		@NotBlank
		String modelo,
		Cor cor,
		String placa,
		String dataDaReserva,
		String dataDaEntrega,
		BigDecimal valorTotal
		                         	          		
				
		
		                      ) {

 }
  
