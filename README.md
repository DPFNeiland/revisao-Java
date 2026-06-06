# Gabarito - API de Submissão de Atividades Acadêmicas

Projeto didático em **Java + Spring Boot + Maven**, criado como gabarito para uma avaliação prática envolvendo:

- Programação Orientada a Objetos
- Spring Boot
- REST
- Spring Data JPA
- H2 Database
- DTO
- Value Object
- DDD
- Clean Architecture em camadas
- CORS
- Swagger

---

## 1. Contexto do Projeto

Uma instituição de ensino deseja controlar a submissão de atividades acadêmicas.

O sistema possui três entidades principais:

- **Estudante**
- **Atividade**
- **Submissão**

Um estudante pode enviar uma atividade. A submissão pode ser avaliada posteriormente pelo professor.

---

## 2. Estrutura do Projeto

```text
src/main/java/br/com/escola/submissao
│
├── domain
│   ├── entity
│   │   ├── Estudante.java
│   │   ├── Atividade.java
│   │   └── Submissao.java
│   ├── valueobject
│   │   ├── Email.java
│   │   └── Nota.java
│   └── enums
│       └── StatusSubmissao.java
│
├── application
│   └── service
│       ├── EstudanteService.java
│       ├── AtividadeService.java
│       └── SubmissaoService.java
│
├── infrastructure
│   └── repository
│       ├── EstudanteRepository.java
│       ├── AtividadeRepository.java
│       └── SubmissaoRepository.java
│
├── interfaces
│   ├── controller
│   │   ├── EstudanteController.java
│   │   ├── AtividadeController.java
│   │   ├── SubmissaoController.java
│   │   └── ApiExceptionHandler.java
│   └── dto
│       ├── CriarEstudanteRequest.java
│       ├── CriarAtividadeRequest.java
│       ├── CriarSubmissaoRequest.java
│       ├── AvaliarSubmissaoRequest.java
│       └── SubmissaoResponse.java
│
└── config
    └── CorsConfig.java
```

---

## 3. Como Abrir no IntelliJ

1. Abra o IntelliJ IDEA.
2. Clique em **Open**.
3. Selecione a pasta do projeto `gabarito-submissao-atividades`.
4. Aguarde o Maven baixar as dependências.
5. Execute a classe:

```text
SubmissaoAtividadesApplication.java
```

---

## 4. Como Executar via Terminal

Na raiz do projeto, execute:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```text
http://localhost:8080
```

---

## 5. Swagger

A documentação da API pode ser acessada em:

```text
http://localhost:8080/swagger-ui.html
```

---

## 6. Console H2

O console do banco H2 pode ser acessado em:

```text
http://localhost:8080/h2-console
```

Configuração:

```text
JDBC URL: jdbc:h2:mem:escola
User: sa
Password: deixe em branco
```

---

## 7. Endpoints

### 7.1 Criar Estudante

```http
POST /api/estudantes
```

Body:

```json
{
  "nome": "Ana Silva",
  "email": "ana@email.com"
}
```

---

### 7.2 Listar Estudantes

```http
GET /api/estudantes
```

---

### 7.3 Criar Atividade

```http
POST /api/atividades
```

Body:

```json
{
  "titulo": "Projeto de POO",
  "descricao": "Implementar uma API REST com Spring Boot",
  "dataLimite": "2026-06-30"
}
```

---

### 7.4 Listar Atividades

```http
GET /api/atividades
```

---

### 7.5 Criar Submissão

```http
POST /api/submissoes
```

Body:

```json
{
  "estudanteId": 1,
  "atividadeId": 1
}
```

A submissão será criada automaticamente com:

```text
status = ENVIADA
dataEnvio = data e hora atuais
```

---

### 7.6 Listar Submissões

```http
GET /api/submissoes
```

---

### 7.7 Buscar Submissão por ID

```http
GET /api/submissoes/1
```

---

### 7.8 Avaliar Submissão

```http
PUT /api/submissoes/1/avaliar
```

Body:

```json
{
  "nota": 8.5,
  "comentarioProfessor": "Boa organização do código e uso adequado das camadas."
}
```

Após a avaliação, o status muda para:

```text
AVALIADA
```

---

## 8. Regras de Negócio

- O estudante deve possuir nome e e-mail válido.
- O e-mail é representado por um Value Object chamado `Email`.
- A atividade deve possuir título.
- A submissão só pode ser criada se o estudante e a atividade existirem.
- A nota deve estar entre 0 e 10.
- A nota é representada por um Value Object chamado `Nota`.
- A avaliação exige comentário do professor.
- Ao avaliar uma submissão, o status muda para `AVALIADA`.

---

## 9. Pontos Didáticos Avaliados

Este projeto demonstra:

- Entidades JPA com `@Entity`.
- Relacionamentos `@ManyToOne` e `@OneToMany`.
- DTOs com `record`.
- Value Objects com `@Embeddable` e `@Embedded`.
- Repositories com `JpaRepository`.
- Services com regras de aplicação.
- Controllers REST.
- Tratamento simples de exceções.
- Configuração de CORS.
- Banco H2 em memória.
- Swagger para documentação.

---

## 10. Observação Pedagógica

O objetivo deste gabarito não é apresentar a única solução possível, mas uma solução organizada e didática.

Em uma avaliação, o aluno pode ter pequenas variações de nomes de classes, pacotes ou endpoints, desde que respeite os princípios principais:

- Separação de responsabilidades.
- Domínio organizado.
- DTOs para entrada e saída.
- Regras fora do Controller.
- Persistência funcionando com H2.
