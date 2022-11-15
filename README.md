# Scraping com Spring

Instalação
----------
É necessário o maven instalado (apt-get install maven)

1. `mvn install` para instalar as dependências
2. `mvn spring-boot:run` para rodar a aplicação
3. Acesse a url: [http://localhost:8080](http://localhost:8080)


Tecnologias
-----------
Java 11, Spring-Boot, Jpa/Hibernate


Descrição:
-----------

  O projeto consiste em desenvolver aplicações com Scraping e Spring.
  
Desenvolvidos:
-----------

### - API para a Buson:

    
    A API da buson busca todas as passagens disponíveis e traz informalções sobre as mesmas.
    
Site da Buson:
-----------

![site_buson](https://github.com/IgorBavand/scraping-com-spring/blob/master/documentacao/site_buson.png)

    
Utilização da API:
-----------

  Após a inicialização do projeto deve-se fazer a requisição da seguinte maneira:
  
  ~~~URL
  localhost:8080/buson
~~~

  Deve ser passado os parâmetros com os nomes abaixo, e com os valores obedecendo o padrao.
  
  - os nomes das cidades devem sem separadas por traço (caso haja espaço), seguido pela sigla do estado. Ex.: (fortaleza-ce)
  
  - As datas devem seguir o padrão: yyyy-MM-dd

Exemplo de Requisição:
-----------
![exemplo_requisicao](https://github.com/IgorBavand/scraping-com-spring/blob/master/documentacao/requisicao_insomnia.png)
