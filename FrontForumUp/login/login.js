async function fazerLogin(event) {
    event.preventDefault();

    const email = document.getElementById('emailLogin').value;
    const senha = document.getElementById('senhaLogin').value;

    try {
        //  A URL agora é apenas '/login' (sem /client)
        const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json' // MUDANÇA 2: Avisa que é JSON
            },
            //  Envia os dados no corpo (body), não na URL
            body: JSON.stringify({
                email: email,
                senha: senha
            })
        });

        if (response.ok) {
            // ... dentro do if (response.ok) ...

            const dados = await response.json();

            // --- ORA DA VERDADE ---
            console.log("JSON RECEBIDO:", dados);
            // Tem que aparecer: { token: "eyJhbG..." }

            // Se o Java estiver certo, isso vai funcionar:
            if (dados.token) {
                localStorage.setItem('token', dados.token);
                alert('Login Sucesso! Redirecionando...');
                window.location.href = "../dashboard/dashboard.html";
            } else {
                alert('O servidor respondeu, mas não mandou o token!');
            }
        } else {
            alert('Falha no login. Verifique suas credenciais.');
        }

    } catch (error) {
        console.error('Erro:', error);
        alert('Erro ao conectar com o servidor.');
    }
}