//integrar uma api com o front

function getRequest(nome){
    fetch('https://jsonplaceholder.typicode.com/todos/1')
    .then((resolve)=>resolve.json())
    .then((data) => console.log(data))
    .catch((reject)=>console.error);
};

console.log('Início');
getRequest();
console.log('Fim do programa');