# Controllers et API REST

La couche Controller gère les interactions avec le monde extérieur via des endpoints RESTful.

## Standards REST utilisés

- **GET** : Récupérer une ressource (ou une liste).
- **POST** : Créer une nouvelle ressource. Retourne généralement un status `201 Created`.
- **PUT** : Mettre à jour complètement une ressource existante.
- **DELETE** : Supprimer une ressource. Retourne un status `204 No Content`.

## Annotations Clés

- `@RestController` : Combine `@Controller` et `@ResponseBody`.
- `@RequestMapping("/api/...")` : Définit le chemin de base pour l'API.
- `@Valid` : Déclenche la validation des Bean Validation (comme `@NotNull`, `@Email`) définis dans les DTOs.
- `@ResponseStatus` : Permet de définir explicitement le code status HTTP de retour.

## Bonnes Pratiques

1. **Injection par constructeur** : On privilégie l'injection du `Service` via le constructeur plutôt que `@Autowired` sur le champ.
2. **Endpoints clairs** : Utilisation de noms au pluriel (ex: `/api/students`).
3. **Paramètres de chemin (PathVariable)** : Pour identifier une ressource unique par son ID.
