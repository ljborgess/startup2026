
async function enviarLogin(event) {
    event.preventDefault(); // 1. Evita recarregamento

    const email = document.getElementById('emailLogin').value;
    const senha = document.getElementById('senhaLogin').value;

    // 2. Monta a URL com os dados pendurados
    // É assim que o @RequestParam do Java lê os dados
    const urlDestino = `http://localhost:8080/client/login?email=${email}&senha=${senha}`;

    try {
    // 3. Faz a chamada (sem 'body' e sem 'headers' de JSON)
    const resposta = await fetch(urlDestino, {
    method: 'POST'
});

    // O Java retorna um texto simples ("Login bem-sucedido" ou erro)
    const textoResposta = await resposta.text();

    if (textoResposta.includes("bem-sucedido")) {
    alert(textoResposta);
    window.location.href = "../dashboard/dashboard.html"; // Entra no sistema!
} else {
    alert("Ops: " + textoResposta);
}
} catch (erro) {
    console.error("Erro:", erro);
    alert("Erro ao conectar no servidor.");
}
}
