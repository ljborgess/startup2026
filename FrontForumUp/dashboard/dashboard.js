
// Verifica se o usuário está logado
const token = localStorage.getItem('token');

if (!token) {
    alert("Você precisa estar logado para acessar essa página.");
    window.location.href = "../login/login.html";
} else {
    // Se tiver token, decodifica e preenche os dados
    preencherDadosUsuario(token);
}

function preencherDadosUsuario(token) {
    try {
        // Decodifica o JWT (o payload é a segunda parte, índice 1)
        const payloadBase64 = token.split('.')[1];
        // Corrige caracteres especiais para decodificar corretamente UTF-8
        const payloadDecoded = JSON.parse(atob(payloadBase64.replace(/-/g, '+').replace(/_/g, '/')));
        
        console.log("Dados do Token:", payloadDecoded);

        // Pega os elementos do HTML
        const nomeElement = document.querySelector('.user-name');
        const emailElement = document.querySelector('.user-email');

        // Atualiza com os dados do token
        // O 'sub' é o subject (email), e o 'nome' é a claim que adicionamos
        if (nomeElement) nomeElement.textContent = "Olá, " + (payloadDecoded.nome || "Usuário");
        if (emailElement) emailElement.textContent = payloadDecoded.sub || "email@indisponivel.com";

    } catch (e) {
        console.error("Erro ao processar token:", e);
        // Se o token for inválido, manda pro login
        localStorage.removeItem('token');
        window.location.href = "../login/login.html";
    }
}


// Script simples para linkar os cards ao chat
const cards = document.querySelectorAll('.card');
cards.forEach(card => {
    card.addEventListener('click', () => {
        // Aqui futuramente checaremos qual ID de sala foi clicado
        window.location.href = 'chat.html';
    });
});
