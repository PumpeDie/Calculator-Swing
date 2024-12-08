# CalculationResult.java - Documentation technique

## Vue d'ensemble
La classe `CalculationResult` encapsule le résultat d'une opération mathématique ainsi que l'expression qui l'a générée. Elle gère également le formatage intelligent des résultats numériques.

## Points pédagogiques clés

### 1. Gestion de la précision numérique
- Utilisation de `BigDecimal` pour la précision décimale
- Distinction entre nombres entiers et décimaux
- Gestion des arrondis et suppression des zéros non significatifs

### 2. Conception orientée objet 
- Immutabilité des données (champs `final`)
- Encapsulation avec getters
- Séparation du stockage et du formatage

### 3. Bonnes pratiques de programmation
- Documentation JavaDoc
- Gestion des cas particuliers (nombres entiers, quasi-entiers)
- Code lisible et maintenable

## Composant technique principal

### Formatage intelligent des résultats
```java
public String getFormattedResult() {
    if (result == (long) result) {
        return String.valueOf((long) result);
    }
    
    // Si le résultat est proche d'un entier (différence < 1e-10)
    if (Math.abs(result - Math.round(result)) < 1e-9) {
        return String.valueOf(Math.round(result));
    }

    BigDecimal bd = new BigDecimal(result)
        .setScale(10, RoundingMode.HALF_UP);
    return bd.stripTrailingZeros().toPlainString();
}
```