# Book API

Aplicação responsável por gerenciar recomendações de livros e suas avaliações

### Ferramentas e Frameworks Utilizados

- Java SE Development Kit ( 8 ou superior) - Obrigatório
- Maven
- Docker (Obrigatório)
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
| MySQL Database           | 3306       | Responsável por Armazenar os dados da API         |
| BookAPI                  | 8080       | Responsável por Gerenciar os Livros                      |
| FrontEnd                 | 4200       | FrontEnd da Aplicação                      |

### Book API

Aplicação Backend construída com Spring Boot responsável por prover os endpoints para a solução frontend.

Documentação do Swagger: http://localhost:8080/swagger-ui.html

<img src="img/swagger.PNG">

### Aplicação Front End

Aplicação FrontEnd construída em Angular 11 responsável por realizar a interação com o usuário final.
Para a pesquisa de livros foi utilizar a API externa do Google Books.

<img src="img/principal.png">
<img src="img/autocomplete.png">

### Monitoramento

Para monitoramento da API foi utilizado Prometheus e Grafana. O Spring Boot expõe as métrica no formato prometheus através do endpoint http://localhost:8080/actuator/prometheus
onde o scrap deste dado é configurado através do arquivo prometheus.yml passado como parâmetro na criação da imagem docker.

Já o Grafana é o responsável por expor esses dados de forma gráfica utilizando o prometheus como datasoruce.

<img src="img/prometheus.PNG">
<img src="img/grafana.PNG">


### Setup Containers

```sh
docker-compose up
```

