/* function soma(a,b){
    return a + b;
}*/

//funcao anonima esta dentro da variavel pode ser chamada em qualquer lugar

const soma = function(a,b){
    return a + b;
}

console.log(soma(100,10));

//Arrow function
const soma2 = (a,b) => a+b;
console.log(soma2(100,10));

const soma3 = (a,b) => { /* dois valores*/ 
    a=1000
    return a+b;
}
console.log(soma2(100,10));