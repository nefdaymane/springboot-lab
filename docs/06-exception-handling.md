# Gestion des Exceptions

La gestion centralisée des erreurs est essentielle pour fournir des réponses cohérentes au client.

## Le Global Exception Handler

Nous utilisons `@RestControllerAdvice` dans la classe `GlobalExceptionHandler` pour intercepter les exceptions jetées par n'importe quel controller.

## Format de Réponse : ProblemDetail

Conformément aux standards modernes (RFC 7807), nous retournons un objet `ProblemDetail`. Il contient :
- **Status** : Le code HTTP (404, 400, 500, etc.).
- **Title** : Un résumé court de l'erreur.
- **Detail** : Une explication plus longue (souvent le message de l'exception).

## Exceptions Gérées

1. **ResourceNotFoundException** (404) : Jetée quand un ID ou une ressource demandée n'existe pas.
2. **MethodArgumentNotValidException** (400) : Capturée automatiquement par Spring lors de l'échec de la validation `@Valid`. Elle permet de renvoyer les erreurs de saisie à l'utilisateur.
3. **DuplicateResourceException** (409) : Utilisée lors de conflits d'unicité (ex: email déjà utilisé).
4. **Exception Générique** (500) : Un garde-fou pour capturer toutes les erreurs imprévues.
