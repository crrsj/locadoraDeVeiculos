package locadoraDeVeiculos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import locadoraDeVeiculos.model.Veiculos;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long>{

	List<Veiculos> findAllByOperanteTrue();

}
