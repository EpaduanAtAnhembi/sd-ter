// Não define tipos de dados
// 'var' tem escopo não limitado
// 'let' tem escopo delimitado pelo bloco
//  'const' define uma constante

var variable = 12

console.log(variable);

variable = "texto"

console.log(variable);

let nome = "Emerson"

const idade = 34;

idade = 12; // erro pois não pode mudar de valor

console.log(idade);