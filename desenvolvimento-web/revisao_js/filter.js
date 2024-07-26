//filter faz comparacoes e retorna um booleano true ou false

const numeros = [10,20,40,2,23];

const multiplos= numeros.filter( (num) => num % 2 ==0 );
console.log(multiplos);

const pessoas = [
    { nome: "Ana", idade: 18, cidade: "Petrópolis", salario: 1500 },
    { nome: "Igor", idade: 55, cidade: "Petrópolis", salario: 3500 },
    { nome: "Carla", idade: 24, cidade: "Petrópolis", salario: 5500 },
    { nome: "Carlos", idade: 44, cidade: "São Paulo", salario: 6500 },
    { nome: "Sergio", idade: 34, cidade: "Areal", salario: 4500 },
];

const pessoasFiltro = pessoas.filter( (p) => p.cidade==="Petrópolis" && p.salario >=2000 );
console.log(pessoasFiltro);

const totalSalario = pessoas.reduce( (acum,p)=> acum + p.salario,0);
console.log(totalSalario);

const pessoasFiltros = pessoas.filter( (p) => p.cidade==="Petrópolis" && p.salario >=2000 ).reduce( (acum,p)=> acum + p.salario,0);;
console.log(pessoasFiltros);