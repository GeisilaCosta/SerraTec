const myPromise = new Promise((resolve, reject) => {
  const nome = "Fulano";

  if (nome === "Fulano") {
    resolve("Usuário Encontrado");
  } else {
    reject("Usuário não Encontrado");
  }
});
