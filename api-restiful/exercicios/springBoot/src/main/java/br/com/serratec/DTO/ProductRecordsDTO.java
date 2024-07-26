package br.com.serratec.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRecordsDTO(@NotBlank String name, @NotNull BigDecimal value) { //(argumentos= atributos que vamos utilizar de produtos )

}


//data Object transfer
//faz a conversao do json para objeto java