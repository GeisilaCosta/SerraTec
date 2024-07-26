"use strict";
class Pessoa {
    constructor(nome, email) {
        this.nome = nome;
        this.email = email;
    }
}
const pessoa1 = new Pessoa("Carla", "c@gmail.com");
console.log(pessoa1);
