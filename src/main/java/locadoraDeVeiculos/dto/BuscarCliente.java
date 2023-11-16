package locadoraDeVeiculos.dto;

import locadoraDeVeiculos.model.Veiculos;

public record BuscarCliente(
		Long id,
		String nomeCliente,			
		String telefone, 	
		String modelo,		
		String placa,
		String dataDaReserva,
		String dataDaEntrega   	                       	          		
				
		
		                    ) {
	
  
    public BuscarCliente(Veiculos buscar) {
    	this(buscar.getId(),
    			buscar.getNomeCliente(),
    			buscar.getTelefone(),
    			buscar.getModelo(),
    			buscar.getPlaca(),
    			buscar.getDataDaReserva(),
    			buscar.getDataDaEntrega());
    }
}
