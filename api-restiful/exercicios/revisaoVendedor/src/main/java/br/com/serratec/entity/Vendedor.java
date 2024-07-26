package br.com.serratec.entity;

import java.util.ArrayList;
import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_vendedor")
public class Vendedor {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long codigoVendedor;
		
		 @NotNull(message = "O nome não pode ser nulo")
		 @Size(min = 3, message = "O nome não pode ser vazio")
	    private String nome;
		 
		 @Email(message = "Email inválido")
		    @Column(unique = true) // Garante que o email seja único no banco de dados
		    private String email;

		    @Min(value = 1500, message = "O salário não pode ser inferior ao salário mínimo")
		    @NonNull // Garante que o salário não seja nulo
		    private Double salario;
		    
		    
		
		    private Double comissao;

		 @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
		    private List<LancamentoVendas> lancamentos = new ArrayList<>();
		    
		 
		 
		 public Vendedor() {
			}

		 
		public Vendedor(Long codigoVendedor,
				@NotNull(message = "O nome não pode ser nulo") @Size(min = 3, message = "O nome não pode ser vazio") String nome,
				@Email(message = "Email inválido") String email,
				@Min(value = 1500, message = "O salário não pode ser inferior ao salário mínimo") Double salario,
				Double comissao, List<LancamentoVendas> lancamentos) {
			super();
			this.codigoVendedor = codigoVendedor;
			this.nome = nome;
			this.email = email;
			this.salario = salario;
			this.comissao = comissao;
			this.lancamentos = lancamentos;
		}


		public Long getCodigoVendedor() {
			return codigoVendedor;
		}

		public void setCodigoVendedor(Long codigoVendedor) {
			this.codigoVendedor = codigoVendedor;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Double getSalario() {
			return salario;
		}

		public void setSalario(Double salario) {
			this.salario = salario;
		}

		public Double getComissao() {
			return comissao;
		}

		public void setComissao(Double comissao) {
			this.comissao = comissao;
		}

		public List<LancamentoVendas> getLancamentos() {
			return lancamentos;
		}

		public void setLancamentos(List<LancamentoVendas> lancamentos) {
			this.lancamentos = lancamentos;
		}

//adicionei os métodos addLancamento e removeLancamento para gerenciar o lado de propriedade do relacionamento.
		/* public void addLancamento(LancamentoVendas lancamento) {
		        lancamentos.add(lancamento);
		        lancamento.setVendedor(this);
		    }

		    public void removeLancamento(LancamentoVendas lancamento) {
		        lancamentos.remove(lancamento);
		        lancamento.setVendedor(null);
		    }*/

}

/*A classe Vendedor é uma entidade JPA, como indicado pela anotação @Entity.
 *  Isso significa que os objetos desta classe podem ser persistidos em 
 *  um banco de dados.
A tabela correspondente no banco de dados é tb_vendedor, conforme 
especificado pela anotação @Table.
A classe possui vários campos, cada um com suas próprias restrições de 
validação, como @NotNull, @Size, @Email e @Min.
O campo lancamentos é uma lista de LancamentoVendas que está mapeada para a 
entidade Vendedor através de um relacionamento OneToMany. Isso significa 
que um Vendedor pode ter vários LancamentoVendas.
Os métodos addLancamento e removeLancamento são usados para adicionar e 
remover LancamentoVendas da lista lancamentos de um Vendedor, 
respectivamente. Eles também gerenciam o lado de propriedade do 
relacionamento.*/
