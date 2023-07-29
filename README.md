<img src="https://github.com/ArturWood/games-list/assets/111249818/434c56b3-9dc9-412a-91f7-2edc3f389c14" width=300px alt="Java Logo" />

# OMDB API - Aplicação Java para Consulta de Filmes e Series

Esta é uma aplicação Java que permite consultar informações sobre filmes utilizando a API OMDB (Open Movie Database). A aplicação consome a API para obter dados como título, ano de lançamento, diretor, elenco e avaliação dos filmes.

## Pré-requisitos

- Java Development Kit (JDK) versão 8 ou superior instalado
- IDE Java (como Eclipse ou IntelliJ) ou um editor de texto para escrever o código
- Conexão à internet para consumir a API OMDB
- Chave da API OMDB (API Key)

## Configuração

1. Clone este repositório em sua máquina local:

```bash
# clonar repositório
git clone https://github.com/ArturWood/via-cep.git
```

2. Abra o projeto em sua IDE Java ou editor de texto.

3. Crie sua própria chave da API OMDB seguindo as instruções em: [https://www.omdbapi.com](https://www.omdbapi.com)

4. Renomeie o arquivo `config.properties.example` para `config.properties`.

5. Abra o arquivo `config.properties` e insira sua chave da API OMDB no campo `api.key`.

## Utilização

1. Execute a classe `Main` para iniciar a aplicação.
2. No console, escolha entre buscar um filme ou serie.
3. A aplicação irá consumir a API OMDB e exibir as informações relacionadas ao filme informado, como título, ano de lançamento e avaliação.
4. Ao final das buscas ira ser criado um arquivo `titulos.json` com todos os titulos localizados.

## Estrutura do Projeto

O projeto possui a seguinte estrutura de arquivos:

```bash
├── src
│ ├── main/java
│ ├── com
│ │ └── omdbapi
│ │ ├── auth
│ │ │ └── Authentication.java
│ │ ├── infra
│ │ │ └── FileCreator.java
│ │ ├── model
│ │ │ ├── Movie.java
│ │ │ └── Series.java
│ │ ├── service
│ │ │ ├── MovieService.java
│ │ │ └── SeriesService.java
│ │ └── Main.java
│ │ └── config.properties
└── OMDB.postman_collection.json
└── titulos.json
└── .gitignore
└── pom.xml
```

- O pacote `com.omdbapi.auth` contém a classe `Authentication` que coleta as informações para a autenticação na API OMDB do arquivo `config.properties`.
- O pacote `com.omdbapi.service` contém as classes que realizam as chamadas à API OMDB para obter os dados do filme.
- O pacote `com.omdbapi.model` contém as classes `Movie` e `Series` que representam os dados retornados pela API OMDB.
- A classe `Main` é a classe principal que inicia a aplicação e interage com o usuário.
- O arquivo `.gitignore` especifica os arquivos e pastas que devem ser ignorados pelo controle de versão do Git.
- O arquivo `titulos.json` é gerado automaticamente com as informações dos titulos buscados na API.
- O arquivo `OMDB.postman_collection` é uma coleção do postman para consultas e exemlos de retornos da API OMDB.
- O arquivo `pom.xml` para download das dependencias necessarias para o projeto usando maven.

## Documentação

No projeto foi adicionado o jar externo GSON para facilitar o tratamento das informações JSON, alem do consumo da Web API OMDb;<br>
Segue links para uso e documentação:

https://www.omdbapi.com<br>
https://github.com/google/gson
