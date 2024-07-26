console.log(19.9 * 0.6);

let preco = 19.90;
let desconto = 0.4;
let precoComDesconto = preco * (1 - desconto);
console.log(precoComDesconto);

let nome = "caderno";
let categoria = "papelaria";
console.log("categoria: " + categoria
 + ", produto: " + nome
  + ", preco: " + preco
   + ", desconto: " + desconto);

console.log(typeof preco); //typeof identifica o tipo da variavel
console.log(typeof nome);


// desafio troca

let a = 7;
let b = 94;
b => a;
b <= a;

console.log(a);
console.log(b);


/*let a = 7;
let b = 94;

let temp =a;
a = b;
b = temp;
console.log(a);
console.log(b);*/



// desafio area 
// PI * raio * raio
// PI = 3.141592


let raio = 10;
const PI = 3.14;
console.log("A área é de " + PI * raio * raio + " M²");