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
            // Tenta ler o erro detalhado
            let msg = "Erro ao cadastrar.";
            try {
                const erroBody = await resposta.text(); // Tenta ler como texto primeiro
                msg = `Erro do Servidor (${resposta.status}): ${erroBody}`;
            } catch (e) {
                msg = `Erro (${resposta.status})`;
            }
            alert(msg);
            console.error("Erro Cadastro:", msg);
        }

    } catch (erro) {
        console.error("Erro no cadastro:", erro);
        alert("Erro de Conexão. O servidor pode estar desligado.");
    }
}
