package banco;

class Diretor extends Funcionario {
    public Diretor(String cpf, String senha) {
        super(cpf, senha, CargoEnun.DIRETOR);
    }

}
