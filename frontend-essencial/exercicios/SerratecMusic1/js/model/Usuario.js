/*essa sera uma classe modelo( como as classes do java) */

class Usuario{
    constructor(obj) {/*construtor que vai receber um objeto */
    obj = obj || {} //tratamente anti erro de undefined
        this.id = obj.id; /*atributo chamado id da classe usuario o id que vier desse objeto sera armazenado aqui */
        this.nome = obj.nome;/*pega o obj.nomee armazena aqui, conseito poo */
        this.email = obj.email;
        this.senha = obj.senha;
    } /*o construtor de Usuario *quando mandar construir um usuario passando o obj que tenha os atributos acima, vai armazenar dentro do usuario*/
}