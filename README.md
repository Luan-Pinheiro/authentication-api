# 🔐 Authentication API

API de autenticação e autorização desenvolvida em Java com Spring Boot. O projeto permite o registro de usuários, login com geração de JWT e proteção de rotas. Também possui integração com banco de dados PostgreSQL e controle de versões com Flyway.

---

## 🚀 Tecnologias e Dependências

- Java 21
- Spring Boot 3.4.5
  - Spring Web
  - Spring Security
  - Spring DATA Jpa
  - Spring Validation
- Flyway
- PostgreSQL Driver
- Lombok
- Swagger/OpenAPI
- Java JWT
- Spring Boot DevTools

---

## 🧪 Funcionalidades

- ✅ Registro de usuários (`/auth/register`)
- ✅ Autenticação de usuários (`/auth/login`)
- ✅ Geração e validação de JWT
- ✅ Proteção de endpoints com filtro de segurança
- ✅ Criação e listagem de produtos autenticados
- ✅ Documentação com Swagger/OpenAPI
- ✅ Migração de banco com Flyway

---

## 📚 Acessando o Swagger
Após rodar a aplicação, documentação da API disponível em:
http://localhost:8080/swagger-ui.html