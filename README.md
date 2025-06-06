# API de Países

API REST desenvolvida com Spring Boot para gerenciamento de países, fornecendo funcionalidades CRUD com paginação e busca.

## Tecnologias utilizadas

- Java 17
- Spring Boot 3.4
- PostgreSQL
- Flyway para migrações de banco de dados
- Gradle como sistema de build

## Funcionalidades

- Listar países com paginação
- Filtrar países por nome
- Visualizar detalhes de um país específico
- Cadastrar novos países
- Atualizar informações de países existentes
- Excluir países

## Estrutura do projeto

- Arquitetura em camadas (Controller, Service, Repository)
- DTOs para transferência de dados
- Validação de dados
- Migrations com Flyway para versionamento do banco

## Como executar localmente

1. Clone o repositório
2. Configure o PostgreSQL e crie um banco de dados chamado `paises_db`
3. Configure as credenciais do banco no `application.properties`
4. Execute a aplicação: `./gradlew bootRun`
5. Acesse a API em: http://localhost:8080/api/paises


![Em execução](https://i.ibb.co/NBVxFKx/Screenshot-2025-05-15-115547.png)

## Frontend

Este projeto conta com um frontend desenvolvido em React, disponível em https://github.com/Dry-A/paises-api-frontend.

![Front-end](https://i.ibb.co/7xfjMjdF/Screenshot-2025-05-15-120452.png)

## Endpoints disponíveis

- `GET /api/paises` - Lista todos os países (suporta paginação e filtro por nome)
- `GET /api/paises/{id}` - Obtém detalhes de um país específico
- `POST /api/paises` - Cadastra um novo país
- `PUT /api/paises/{id}` - Atualiza informações de um país
- `DELETE /api/paises/{id}` - Remove um país