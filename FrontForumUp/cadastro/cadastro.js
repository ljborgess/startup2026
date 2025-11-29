async function enviarCadastro(event) {
    event.preventDefault();

    const dadosUsuario = {
        nome: document.getElementById('nome').value,
        email: document.getElementById('email').value,
        senha: document.getElementById('senha').value,
        telefone: document.getElementById('telefone').value,
        regiao: "Brasil"
    };

    try {
        const resposta = await fetch(`${API_BASE_URL}/client/register`, {
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
            alert("Erro ao cadastrar. Verifique se o email já existe.");
        }

    } catch (erro) {
        console.error("Erro no cadastro:", erro);
        alert("Erro ao conectar com o servidor.");
    }
}
