🏦 BankAPI

API REST para simulação de um sistema bancário, desenvolvida em Java com Spring Boot, com foco em boas práticas, segurança com JWT e arquitetura em camadas.

O projeto permite:

Cadastro e autenticação de usuários

Criação de contas bancárias

Depósitos em conta

Registro de transações

Controle de acesso via Spring Security + JWT

🛠️ Tecnologias utilizadas

Java 21

Spring Boot

Spring Security

JWT (JSON Web Token)

Spring Data JPA

Hibernate

Banco de dados: H2 / PostgreSQL

Maven

Lombok

🔐 Autenticação

A API utiliza JWT para autenticação.

Fluxo:

Usuário se cadastra

Usuário faz login

Recebe um token JWT

Envia o token no header:

Authorization: Bearer SEU_TOKEN_AQUI

📌 Endpoints
🔑 Autenticação
➕ Registrar usuário

POST /api/auth/register

{
  "name": "Ariel Melo",
  "email": "ariel@email.com",
  "password": "123456",
  "cpf": "12345678900"
}

🔓 Login

POST /api/auth/login

{
  "email": "ariel@email.com",
  "password": "123456"
}


Resposta:

{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}

🏦 Conta bancária
➕ Criar conta

POST /api/accounts

Header:

Authorization: Bearer TOKEN

{
  "agency": "0001",
  "accountNumber": "123456-7"
}


Resposta:

{
  "id": "e8c223cc-90be-4984-8163-89b0874ca3f1",
  "accountNumber": "123456-7",
  "agency": "0001",
  "balance": 0
}

💰 Depósito
➕ Realizar depósito

POST /api/deposits

Header:

Authorization: Bearer TOKEN

{
  "accountId": "e8c223cc-90be-4984-8163-89b0874ca3f1",
  "amount": 150.00
}


Resposta:

{
  "message": "Depósito realizado com sucesso"
}

📊 Transações

Cada depósito gera automaticamente um registro de transação, permitindo no futuro:

Extrato bancário

Histórico de movimentações

Auditoria financeira

🧱 Estrutura do projeto
com.ArielMelo.bankapi
 ┣ controllers
 ┣ services
 ┣ repositories
 ┣ entities
 ┣ dtos
 ┣ enums
 ┣ security

🚀 Como rodar o projeto
git clone https://github.com/MeloAri/BankApi.git
cd BankApi
mvn spring-boot:run


A API sobe em:

http://localhost:8080

🎯 Objetivo do projeto

Este projeto foi desenvolvido com foco em:

Aprendizado prático de Spring Boot

Implementação real de JWT

Simulação de regras de negócio bancárias

Construção de uma API pronta para evoluir com:

Saques

Transferências

Extratos

Limites

Perfis de usuário

👨‍💻 Autor

Ariel Melo
Desenvolvedor em evolução 🚀
Projeto criado para estudo, portfólio e prática de arquitetura back-end.
