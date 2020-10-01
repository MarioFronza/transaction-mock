<h1 align="center">
  Transaction Mock 
  <br>
</h1>

<p align="center">API mock para listagem de transações fakes</p>

<hr />

### Requisição
```http
[GET] /<id>/transacoes/<ano>/<mes>
```

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `id` | `number` | **required**. id do usuário |
| `ano` | `number` | **required**. ano da transação |
| `mes` | `number` | **required**. mês da transação |


### Resposta
```javascript
[
  {
     "descricao": "string(10, 120)"
     "data": "long(timestamp)"
     "valor": "integer(-9.999.999, 9.999.999)"
     "duplicated": "boolean"
  }  
]
```

### Instruções de uso do software
Requisitos:

- [Docker](https://www.docker.com/)

Clonar o projeto executando os seguintes comandos:

- git clone https://github.com/MarioFronza/transaction-mock.git
- cd transaction-mock

Com o projeto clonado, dentro da pasta execute a aplicação com os comandos:

- docker build -t transaction-mock .  
- docker run -p 8080:8080 transaction-mock 