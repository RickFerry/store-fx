### README para o Repositório "store-fx"

# Store FX

Este projeto é uma aplicação JavaFX que simula uma vitrine de loja, permitindo aos usuários visualizar e interagir com produtos, carrinho de compras e realizar confirmações de compras. Além disso, a aplicação integra com a API do Twitter para exibir tweets relacionados.

## Funcionalidades

- **Login**: Autenticação de usuário.
- **Catálogo de Produtos**: Visualização de produtos disponíveis.
- **Carrinho de Compras**: Adição e remoção de produtos do carrinho.
- **Confirmação de Compra**: Processo de confirmação de compra com feedback visual.
- **Integração com Twitter**: Exibição de tweets utilizando a API do Twitter.

## Tecnologias Utilizadas

- JavaFX
- Twitter4j (biblioteca para integração com a API do Twitter)
- Maven (gerenciamento de dependências)

## Pré-requisitos

- JDK 11 ou superior
- Maven 3.6.3 ou superior

## Configuração

1. **Clone o Repositório**
   ```sh
   git clone https://github.com/RickFerry/store-fx.git
   cd store-fx
   ```

2. **Configuração da API do Twitter**
   - Crie uma aplicação no [Twitter Developers](https://developer.twitter.com/) para obter as chaves de autenticação.
   - Substitua as seguintes chaves no método `getTweets()` em `VitrineApp`:
     ```java
     twitter.setOAuthConsumer("meu_consumer_key", "meu_consumer_secret");
     twitter.setOAuthAccessToken(new AccessToken("meu_access_token", "meu_access_token_secret"));
     ```

3. **Construir e Executar a Aplicação**
   ```sh
   mvn clean install
   mvn javafx:run
   ```

## Estrutura do Projeto

```plaintext
store-fx/
│
├── .mvn/              # Arquivos de configuração do Maven
├── src/               # Código-fonte da aplicação
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── storefx/
│   │   │           ├── LoginApplication.java
│   │   │           ├── LoginController.java
│   │   │           ├── VitrineApp.java
│   │   │           └── ...
│   │   └── resources/
│   │       └── com/
│   │           └── storefx/
│   │               ├── login.fxml
│   │               └── ...
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml            # Arquivo de configuração do Maven
```

## Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`).
3. Faça commit das suas mudanças (`git commit -m 'Add some AmazingFeature'`).
4. Faça o push para a branch (`git push origin feature/AmazingFeature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

Ricardo Ferreira - [seu.email@example.com](ricardo.martins18@fatec.sp.gov.br)

LinkedIn: [linkedin.com/in/ricardo-ferreira]([https://www.linkedin.com/in/ricardo-ferreira](https://www.linkedin.com/in/ricardo-ferreira-martins-9a688214b/))

---
