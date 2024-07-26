const numeros = [10,20,40,2,23];
const numerosMultiplicados= numeros.map((num) => num * 2);
console.log(numerosMultiplicados);

//exercicio, imprimir a primeira letra de cada time
const times = ['Flamengo','Vasco','Fluminense','Bangu','Botafogo'];

/*Este código irá imprimir a primeira letra de cada time no console. Por exemplo, para o array de times fornecido, a saída será ['F', 'V', 'F', 'B', 'B']. Espero que isso ajude! Se você tiver mais perguntas sobre JavaScript*/
const primeirasLetras = times.map(time => time[0]);
console.log(primeirasLetras);

//ou da o mesmo resultado 0 posicao do array 1 a primeira letra
const primeirasLetra = times.map((time) => time.substring(0,1));
console.log(primeirasLetra);
