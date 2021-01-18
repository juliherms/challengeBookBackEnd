# Book API

Aplicação responsável por gerenciar recomendações de livros e suas avaliações

### Ferramentas e Frameworks Utilizados

- Java SE Development Kit ( 8 ou superior) - Obrigatório
- Maven
- Docker
- ModelMapper
- Swagger
- Prometheus
- Grafana
- RestAssured
- MySQL
- Lombok

### Serviçõs Envolvidos

| Serviço                  | Porta      | Descrição                                         |
|--------------------------|------------|---------------------------------------------------|
| Prometheus               | 9090       | Responsável por capturar as métricas da API(Observabilidade)  |
| Grafana                  | 3000       | Responsável por exeibir de forma gráficas as métricas capturadas                        | 
| MySQL Database           | 5432       | Responsável por Armazenar os dados da API         |
| BookAPI                  | 8080       | Responsável por Gerenciar os Livros                      |
| FrontEnd                 | 4200       | FrontEnd da Aplicação                      |

### Book API

Documentação do Swagger: http://localhost:8080/swagger-ui.html

<img src="img/swagger.PNG">

### Aplicação Front End

<img src="img/principal.PNG">
<img src="img/autocomplete.PNG">


### Setup Containers

```sh
docker-compose up
```

