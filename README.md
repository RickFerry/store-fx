# Store FX

Store FX is a JavaFX application that simulates a store front, allowing users to view and interact with products, manage their shopping cart, and complete purchase confirmations. It also integrates with the Twitter API to display related tweets.

## Features

- **User Authentication:** Login functionality.
- **Product Catalog:** View available products.
- **Shopping Cart:** Add and remove products from the cart.
- **Purchase Confirmation:** Visual feedback for purchase confirmation.
- **Twitter Integration:** Display tweets using the Twitter API.

## Technologies Used

- **JavaFX**
- **Twitter4j** (for Twitter API integration)
- **Maven** (for dependency management)

## Prerequisites

- **JDK 11** or higher
- **Maven 3.6.3** or higher

## Setup

1. **Clone the Repository:**
    ```sh
    git clone https://github.com/RickFerry/store-fx.git
    cd store-fx
    ```

2. **Configure Twitter API:**
   - Create an application on [Twitter Developers](https://developer.twitter.com) to get authentication keys.
   - Replace the placeholder keys in `VitrineApp`:
     ```java
     twitter.setOAuthConsumer("your_consumer_key", "your_consumer_secret");
     twitter.setOAuthAccessToken(new AccessToken("your_access_token", "your_access_token_secret"));
     ```

3. **Build and Run the Application:**
    ```sh
    mvn clean install
    mvn javafx:run
    ```

## Project Structure

```plaintext
store-fx/
├── .mvn/              # Maven configuration files
├── src/               # Source code
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
└── pom.xml            # Maven configuration file
```

## Contributing

1. Fork the project.
2. Create a new branch for your feature (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

**Ricardo Ferreira**
- Email: [ricardo.martins18@fatec.sp.gov.br](mailto:ricardo.martins18@fatec.sp.gov.br)
- LinkedIn: [Ricardo Ferreira](https://www.linkedin.com/in/ricardo-ferreira-martins-9a688214b/)

---
