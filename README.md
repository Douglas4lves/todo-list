<h1 align="center">
  TODO-List
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=LinkedIn&message=seu-endereco-do-linkedin&color=black&labelColor=red" alt="@DouglasAlves" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=black&labelColor=red" alt="Desafio" />
</p>

API para gerenciar tarefas (CRUD)
[desafio](https://github.com/simplify-liferay/desafio-junior-backend-simplify) para pessoas desenvolvedoras backend júnior.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)
- [Java](https://www.oracle.com/java/technologies/)

## Práticas adotadas

- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/downloads/):

- Criar Tarefa 
```
Metodo Post
URL:
$ 127.0.0.1:8080/task 
body:
{
    "name":"Primeira Tarefa",
    "description":"Criando a primeira tarefa",
    "completed":"true",
    "prioridade"="media"
}

[
  {
    "id": 252,
    "name": "Primeira tarefa",
    "description": "criando a primeira tarefa",
    "completed": true,
    "priority": "media"
}
]
```

- Listar Tarefas
```
metodo GET
URL:
$ 127.0.0.1:8080/task

[
  {
    "id": 252,
    "name": "Primeira tarefa",
    "description": "criando a primeira tarefa",
    "completed": true,
    "priority": "media"
   }
]
```

- Atualizar Tarefa
```
metodo PUT / atualizando tarefa com id 1
URL:
$ 127.0.0.1:8080/task/1
{
    "name":"Primeira atualização",
    "description": "testando primeiro metodo put",
    "completed":"true",
    "priority":"alta"
}

[
  {
    "id": 1,
    "name":"Primeira atualização",
    "description": "testando primeiro metodo put",
    "completed":"true",
    "priority":"alta"
  }
]
```

- Remover Tarefa
```
metodo DELETE / removendo tarefa com id 252
URL:
127.0.0.1:8080/task/252
return
{
    Tarefa Deletada
}

[ ]