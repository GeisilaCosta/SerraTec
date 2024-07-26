package br.com.serratec.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoVendedor;
    
    @NotBlank(message = "Campo nulo ou vazio!")
    private String nome;
    
    @Email(message = "Email invalido!")
    private String email;
    
    @DecimalMin(value = "1412", message = "O valor inserido Deve ser maior do que um salário mínimo! (1412)")
    private Double salario;
    
    private Double comissao;

    @JsonManagedReference
    @OneToMany(mappedBy = "vendedor")
    private List<LancamentoVendas> lancamentoVendas = new ArrayList<>();

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

    public List<LancamentoVendas> getLancamentoVendas() {
        return lancamentoVendas;
    }

    public void setLancamentoVendas(List<LancamentoVendas> lancamentoVendas) {
        this.lancamentoVendas = lancamentoVendas;
    }
}