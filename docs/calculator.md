# Calculator.java - Documentation technique

## Vue d'ensemble
La classe `Calculator` constitue le cœur du moteur de calcul de la calculatrice. Elle implémente l'algorithme de Shunting Yard de Dijkstra pour transformer et évaluer des expressions mathématiques complexes en respectant la précédence des opérateurs.

## Points pédagogiques clés

### 1. Algorithmes et structures de données
- Implémentation de l'algorithme de Shunting Yard
- Utilisation intensive des piles (`Stack<Double>` et `Stack<String>`)
- Expressions régulières complexes pour l'analyse lexicale
- Gestion des priorités d'opérateurs

### 2. Conception orientée objet
- Encapsulation des opérations mathématiques via [`CalculatorEngine`](calculatorEngine.md)
- Gestion des erreurs avec des exceptions personnalisées via [`CalculatorException`](calculatorException.md)
- Pattern Composite pour les expressions mathématiques

### 3. Bonnes pratiques de programmation
- Documentation JavaDoc
- Constantes et expressions régulières bien définies
- Code modulaire et maintenable
- Gestion robuste des cas d'erreur

## Composants techniques principaux

### 1. Analyse lexicale (`tokenize`)
```java
public static final Pattern TOKEN_PATTERN = Pattern.compile(
    "(?<=[^\\d\\)])-\\d+\\.?\\d*|" +    // Nombres négatifs
    "\\d+\\.?\\d*|" +                   // Nombres positifs
    "[+\\-x÷%()^!]|" +                  // Opérateurs et parenthèses
    "mod|" +                            // Opérateur modulo
    "sin|cos|tan|" +                    // Fonctions trigonométriques
    "arcsin|arccos|arctan|" +           // Fonctions trigonométriques inverses
    "ln|exp|sqrt|π"                     // Autres fonctions
);
```

Cette expression régulière complexe permet de :
- Identifier les nombres négatifs et positifs
- Reconnaître les opérateurs mathématiques
- Détecter les fonctions trigonométriques et scientifiques
- Gérer les constantes mathématiques (π)

### 2. Système de priorité des opérateurs
```java
private int precedence(String operator) {
    switch (operator) {
        case "sin": case "cos": case "tan": // ...
            return 5; // Fonctions (priorité maximale)
        case "^":
            return 4; // Puissance
        case "(": case ")":
            return 3; // Parenthèses
        case "x": case "÷": case "mod": case "%":
            return 2; // Multiplication et division
        case "+": case "-":
            return 1; // Addition et soustraction
        default:
            return 0;
    }
}
```

### 3. Évaluation des expressions
L'évaluation se fait en trois étapes :
1. Tokenisation de l'expression
2. Conversion en notation postfixée (Reverse Polish Notation)
3. Évaluation de l'expression postfixée