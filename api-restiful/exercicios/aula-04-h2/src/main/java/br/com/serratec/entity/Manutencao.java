package br.com.serratec.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Manutencao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id; 
		private LocalDate dataEntrada; 
		private LocalDate dataSaida;
		private String obs;
		
		//cria a tebela de decomposicao manutencao_servico
		@ManyToMany
		@JoinTable(name = "manutencao_servico", 
		joinColumns = @JoinColumn(name="id_manutencao"),
		inverseJoinColumns = @JoinColumn(name="id_servico"))		
		private Set<Servico> servicos = new HashSet<>();
		
		
		public Set<Servico> getServicos() {
			return servicos;
		}
		public void setServicos(Set<Servico> servicos) {
			this.servicos = servicos;
		}
		@JsonBackReference //relacionamento pra na dar loop
		@ManyToOne  //relacionamento tabela um prar um
		@JoinColumn(name = "id_veiculo") //define chave estrangeira
		private Veiculo veiculo;
		
		
		public Veiculo getVeiculo() {
			return veiculo;
		}
		public void setVeiculo(Veiculo veiculo) {
			this.veiculo = veiculo;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public LocalDate getDataEntrada() {
			return dataEntrada;
		}
		
		@PrePersist
		public void persistDataEntrada() {
			System.out.println("PEGANDO DATA DO SISTEMA");
			dataEntrada = LocalDate.now();//AUTOMATICO
		}
		/*public void setDataEntrada(LocalDate dataEntrada) {
			this.dataEntrada = dataEntrada; NAO E NECESSARIO POIS IRA GERAR AUTOMATICO
		}*/
		public LocalDate getDataSaida() {
			return dataSaida;
		}
		public void setDataSaida(LocalDate dataSaida) {
			this.dataSaida = dataSaida;
		}
		public String getObs() {
			return obs;
		}
		public void setObs(String obs) {
			this.obs = obs;
		}
		
		
}
