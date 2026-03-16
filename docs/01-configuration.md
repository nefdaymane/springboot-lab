# Étape 1 : Configuration et Dépendances

Ce guide explique comment initialiser le projet et configurer la base de données MySQL ainsi que l'interface Swagger UI.

## 0. Spring Initializr (Initialisation)

Lors de la création du projet sur [start.spring.io](https://start.spring.io), voici les dépendances essentielles à sélectionner :

1.  **Spring Web** : Pour créer des API REST et utiliser Spring MVC.
2.  **Spring Data JPA** : Pour la persistance des données avec Hibernate.
3.  **MySQL Driver** : Pour permettre la connexion à la base de données MySQL.
4.  **Spring Boot Validation** : Pour valider les données entrantes (ex: `@NotNull`, `@Email`).
5.  **Springdoc OpenAPI / Swagger UI** : Pour générer la documentation interactive de l'API.

*Note : La page d'accueil est servie comme une ressource statique (`src/main/resources/static/index.html`).*

---

## 1. Configurer MySQL

### Étape 1 : Ajouter la dépendance
Assurez-vous d'avoir le connecteur MySQL dans votre `pom.xml` :

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

### Étape 2 : Configurer les propriétés
Modifiez le fichier `src/main/resources/application.properties` :

```properties
# URL de connexion (ajustez localhost:3306 et le nom de la BD)
spring.datasource.url=jdbc:mysql://localhost:3306/student_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=VOTRE_MOT_DE_PASSE

# Hibernate / JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
# Dialecte pour MySQL 8+
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

## 2. Configurer Swagger (OpenAPI)

Swagger permet de générer une documentation interactive pour tester vos endpoints directement dans le navigateur.

### Étape 1 : Ajouter la dépendance
Dans le `pom.xml`, ajoutez `springdoc-openapi` :

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.1</version>
</dependency>
```

### Étape 2 : Accéder à l'interface
Une fois l'application lancée, Swagger est disponible à l'adresse suivante :
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Étape 3 (Optionnel) : Personnalisation
Vous pouvez personnaliser le chemin dans `application.properties` :
```properties
springdoc.swagger-ui.path=/api-docs
```

## 3. Injection par Constructeur (Best Practice)

L'injection par constructeur est préférable à l'annotation `@Autowired` sur les champs car elle permet :
1. De rendre les dépendances **immuables** (`final`).
2. De faciliter les **tests unitaires**.
3. De garantir que l'objet est toujours dans un **état valide** après instanciation.

### Exemple dans un Controller :
```java
@RestController
public class StudentController {
    // 1. Déclarer la dépendance comme finale
    private final StudentService studentService;

    // 2. Injecter via le constructeur
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
```
*Note : Depuis Spring 4.3, si une classe n'a qu'un seul constructeur, l'annotation `@Autowired` n'est plus obligatoire sur celui-ci.*
