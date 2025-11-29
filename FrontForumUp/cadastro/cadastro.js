
    //
    async function enviarCadastro(event) {
    event.preventDefault();
    // ... (restante do seu código JS)
    const dadosUsuario = {
    nome: document.getElementById('nome').value,
    email: document.getElementById('email').value,
    senha: document.getElementById('senha').value,
    telefone: document.getElementById('telefone').value,
    regiao: "Brasil"
};
    try {
    const resposta = await fetch('http://localhost:8080/client/register', {
    method: 'POST',
    headers: {
    'Content-Type': 'application/json'
},
    body: JSON.stringify(dadosUsuario)
});
    if (resposta.ok) {
    alert("Sucesso! Conta criada.");
    window.location.href = "../login/login.html";
} else {
    alert("Erro! Talvez o email já exista.");
}
} catch (erro) {
    console.error("Erro técnico:", erro);
    alert("O servidor Java está desligado?");
}
}
