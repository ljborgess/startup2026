async function fazerLogin(event) {
    event.preventDefault();

    const email = document.getElementById('emailLogin').value;
    const senha = document.getElementById('senhaLogin').value;

    try {
        const urlCompleta = `${API_BASE_URL}/login`;
        
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
            
            if (dados.token) {
                localStorage.setItem('token', dados.token);
                alert('Login com sucesso! Redirecionando...');
                window.location.href = "../dashboard/dashboard.html";
            } else {
                alert('O servidor respondeu, mas não enviou o token.');
            }
        } else {
            let mensagemErro = 'Falha no login. Verifique suas credenciais.';
            try {
                const erroJson = await response.json();
                if (erroJson.message || erroJson.erro) {
                    mensagemErro = `Erro do Servidor: ${erroJson.message || erroJson.erro}`;
                }
            } catch (e) {
                mensagemErro = `Erro no Login (Status: ${response.status})`;
            }
            alert(mensagemErro);
        }

    } catch (error) {
        alert('Erro de Conexão: Verifique se o servidor está online.');
    }
}
