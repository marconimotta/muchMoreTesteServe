# muchMoreTesteServe

Tecnologias usadas:
 - Java 1.8
 - Spring Boot
 - Maven
 - MongoDB
 
 Para rodar a API é necessário criar o database e as collections.
 Database: muchmore-filmes
 Collections: genre, movie, movie-theater
 
 Endpoints disponíveis: 
    GET
  * /movieTheater/list - Lista todos os cinemas disponíveis junto com seus filmes em cartaz
  * /movieTheater/{id} - Retonar o cinema pelo Id
  * /genre/list/count/nowPlaying - Retorna todos os Gêneros de filmes com a quantidade de filmes em cartaz que se enquadre em
  cada Gênero.
  
  POST
  * /movieTheater/ - Cria um cinema
  * /genre/import - Endpoint para importar o gêneros de filmes da API MovieDB
  
  PUT
  * /movieTheater/ - Atualiza um cinema
  
  DELETE
  * /movieTheater/{id} - Remove um cinema pelo Id
 
