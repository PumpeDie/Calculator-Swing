# CalculatorEngine.java - Documentation technique

## Vue d'ensemble
La classe `CalculatorEngine` implémente toutes les opérations mathématiques élémentaires et avancées de la calculatrice. Elle sert de couche d'abstraction entre les opérations mathématiques pures et le reste de l'application.

## Points pédagogiques clés

### 1. Gestion des opérations mathématiques
- Opérations arithmétiques de base (+, -, ×, ÷)
- Fonctions trigonométriques (sin, cos, tan et leurs inverses)
- Fonctions mathématiques avancées (ln, exp, sqrt, pow)
- Gestion du factoriel avec `BigInteger`

### 2. Conception orientée objet
- Encapsulation des opérations mathématiques
- Gestion d'état avec `lastResult`
- Gestion robuste des erreurs via [`CalculatorException`](calculatorException.md)

### 3. Bonnes pratiques de programmation
- Documentation JavaDoc
- Validation des entrées
- Gestion des cas limites
- Conversion degrés pour les fonctions trigonométriques

## Composants techniques principaux

### 1. Opérations de base
```java
public double divide(double a, double b) throws CalculatorException {
    if (b == 0) {
        throw new CalculatorException("Division par zéro non permise.");
    }
    lastResult = a / b;
    return lastResult;
}
```

### 2. Fonctions trigonométriques
```java
public double sin(double a) throws CalculatorException {
    lastResult = Math.sin(Math.toRadians(a));
    return lastResult;
}

public double arcsin(double a) throws CalculatorException {
    if (a < -1 || a > 1) {
        throw new CalculatorException("L'arc sinus n'est défini que pour les nombres entre -1 et 1.");
    }
    lastResult = Math.toDegrees(Math.asin(a));
    return lastResult;
}
```

### 3. Gestion des grands nombres
```java
public double factorial(double a) throws CalculatorException {
    if (a < 0) {
        throw new CalculatorException("Le factoriel n'est défini que pour les nombres positifs.");
    }
    if (a > 110) {
        throw new CalculatorException("Le nombre est trop grand pour être calculé.");
    }
    BigInteger result = BigInteger.ONE;
    for (int i = 1; i <= a; i++) {
        result = result.multiply(BigInteger.valueOf(i));
    }
    lastResult = result.doubleValue();
    return lastResult;
}
```