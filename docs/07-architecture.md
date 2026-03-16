# Architecture du Projet

Ce projet suit une architecture **N-tier** (multicouche) classique, ce qui permet une séparation claire des responsabilités, une meilleure testabilité et une maintenance facilitée.

## Les Couches de l'Application

### 1. Couche Présentation (Controller)
- **Rôle** : Reçoit les requêtes HTTP, valide les entrées et retourne les réponses.
- **Localisation** : `org.lab.springboot.controller`
- **Principes** : Utilise `@RestController` et `@RequestMapping`. Les données transitent via des **DTOs**.

### 2. Couche Service (Business Logic)
- **Rôle** : Contient la logique métier de l'application. Elle orchestre les appels aux repositories et les transformations de données.
- **Localisation** : `org.lab.springboot.service`
- **Principes** : Annotée avec `@Service`. C'est ici que l'on gère les transactions et les règles métier complexes.

### 3. Couche Accès aux Données (Repository)
- **Rôle** : Interface entre l'application et la base de données.
- **Localisation** : `org.lab.springboot.repository`
- **Principes** : Étend `JpaRepository` pour bénéficier des opérations CRUD standards.

### 4. Couche Modèle (Entity)
- **Rôle** : Représente les tables de la base de données.
- **Localisation** : `org.lab.springboot.entity`
- **Principes** : Annotée avec `@Entity` et `@Table`.

## Flux de Données

1. Le client envoie une requête HTTP (ex: POST `/api/students`).
2. Le `Controller` reçoit un `RequestDTO`.
3. Le `Controller` appelle le `Service`.
4. Le `Service` utilise un `Mapper` pour convertir le `RequestDTO` en `Entity`.
5. Le `Service` appelle le `Repository` pour sauvegarder l' `Entity`.
6. Le `Repository` persiste les données en base de données.
7. Le `Service` récupère l' `Entity` sauvegardée, la convertit en `ResponseDTO` via le `Mapper`.
8. Le `Controller` renvoie le `ResponseDTO` au client.
