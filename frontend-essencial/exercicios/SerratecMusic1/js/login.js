let formulario = {
    /* email : document.getElementById("email"),*/
    /* senha : document.getElementById("senha"),*/
   /*boton : document.getElementById("btn-entrar") *//*ou*/

email : document.querySelector("#email"),
senha : document.querySelector("#senha"),
btnEntrar : document.querySelector("#btn-entrar")

};

formulario.btnEntrar.addEventListener('click', () => {
    alert("Olá!!");/*botao entrar recebe a funcao com 2 parametros, quando acontecer click e vai executar funcao flash, vai executar os comandos dentro `{}  */

    let usuario = new Usuario({/*Criando um obj usuario com email e senhaara validar se o usuario e senha podem acessar o sistema */
        email : formulario.email.value,
        senha : formulario.senha.value
    });

    autenticar(usuario.email, usuario.senha);//validar se o usuario e senha podem acessar o sistema

    //window.open('/artistas.html', '_self');/*abrir a pg artista na mesma tela */
    //usuario.validarUsuario();/*chamando a funcao validar usuario*/
});

//colocar um codigo que vai autenticar la na api e retornar se o usuario tem acesso ou nao
function autenticar(email, senha){
    fetch(`${URL_BASE}/api/login`,
        headers:{
            "Content-Type": "application/json"
        },
        method : "POST",
        body: JSON.stringify({
        user: email,
        password: senha
    })
    .then(response => {
        let token = response.headers.get("Autorization");
        salvarToken(token);
        direcionarTelaDeArtistas();
    })

    .cath(error => {
        console,log(error);
        alert("nao foi possivel autenticar")
    })

}