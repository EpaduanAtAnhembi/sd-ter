// fetch('http://localhost:8080/veiculo/6')
// .then(response => response.json())
// .then(data => console.log(data))

async function getDados() {
    try{
        const response = await fetch('http://localhost:8080/veiculo/'+id.value)
        if(response.status == 200) {
            const data = await response.json()
            // console.log(data);
            txtModelo.value = data['modelo']
            txtPlaca.value = data['placa']
            txtAno.value = data['ano']
        } else {
            console.log('Veículo não encontrado.');
        }
    } catch(erro) {
        console.log('Erro na requisição: ', erro);
    }
}

// getDados()

async function insert() {
    const response = await fetch('http://localhost:8080/veiculo',{
        method:'POST',
        headers:{
            'Content-Type': 'application/json'
        },
        body:
            JSON.stringify({
                "modelo": txtModelo.value,
                "placa": txtPlaca.value,
                "ano": txtAno.value
            })
        }
    )
    if(response.status == 201) {
        const data = await response.json()
        console.log(data);
    } else {
        console.log('Não foi possível inserir os dados.');
    }
}

// insert()

const txtModelo = document.getElementById('modelo')
const txtPlaca = document.getElementById('placa')
const txtAno = document.getElementById('ano')
const botao = document.getElementById('botao')
const id = document.getElementById('id')

botao.addEventListener('click', insert)
botaoler.addEventListener('click', getDados)