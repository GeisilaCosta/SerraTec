package trabalhofinalIA;

public class Banco {
	private Map<String, Cliente> clientes;
    private Map<String, Funcionario> funcionarios;
    private List<Conta> contas;

    public Banco() {
        clientes = new HashMap<>();
        funcionarios = new HashMap<>();
        contas = new ArrayList<>();
    }

    public void inicializarDados() {
        // Inicializar dados do sistema (clientes, funcionários e contas)
    }

    public Usuario autenticarUsuario(String cpf, String senha) {
        Usuario usuario = clientes.get(cpf);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }

        usuario = funcionarios.get(cpf);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }

        return null;
    }
}
