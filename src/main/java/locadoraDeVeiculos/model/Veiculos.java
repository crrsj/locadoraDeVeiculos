package locadoraDeVeiculos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import locadoraDeVeiculos.dto.AtualizarCadastro;
import locadoraDeVeiculos.dto.CadastrarVeiculos;
import locadoraDeVeiculos.enums.Cor;
import locadoraDeVeiculos.enums.Marca;

@Entity(name = "veiculos")
@Table(name ="veiculos")
public class Veiculos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nomeCliente;
	@Column(length = 11,nullable = false,unique = true)
	private String cpf;
	@Column(length = 13,nullable = false)
	private String telefone;
	@Enumerated(EnumType.STRING)
	private Marca marca;
	private String modelo;
	@Enumerated(EnumType.STRING)
	private Cor cor;
	@Column(length = 8,nullable = false,unique = true)
	private String placa;
	private String dataDaReserva = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String dataDaEntrega = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	@Column(nullable = false,precision = 5,scale = 2)
	private BigDecimal valorTotal;
	private Boolean operante;
	public Veiculos(Long id, String nomeCliente, String cpf, String telefone, Marca marca, String modelo, Cor cor,
			String placa, String dataDaReserva, String dataDaEntrega, BigDecimal valorTotal, Boolean operante) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.telefone = telefone;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.dataDaReserva = dataDaReserva;
		this.dataDaEntrega = dataDaEntrega;
		this.valorTotal = valorTotal;
		this.operante = true;
	}
	public Veiculos() {
		
	}
	
	public Veiculos(CadastrarVeiculos cadastro) {
		this.nomeCliente = cadastro.nomeCliente();
		this.cpf = cadastro.cpf();
		this.telefone = cadastro.telefone();
		this.marca = cadastro.marca();
		this.modelo = cadastro.modelo();
		this.cor = cadastro.cor();
		this.placa = cadastro.placa();
		this.dataDaReserva = cadastro.dataDaReserva();
		this.dataDaEntrega = cadastro.dataDaEntrega();
		this.valorTotal = cadastro.valorTotal();
		this.operante = true;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getDataDaReserva() {
		return dataDaReserva;
	}
	public void setDataDaReserva(String dataDaReserva) {
		this.dataDaReserva = dataDaReserva;
	}
	public String getDataDaEntrega() {
		return dataDaEntrega;
	}
	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Boolean getOperante() {
		return operante;
	}
	public void setOperante(Boolean operante) {
		this.operante = operante;
	}
	@Override
	public int hashCode() {
		return Objects.hash(valorTotal, cor, cpf, dataDaEntrega, dataDaReserva, id, marca, modelo, nomeCliente,
				operante, placa, telefone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculos other = (Veiculos) obj;
		return Objects.equals(valorTotal, other.valorTotal) && cor == other.cor && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataDaEntrega, other.dataDaEntrega)
				&& Objects.equals(dataDaReserva, other.dataDaReserva) && Objects.equals(id, other.id)
				&& marca == other.marca && Objects.equals(modelo, other.modelo)
				&& Objects.equals(nomeCliente, other.nomeCliente) && Objects.equals(operante, other.operante)
				&& Objects.equals(placa, other.placa) && Objects.equals(telefone, other.telefone);
	}
	public void update(@Valid AtualizarCadastro atualizar) {
		
		if(atualizar.nomeCliente() != null) {
			this.nomeCliente = atualizar.nomeCliente();
			
		}
		if(atualizar.telefone() != null) {
			this.telefone = atualizar.telefone();
			
		}
		if(atualizar.modelo() != null) {
			this.modelo = atualizar.modelo();
		}
		if(atualizar.cor() != null) {
			this.cor = atualizar.cor();
		}
		if(atualizar.dataDaEntrega() != null) {
			this.dataDaEntrega = atualizar.dataDaEntrega();
		}
  	  }
	    public void ativado() {
		this.operante = false;
		
	}
		public void desativado() {
			this.operante = true;
			
		}
	
	

}
