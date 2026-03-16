# DTOs et Mappers

Le pattern DTO (Data Transfer Object) est crucial pour séparer le modèle de données interne (Entities) de l'API externe.

## Pourquoi utiliser des DTOs ?

1. **Sécurité** : Ne pas exposer de champs sensibles (mot de passe, IDs internes).
2. **Performance** : N'envoyer que les données nécessaires au client.
3. **Découplage** : Permet de modifier la structure de la base de données sans casser le contrat de l'API.

## Structure dans le Projet

### RequestDTO
Utilisé pour les opérations de création et de mise à jour (ex: `StudentRequestDTO`). Souvent implémenté sous forme de `record` Java pour la concision et l'immutabilité.

### ResponseDTO
Utilisé pour renvoyer les données au client (ex: `StudentResponseDto`). Il peut aplatir des relations complexes (ex: renvoyer juste le nom de la filière au lieu de l'objet complet).

## Les Mappers

Les mappers sont responsables de la conversion entre Entities et DTOs.

- **Localisation** : `org.lab.springboot.mapper`
- **Implémentation** : Dans ce projet, nous utilisons des mappers manuels annotés avec `@Component`.
- **Méthodes clés** :
  - `toEntity()` : Convertit une requête en entité.
  - `toResponseDTO()` : Prépare l'objet pour la réponse API.
  - `updateEntityFromDto()` : Met à jour une entité existante à partir d'un DTO sans créer de nouvel objet.
