
let pontos = 60

console.log(typeof pontos);

if (pontos > 100) {
    console.log('Excelente!');
} else {
    if(pontos > 50) {
        console.log('Bom');
    } else {
        console.log('Precisa melhorar');
    }
}

let mes = 'maio'
console.log(typeof mes); // retorna o tipo de dados da variável no momento

switch (mes) {
    case 'fev':
        console.log('Calor.');
        break;
    case 'maio':
        console.log('Quase inverno...');
        break;
    default:
        console.log('Outr mês');
        break;
}
