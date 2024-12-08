# CalculatorException.java - Documentation technique

## Vue d'ensemble
La classe `CalculatorException` est une exception personnalisée dédiée à gérer les erreurs spécifiques de l'application de calculatrice. En étendant la classe `Exception`, elle permet de différencier les erreurs liées aux opérations de calcul des autres exceptions générales, facilitant ainsi la gestion et le débogage des problèmes.

## Points pédagogiques clés

### 1. Création d'exceptions personnalisées
- **Spécificité** : Permet de définir des exceptions qui reflètent précisément les erreurs possibles dans le contexte de la calculatrice (par exemple, division par zéro, entrées invalides).
- **Clarté** : Facilite la compréhension des sources d'erreur en rendant les messages plus explicites et pertinents.

### 2. Héritage et constructeurs
- **Héritage** : En héritant de la classe `Exception`, `CalculatorException` bénéficie des fonctionnalités standard des exceptions en Java tout en ajoutant une spécificité propre à l'application.
- **Constructeurs multiples** :
  - **Avec message** : Permet de fournir un message descriptif de l'erreur.
    ```java
    public CalculatorException(String message) {
        super(message);
    }
    ```
  - **Avec message et cause** : Permet de chaîner des exceptions en fournissant à la fois un message descriptif et une cause sous-jacente.
    ```java
    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }
    ```

## Composants techniques principaux

### 1. Constructeur avec message
Ce constructeur permet de créer une exception avec un message d'erreur spécifique, informant l'utilisateur ou le développeur de la nature de l'erreur.
```java
public CalculatorException(String message) {
    super(message);
}
```

### 2. Constructeur avec message et cause
Ce constructeur permet de créer une exception en incluant à la fois un message d'erreur et une cause sous-jacente, facilitant ainsi la traçabilité des erreurs.
```java
public CalculatorException(String message, Throwable cause) {
    super(message, cause);
}
```

## Utilisation de `CalculatorException`

La classe `CalculatorException` est utilisée principalement dans les classes du modèle, telles que `Calculator` et `CalculatorEngine`, pour signaler des erreurs spécifiques lors des opérations de calcul. Par exemple, lors d'une tentative de division par zéro ou d'une entrée d'expression invalide, une instance de `CalculatorException` est lancée pour indiquer le problème rencontré.

## Conclusion

`CalculatorException` joue un rôle crucial dans la robustesse de l'application en offrant une gestion fine des erreurs liées aux opérations de calcul. En définissant des exceptions spécifiques, elle améliore la maintenabilité et la clarté du code, tout en facilitant le débogage et la compréhension des problèmes par les développeurs et les utilisateurs.