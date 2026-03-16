# Spring Boot Laboratory - Gestion des Étudiants et Filières

Bienvenue dans ce projet Spring Boot qui sert de laboratoire pour mettre en œuvre les meilleures pratiques de développement backend Java moderne.

## 🚀 Objectif du Projet

Ce projet est conçu pour gérer des étudiants et leurs filières respectives. Il met en lumière les principes fondamentaux de l'architecture logicielle, du mapping de données et de la gestion des API REST.

## 📁 Structure du Projet

L'organisation des fichiers suit les conventions Spring Boot standards :

```
src/main/java/org/lab/springboot/
├── controller/     # Points d'entrée de l'API (REST Controllers)
├── dto/            # Objets de transfert de données (Request/Response)
├── entity/         # Modèles de données JPA (Persistent Entities)
├── exception/      # Gestion globale des erreurs
├── mapper/         # Conversion entre Entities et DTOs
├── repository/     # Interfaces d'accès à la base de données (Spring Data JPA)
└── service/        # Logique métier et orchestrateur
```

## 📘 Guide d'Apprentissage Step-by-Step

Pour comprendre le projet dans l'ordre logique de développement, suivez ces guides :

1. [**Étape 1 : Configuration**](docs/01-configuration.md) - Setup MySQL, Swagger et dépendances initiales.
2. [**Étape 2 : Modèle de Données**](docs/02-entities.md) - Création des entités JPA et définition des relations.
3. [**Étape 3 : Transfert de Données (DTO/Mappers)**](docs/03-dto-mappers.md) - Isolation de l'API et conversion d'objets.
4. [**Étape 4 : Logique Métier & Injection**](docs/04-services-injection.md) - Services, injection par constructeur et business logic.
5. [**Étape 5 : API REST & Controllers**](docs/05-api-controllers.md) - Exposition des endpoints et standards REST.
6. [**Étape 6 : Gestion des Erreurs**](docs/06-exception-handling.md) - Centralisation des exceptions et format ProblemDetail.
7. [**Étape 7 : Architecture Globale**](docs/07-architecture.md) - Vue d'ensemble de la structure N-tier du projet.

## ✨ Bonnes Pratiques Implémentées

- **Separation of Concerns** : Chaque couche a une responsabilité unique.
- **DTO Pattern** : Isolation complète entre la base de données et le client.
- **Constructor Injection** : Dépendances immuables et tests unitaires facilités.
- **Validation** : Intégrité des données via Bean Validation.
- **Exceptions Globales** : Réponses uniformes via `@RestControllerAdvice`.

## 🛠️ Technologies Utilisées

- Java 17+
- Spring Boot 3
- MySQL (Connector J)
- Spring Data JPA
- Swagger UI (SpringDoc OpenAPI)
- Maven

---
*Projet réalisé dans un but pédagogique pour illustrer une structure backend robuste et scalable.*
