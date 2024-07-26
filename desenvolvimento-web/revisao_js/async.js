function async() {
    setTimeout(() => {
      console.log("Executou!");
    }, 5000);
  }
  console.log("Início do Programa");
  async();
  console.log("Fim do Programa");