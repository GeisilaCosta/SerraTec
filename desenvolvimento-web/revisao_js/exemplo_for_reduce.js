const numeros = [10, 30, 40, 50];

let soma = 0;
for (let i = 0; i < numeros.length; i++) {
    soma = soma + numeros[i];
}


let resultado = numeros.reduce( (soma, num)=> soma +num ,0);

console.log(resultado);