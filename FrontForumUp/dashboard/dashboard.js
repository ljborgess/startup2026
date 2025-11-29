
    // Script simples para linkar os cards ao chat

const cards = document.querySelectorAll('.card');
    cards.forEach(card => {
    card.addEventListener('click', () => {
        // Aqui futuramente checaremos qual ID de sala foi clicado
        window.location.href = 'chat.html';
    });
});
