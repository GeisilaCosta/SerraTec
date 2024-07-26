function carregarMensagem() {
let mensagem = document.getElementById("container-msg");

let data = new Date();
let dia = data.getDate();
    let mes = data.getMonth() + 1; // Os meses começam do 0, então adicionamos 1
    let ano = data.getFullYear();
let hora = data.getHours();
let minutos = data.getMinutes();
console.log(hora, minutos);

mensagem.innerText = `Hoje é dia ${dia}/${mes}/${ano},  e agora são ${hora} horas e ${minutos} minutos.`;
}

function carregarImagem() {
let imagem = document.getElementById("img");

let data = new Date();
let hora = data.getHours(); // Obtenha a hora atual

if (hora >= 0 && hora < 12) {
    imagem.src = "./img/manha.jpg";
} else if (hora >= 12 && hora < 18) {
    imagem.src = "./img/dia.jpg";
} else {
    imagem.src = "./img/noite.jpg";
}
}

carregarMensagem();
carregarImagem();