# Credit card service
A service to manage credit cards.

> Use this microservice with the [auth-service](https://github.com/CanseFr/bank-microservice-auth) microservice for authentication.

## Stack
- Java 17 or higher
- Maven 4.0
- Docker

## Installation
```shell
mvn clean install # to build the project
```

## Run
```shell
mvn spring-boot:run
```

## Database

### Start the database
```shell
docker compose up -d
```

### Stop the database
```shell
docker compose down
```

## Main fonctionalities
- Block card
- Unblock card
- Update payment limit
- Update withdraw limit
- Update debit Mode

## API Reference
> Base URL: http://localhost:8080/credit-cards

> Use with Header `Authorization: {token}` on each endpoint

| Method | Path | Parameters | Description |
| --- | --- | --- | --- |
| GET | / | | Get all credit cards |
| POST | / | | Create a new credit card |
| GET | /{id}/block | | Block a credit card |
| GET | /{id}/unblock | | Unblock a credit card |
| PUT | /{id}/payment-limit | limit: double | Update payment limit |
| PUT | /{id}/withdraw-limit | limit: double | Update withdraw limit |
| PUT | /{id}/debit-mode | mode: `IMMEDIATE` | `DEFERRED` | Update debit mode |

## Contact

AHARAG Mariane - [@marianehrg](https://github.com/marianehrg)

AROLDI Romain - [@RomainAROLDI](https://github.com/RomainAROLDI)

BARDINI Kylian - [@kbrdn1](https://github.com/kbrdn1)

DAVID Gremini - [@Davidiums](https://github.com/Davidiums)
