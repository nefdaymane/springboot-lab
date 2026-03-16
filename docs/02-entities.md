# Entités et Relations (JPA)

Les entités sont le cœur du modèle de données de l'application. Elles utilisent JPA (Java Persistence API) pour faire le lien avec la base de données relationnelle.

## Entités Principales

### Student (Étudiant)
- **ID** : Auto-incrémenté (`GenerationType.IDENTITY`).
- **Champs** : `firstName`, `lastName`, `email` (unique), `age`.
- **Relation** : Plusieurs étudiants appartiennent à une seule filière (`@ManyToOne`).

### Filiere (Filière)
- **ID** : Auto-incrémenté.
- **Champs** : `name`, `code`.
- **Relation** : Une filière peut avoir plusieurs étudiants (`@OneToMany`).

## Bonnes Pratiques Appliquées

1. **Validation au niveau de la base** : Utilisation de `nullable = false` et `unique = true` dans l'annotation `@Column`.
2. **Constructeurs** : Présence d'un constructeur par défaut (requis par JPA) et d'un constructeur complet pour faciliter les tests.
3. **Encapsulation** : Tous les champs sont `private` avec des `getters` et `setters` publics.
4. **Naming Convention** : Les noms de tables sont au pluriel (ex: `students`) pour les distinguer des classes.
