# Projeto Computação Orientada a Serviços

Este repositório contém a atividade prática da disciplina de Computação Orientada a Serviços (UNITINS). O projeto consiste na transformação de um monolito em uma arquitetura baseada em microsserviços, utilizando Java e Spring Boot.

## Arquitetura

O projeto foi dividido em dois microsserviços independentes, cada um com seu próprio banco de dados isolado:

* **`ms-disciplina`**: Roda na porta **8081** e gerencia o domínio de disciplinas (Banco H2: `disciplinadb`).
* **`ms-tarefa`**: Roda na porta **8082** e gerencia as tarefas, comunicando-se via HTTP (RestTemplate) com o microsserviço de disciplinas (Banco H2: `tarefadb`).

## Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.x**
* **Spring Data JPA**
* **H2 Database** (Em memória)
* **Docker & Docker Compose** (Orquestração e Multi-stage build)
* **Bruno** (Testes de API)

## Como Executar o Projeto

Com o Docker instalado e rodando na máquina:

1. Clone o repositório:
   ```bash
   git clone [https://github.com/FernandoUnitins/projeto-cos.git](https://github.com/FernandoUnitins/projeto-cos.git)
   cd projeto-cos
   ```

2. Suba os microsserviços utilizando o Docker Compose:
   ```bash
   docker compose up --build
   ```

3. O ambiente estará disponível nas seguintes URLs:
   
   Disciplinas: http://localhost:8081/disciplinas
   
   Tarefas: http://localhost:8082/tarefas
   
   Para derrubar a infraestrutura, utilize docker compose down.

## Como testar
Os arquivos de teste de integração da API estão localizados na pasta Atividade Aula 11/. Você pode importar essa pasta diretamente no aplicativo Bruno para executar as requisições de criação e listagem automaticamente.