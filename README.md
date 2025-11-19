# LivingAlone

Um projeto acadêmico desenvolvido para a disciplina **Projeto de Programação** com o professor **Fernando Henrique Vieira Trindade**, utilizando **Java puro**, arquitetura em camadas e boas práticas de programação. O sistema simula um pequeno blog, permitindo gerenciamento de usuários, postagens, comentários, categorias e avaliações.

---

## 🚀 Objetivo do Projeto

Criar uma aplicação Java organizada, modular e sustentável, explorando:

* Programação orientada a objetos
* Encapsulamento e coesão
* Repositórios e serviços
* Interfaces (contratos)
* Pilha para histórico e desfazer ações
* Boas práticas de design

---

## 🏛️ Arquitetura

O projeto é baseado em uma arquitetura simples, dividida em camadas:

```
app/                    → Entrada do programa (main)
interfaces/services/    → Interfaces de serviços (contratos)
service/                → Implementação das regras de negócio
repository/             → Armazenamento em memória
model/                  → Entidades do domínio (Post, Usuario, etc.)
exceptions/             → Exceções personalizadas
```

---

## ✨ Funcionalidades

### 👤 Usuários

* Registrar nova conta
* Login
* Sistema simples de permissão (ADMIN / PADRAO)

### 📝 Postagens

* Criar postagens
* Listar por categoria
* Listar por autor
* Buscar por título
* Desfazer última postagem (pilha)
* Remover postagem (se autorizado)
* Avaliar postagens

### 💬 Comentários

* Adicionar comentários nas postagens

### ⭐ Avaliações

* Usuários podem avaliar postagens com nota + comentário opcional

---

## 🧱 Tecnologias Utilizadas

* **Java 17+**
* Arquitetura modular usando interfaces
* Estrutura de dados: Pilha
* Console / CLI

---

## 📦 Como executar

1. Clone o repositório:

```
git clone https://github.com/gabrielsouzaad/BlogLivingAlone
```

2. Abra no seu IDE (Eclipse, IntelliJ, VSCode com extensão Java)
3. Execute a classe:

```
app/Programa.java
```

---

## 📌 Pontos Fortes do Projeto

* Código organizado por camadas
* Aplicação de interfaces (IBlogService e IUsuarioService)
* Uso de exceções personalizadas
* Pilha para desfazer postagens
* Domínio bem definido

---

## 🔧 Melhorias Futuras

* Criar interface gráfica (JavaFX ou React + API REST)
* Persistência real com banco de dados (MySQL, PostgreSQL ou SQLite)
* Criar testes unitários (JUnit)
* API REST usando Spring Boot

---

## 👨‍💻 Autores

**Fabricio Roberto Oliveira Santos**

GitHub: [fabriciorobertoUnit](https://github.com/fabriciorobertoUnit)

**Gabriel Souza**

GitHub: [gabrielsouzaad](https://github.com/gabrielsouzaad)

**João Gabriel Freire Britto da Silva**

GitHub: [JGabriel18](https://github.com/JGabriel18)

---

