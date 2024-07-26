//validacao console.
const idade = 40

console.log("Sua idade é:" + (idade || "Não informado"));

//outra forma boa pratica
console.log(`Sua idade é: + ${idade ||"Não informado"}`);

const pessoas = {
    nome : "jose",
    idade : null,
    cidade : "Petrópolis",
    cargo :undefined
}

const nome = pessoas.nome ?? 'nome nao informado'; //validacao objeto.
const idades = pessoas.idade ?? 'idade nao informada'; //validacao objeto.



