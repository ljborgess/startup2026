📌 ForumUp – Web Forum Project

Bem-vindo ao ForumUp, um projeto de fórum web simples e moderno criado para estudos e prática de Java + Spring Boot.

🚀 Tecnologias Utilizadas

Java 17+

Spring Boot (via Spring Initializr)

H2 / MySQL (conforme sua escolha)

Postman (para testar a API)

HTML + CSS + JavaScript (front simples)

📂 Estrutura Básica da API
👤 Client (Usuário)

A API permite:

Registrar novo usuário

Listar todos os usuários

Realizar login

🛠️ Endpoints
🔹 Registrar Usuário

POST /client/registrar
Body (JSON):

{
  "nome": "Luciano",
  "regiao": "SP",
  "telefone": "1199999999",
  "email": "teste@mail.com",
  "senha": "1234"
}

🔹 Listar Todos os Usuários

GET /client/listar

🔹 Login

POST /client/login
Body (JSON):

{
  "email": "teste@mail.com",
  "senha": "1234"
}

▶️ Como Rodar o Projeto

Clone o repositório:

git clone https://gitlab.com/lluborges004/startup2026


Abra no IntelliJ / Eclipse

Execute o projeto pelo Spring Boot

Banco de dados PostgreSQL
com o olho "Raio-X" Dbeaver + Uso do Docker

