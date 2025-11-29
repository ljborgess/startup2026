async function fazerLogin(event) {
    event.preventDefault();

    const email = document.getElementById('emailLogin').value;
    const senha = document.getElementById('senhaLogin').value;

    try {
        const response = await fetch(`${API_BASE_URL}/login`, {
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
            alert('Falha no login. Verifique suas credenciais.');
        }

    } catch (error) {
        console.error('Erro ao fazer login:', error);
        alert('Erro ao conectar com o servidor.');
    }
}
