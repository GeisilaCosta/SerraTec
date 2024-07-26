package br.com.serratec.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel implements Serializable { //o implemento "interface" serve para dizer que essa classe que esta habilitada para passar por serializacoes 
	private static final long serialVersionUID = 1L; //numero de controle de versiao de cada uma dessas classes que forem serializadas quando houver necessidade
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID idProduct; //garante um id unico
	private String name; 
	private BigDecimal value;
	
	
	public UUID getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(UUID idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
