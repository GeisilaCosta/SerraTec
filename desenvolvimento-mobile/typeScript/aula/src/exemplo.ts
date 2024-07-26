// const aula = "Hello World!"
// console.log(aula);

class Pessoa {
    nome;
    email;
    constructor(nome:string, email:string) {
      this.nome = nome;
      this.email = email;
    }
  }
  const pessoa1 = new Pessoa("Carla", "c@gmail.com");
  console.log(pessoa1);