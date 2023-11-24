# 🚀  API Games
>Responsável por criar uma lista de jogos no banco de dados
> 
>Responsável por criar um jogo no banco de dados
> 
>Responsável por buscar uma lista de jogos do banco de dados
> 
>Responsável por buscar um jogo por id no banco de dados



## ⚒️ Endpoints:
**/games/saveList** - Endpoint responsável por salvar uma lista de jogos do banco de dados

`POST -> http://localhost:9090/games/saveList`

> Formato da lista para body JSON:
[
{
"img": "xpto",
"title": "game2",
"star": "1",
"reviews": "2",
"prevPrice": "500",
"newPrice": "250.50",
"company": "jogo",
"consoleType": "vipe",
"category": "ação"
},
{
"img": "xpto",
"title": "game3",
"star": "1",
"reviews": "2",
"prevPrice": "710",
"newPrice": "300.50",
"company": "jogo5",
"consoleType": "vipe2",
"category": "ação"
}
]

**/games/saveOne** - Endpoint responsável por salvar um jogo no banco de dados

`POST -> http://localhost:9090/games/saveOne`

>{
"img": "xpto",
"title": "game1",
"star": "1",
"reviews": "2",
"prevPrice": "200",
"newPrice": "250.50",
"company": "jogo",
"consoleType": "vipe",
"category": "ação"
}
> 
**/games/findAll** - Endpoint responsável por buscar uma lista de jogos no banco de dados

`GET -> http://localhost:9090/games/findAll`

**/games/find/{id}** - Endpoint responsável por buscar um jogo por id no banco de dados

`GET -> http://localhost:9090/games/find/{id}`

## 💻 Configurando o banco de dados MySQL ##
> Server Host: localhost 
> 
> Port: 3306
> 
> Database: games
>
> Username: user
> 
> Password: password
> 
> Server Time Zone: Auto-detect


## 🏃 Como rodar o projeto localmente

1. Configure o Java 17 no seu PC
2. Rode o comando maven para instalar as dependências:
   `mvn clean install`
2. Rode o comando docker no terminal para subir as imagens:
   `docker-compose up`
3. Rode o comando maven para rodar o projeto:
      `mvn spring-boot:run`
4. Acesse a conexão MySQL com DBeaver 
5. Rode o endpoint listado nesse readme