const somar = (a, b) => a + b;

const calcular = (a,b, callback) => {
    return callback(a,b);
};

const resultado = calcular (100, 200, somar);
console.log(resultado);