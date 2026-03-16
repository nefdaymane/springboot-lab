# Services et Injection de Dépendances

La couche Service (`@Service`) contient la logique métier de l'application. Elle agit comme un pont intelligent entre les Controllers et les Repositories.

## 🛠️ Injection par Constructeur (Best Practice)

Dans ce projet, nous utilisons l'**injection par constructeur** pour gérer les dépendances. C'est la recommandation officielle de Spring pour plusieurs raisons :

1.  **Immuabilité** : Les dépendances peuvent être déclarées `final`, garantissant qu'elles ne seront pas modifiées après l'initialisation.
2.  **Tests Simples** : On peut facilement instancier le service dans un test unitaire en passant des "Mocks" au constructeur sans avoir besoin de démarrer un contexte Spring lourd.
3.  **Zéro NullPointerException** : Spring ne peut pas créer le bean si une dépendance est manquante, ce qui évite les erreurs au moment de l'exécution.

```java
@Service
public class StudentService {
    // Déclarées final pour l'immuabilité
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    // Un seul constructeur : @Autowired est implicite
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
}
```

## Responsabilités du Service

1. **Orchestration** : Il appelle les repositories pour récupérer des données et les mappers pour transformer les objets.
2. **Validation Métier** : Au-delà de la validation syntaxique (faite dans le DTO), le service vérifie les règles métier (ex: "l'email doit être unique", "la filière doit exister").
3. **Gestion des Exceptions Métier** : Si une règle n'est pas respectée, le service jette une exception personnalisée (ex: `ResourceNotFoundException`, `DuplicateResourceException`).
4. **Transactions** : Bien que non explicite ici, c'est au niveau service que l'on définit généralement les limites transactionnelles avec `@Transactional`.

## Exemple de flux dans `addStudent()`

1. **Recherche de dépendance** : Vérifie si la `Filiere` existe via `filiereRepository.findById()`.
2. **Contrainte d'unicité** : Vérifie si l'email n'est pas déjà utilisé via `existsByEmail()`.
3. **Transformation** : Convertit le `RequestDTO` en `Student` (Entity) via le mapper.
4. **Association** : Lie l'étudiant à sa filière.
5. **Persistance** : Sauvegarde via `studentRepository.save()`.
6. **Retour** : Re-convertit l'entité sauvegardée en `ResponseDTO` pour le controller.

## Pourquoi ne pas mettre la logique dans le Controller ?

Le Controller doit rester "fin" (thin controller). Il ne doit s'occuper que de HTTP. Mettre la logique dans le Service permet de :
- Réutiliser la logique dans d'autres parties de l'application (ex: une tâche planifiée ou une autre API).
- Faciliter les tests unitaires (on peut tester le service sans simuler de requêtes HTTP).
