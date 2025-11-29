async function fazerLogin(event) {
    event.preventDefault();

    const email = document.getElementById('emailLogin').value;
    const senha = document.getElementById('senhaLogin').value;

    try {
        const urlCompleta = `${API_BASE_URL}/login`;
        console.log("Tentando acessar URL:", urlCompleta); // DEBUG: Mostra a URL no console

        const response = await fetch(urlCompleta, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                senha: senha
            })
        });

        if (response.ok) {
            const dados = await response.json();
            console.log("Login - Resposta do servidor:", dados);

            if (dados.token) {
                localStorage.setItem('token', dados.token);
                alert('Login com sucesso! Redirecionando...');
                window.location.href = "../dashboard/dashboard.html";
            } else {
                alert('O servidor respondeu, mas não enviou o token.');
            }
        } else {
            // Tenta ler a mensagem de erro do servidor, se houver
            let mensagemErro = 'Falha no login. Verifique suas credenciais.';
            try {
                const erroJson = await response.json();
                if (erroJson.message || erroJson.erro) {
                    mensagemErro = `Erro do Servidor: ${erroJson.message || erroJson.erro}`;
                }
            } catch (e) {
                // Se não for JSON, usa o status
                mensagemErro = `Erro no Login (Status: ${response.status})`;
            }
            alert(mensagemErro);
            console.error("Erro Login:", response.status, response.statusText);
        }

    } catch (error) {
        console.error('Erro ao fazer login:', error);
        alert('Erro de Conexão: Verifique se o servidor está online.');
    }
}
