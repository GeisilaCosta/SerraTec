package br.com.serratec.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.models.ProductModel;

//essa classe sera um bean e vai fazer todo controle "gerenciar" a injecao de controle e injecao de dependencia

@Repository//fica redundante usar essa anotacao pois ja estende de repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

}




//@Component mostra pro spring que a classe sera um bean gerenciado por ele
//ja em classes de servicos que envolvem regras de negocios podemos usar 
//@Service para mostrar pro spring que ela vai ser um bean  do tipo service que vai ser gerenciado por ele
//@Repository vai ser um bean gerenciado por ele, que pode ter transacoes com base de dados 
//@Conteoller pode enter por exemplo endpoints