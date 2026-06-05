# 📚 Biblioteca API

API REST desenvolvida com Spring Boot para gerenciamento de usuários, livros e empréstimos de uma biblioteca.

## 🚀 Tecnologias

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 Database
* Lombok
* Swagger/OpenAPI
* Maven

---

## 📋 Funcionalidades

### Usuários

* Criar usuário
* Listar usuários
* Buscar usuário por ID
* Atualizar usuário
* Excluir usuário

### Livros

* Cadastrar livro
* Listar livros
* Buscar livro por ID
* Atualizar livro
* Excluir livro

### Empréstimos

* Registrar empréstimo
* Registrar devolução
* Listar empréstimos
* Controle de disponibilidade dos livros

---

## 🏗 Estrutura do Projeto

```text
src/main/java
├── controllers
├── services
├── repository
├── dto
├── exceptions
├── infra/entity
└── config
```

---

## 💾 Banco de Dados

O projeto utiliza H2 Database em memória.

Acesse:

```text
http://localhost:8080/h2-console
```

Configuração padrão:

```text
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```

---

## 📖 Documentação da API

Swagger disponível em:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 🔧 Executando o Projeto

Clone o repositório:

```bash
git clone https://github.com/SEU-USUARIO/biblioteca.git
```

Entre na pasta:

```bash
cd biblioteca
```

Execute:

```bash
mvn spring-boot:run
```

---

## 📌 Exemplos de Requisições

### Criar Usuário

```http
POST /usuarios
```

```json
{
  "login": "daniel",
  "email": "daniel@email.com"
}
```

### Criar Livro

```http
POST /livros
```

```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "isbn": "9780132350884"
}
```

### Criar Empréstimo

```http
POST /emprestimos
```

```json
{
  "usuarioId": 1,
  "livroId": 1
}
```

### Devolver Livro

```http
PUT /emprestimos/1/devolver
```

---

## 🎯 Objetivo

Projeto criado para estudo e prática de:

* Spring Boot
* APIs REST
* JPA/Hibernate
* DTOs
* Tratamento de exceções
* Documentação com Swagger

---

## 👨‍💻 Autor

Daniel Seabra
