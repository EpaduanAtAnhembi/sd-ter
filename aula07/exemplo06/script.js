const botao = document.getElementById('btnSalvar')
const titulo = document.getElementById('info')
const formulario = document.getElementById('myform')

function mensagem(){
    console.log('click no botão')
}

botao.addEventListener("click", mensagem)

titulo.addEventListener('mouseenter', ()=>{
    titulo.style.color = 'red'
})

titulo.addEventListener('mouseleave', ()=>{
    titulo.style.color = 'black'
})

const nome = document.getElementById('nome')

formulario.addEventListener('submit', (event)=>{
    event.preventDefault();

    if(nome.value === ""){
        alert('O campo nome é obrigatório!')
    } else {
        alert('dados enviados!')
    }
})