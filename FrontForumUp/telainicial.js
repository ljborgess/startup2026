
// Lógica simples de redirecionamento
function pesquisar() {
    const termo = document.getElementById('searchInput').value;
    if(termo) {
    // Aqui você redirecionaria para a tela de resultados
    // Por enquanto, vamos simular indo para o dashboard
    alert("Você pesquisou por: " + termo + ". Redirecionando...");
    window.location.href = 'dashboard.html';
} else {
    alert("Digite algo para buscar!");
}
}

    // Enter também funciona
    document.getElementById('searchInput').addEventListener('keypress', function (e) {
    if (e.key === 'Enter') pesquisar();
});
