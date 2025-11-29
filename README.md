## 🛠️ Tecnologias Utilizadas

### Backend (API)
- **Java 17** - Linguagem Core
- **Spring Boot 3** - Framework principal
- **Spring Security + JWT** - Autenticação e Segurança Stateless
- **Spring Data JPA** - Persistência de dados
- **PostgreSQL** - Banco de Dados Relacional
- **Maven** - Gerenciamento de dependências
- **Lombok** - Redução de boilerplate code

### Frontend (Cliente)
- **HTML5 & CSS3** - Estrutura e Estilização (Responsivo)
- **JavaScript (ES6+)** - Lógica assíncrona e consumo de API
- **Fetch API** - Comunicação HTTP com o Backend

---

## ✨ Funcionalidades Principais

- [x] **Cadastro de Usuários:** Criação de conta com validação e criptografia de senha (BCrypt).
- [x] **Autenticação Segura:** Login via Token JWT (JSON Web Token).
- [x] **Dashboard Interativo:** Área restrita que carrega dados do usuário via Token.
- [x] **Criação de Salas/Fóruns:** (Em desenvolvimento) Espaços temáticos para discussão.
- [ ] **Chat em Tempo Real:** (Planejado) WebSockets para conversas instantâneas.

---

## 🚀 Como Rodar o Projeto Localmente

### Pré-requisitos
- Java JDK 17 instalado
- Maven instalado
- PostgreSQL instalado e rodando (ou Docker)

### 1. Configuração do Banco de Dados
Crie um banco de dados no PostgreSQL chamado `postgres` (ou ajuste no `application.properties`). O Spring Boot criará as tabelas automaticamente.

### 2. Executando o Backend
```bash
# Clone o repositório
git clone https://github.com/SEU-USUARIO/startup2026.git

# Entre na pasta do backend
cd startup2026/forumup

# Execute a aplicação
mvn spring-boot:run
```
O servidor iniciará na porta `8080`.

### 3. Executando o Frontend
Como o frontend é estático, você não precisa de servidor node.
1. Navegue até a pasta `FrontForumUp`.
2. Abra o arquivo `login/login.html` no seu navegador.
3. Certifique-se de que o arquivo `config.js` aponta para `http://localhost:8080`.

---

## ☁️ Deploy (Hospedagem)

O projeto está configurado para deploy fácil em nuvem.

- **Backend:** Configurado para **Railway** (usa variáveis de ambiente para DB e Porta).
- **Frontend:** Pode ser hospedado em **Vercel** ou **Netlify**.

### Passos Rápidos para Deploy:
1. Suba o backend no Railway e conecte um banco PostgreSQL.
2. Copie a URL gerada pelo Railway.
3. Atualize o arquivo `FrontForumUp/config.js` com a nova URL.
4. Suba o frontend no Vercel.

---


---
Desenvolvido por **Luciano Borges , Arthur Mereu, Bruna Longuim** 💻
