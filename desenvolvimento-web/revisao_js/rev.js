var y = 15;
y = 'oi';
var z;
var pessoa = null;

console.log(y);
console.log(z);
console.log(pessoa);

const pessoas = {nome:"Ana",idade:34};
const vetor = ['Ana','João',true,1000];

const a =  0===false;
console.log(a);

let exameCovid= true;
/*if (exameCovid) {
    console.log("Resultado Positivo");
}else{
    console.log("Resultado Negativo");
}
*/
console.log(exameCovid?"Resultado Positivo":"Resultado Negativo" );
media=95;
console.log(media>90?"Ótimo":media>70?"Bom":media>50?"Regular":"Ruim");

vetor.push('Roni');
vetor.unshift('Marcos');


vetor.forEach((p,i)=> console.log(p,i));