package br.com.serratec.repositories; //obj responsavel por acerrar dados dos bd dos user

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {//<tipo entidade, tipo id>

}
