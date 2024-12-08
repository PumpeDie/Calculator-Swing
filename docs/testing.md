# Documentation des Tests

## Vue d'ensemble
Cette section détaille les classes de tests unitaires développées pour assurer la fiabilité et la robustesse de l'application de calculatrice. Les tests sont implémentés en utilisant JUnit 5 et couvrent les principales fonctionnalités des classes [`Calculator`](calculator.md), [`CalculatorEngine`](calculatorEngine.md) et [`CalculationResult`](calculationResult.md).

## Table des matières

1. [CalculatorTest.java](#calculatortestjava)
2. [CalculatorEngineTest.java](#calculatorenginetestjava)
3. [CalculationResultTest.java](#calculationresulttestjava)

---

## CalculatorTest.java

### Vue d'ensemble
La classe `CalculatorTest` contient des tests unitaires pour la classe [`Calculator`](calculator.md). Elle vérifie l'exactitude de l'évaluation des expressions mathématiques, la gestion des opérateurs, et la gestion des exceptions spécifiques telles que la division par zéro.

### Points clés

- **Évaluation d'expressions simples et complexes** : Vérifie que l'évaluation des expressions arithmétiques respecte la précédence des opérateurs.
- **Gestion des nombres négatifs et opérateurs modulo** : Teste la capacité de la calculatrice à gérer les opérations impliquant des nombres négatifs et l'opérateur modulo.
- **Gestion des pourcentages** : Assure que le calcul des pourcentages dans les expressions est correct.
- **Gestion des parenthèses** : Vérifie que les expressions avec parenthèses sont correctement évaluées.
- **Gestion des exceptions** : Confirme que les exceptions spécifiques sont lancées lorsqu'une opération invalide est effectuée, comme la division par zéro.

### Méthodes de Test

- **`testEvaluateExpression`** : Vérifie l'évaluation correcte d'une expression simple.
- **`testMultiplyNegative`** : Teste la multiplication impliquant un nombre négatif.
- **`testDivisionByZero`** : Assure que la division par zéro lance une [`CalculatorException`](calculatorException.md).
- **`testSimplePercentage`** : Vérifie le calcul correct d'un pourcentage simple.
- **`testModuloOperation`** : Teste l'opération modulo et la gestion de la division par zéro dans ce contexte.
- **`testPercentageInExpression`** : Vérifie l'intégration des pourcentages dans une expression plus complexe.
- **`testComplexExpression`** : Teste l'évaluation d'une expression complexe mélangeant plusieurs opérateurs et fonctions.
- **`testParenthesesWithOperators`** : Assure que les expressions contenant des parenthèses et des opérateurs sont correctement évaluées.

### Conclusion
Les tests de `CalculatorTest` assurent que la classe [`Calculator`](calculator.md) fonctionne comme attendu, en couvrant une variété de scénarios d'utilisation et en garantissant la gestion appropriée des erreurs.

---

## CalculatorEngineTest.java

### Vue d'ensemble
La classe `CalculatorEngineTest` contient des tests unitaires pour la classe [`CalculatorEngine`](calculatorEngine.md). Elle vérifie l'exactitude des opérations mathématiques de base et avancées, ainsi que la gestion des exceptions associées.

### Points clés

- **Opérations arithmétiques de base** : Teste les méthodes d'addition, de soustraction, de multiplication et de division.
- **Opérations avancées** : Vérifie les fonctions trigonométriques, les logarithmes, les puissances, les racines carrées et le factoriel.
- **Gestion des exceptions** : Assure que les opérations invalides, telles que la division par zéro ou la racine carrée d'un nombre négatif, lancent les exceptions appropriées.
- **Gestion de l'état** : Vérifie que la variable `lastResult` est correctement mise à jour après chaque opération.

### Méthodes de Test

- **`testAdd`** : Vérifie la somme de deux nombres.
- **`testSubtract`** : Teste la soustraction de deux nombres.
- **`testMultiply`** : Vérifie la multiplication de deux nombres.
- **`testDivide`** : Teste la division de deux nombres valides.
- **`testDivisionByZero`** : Assure que la division par zéro lance une [`CalculatorException`](calculatorException.md).
- **`testModulo`** : Vérifie l'opération modulo et la gestion de la division par zéro.
- **`testGetLastResult`** : Vérifie que `lastResult` est correctement mis à jour après une opération.
- **`testTrigonometricFunctions`** : Teste les fonctions sin, cos et tan avec des valeurs spécifiques.
- **`testLogarithms`** : Vérifie les fonctions logarithmiques et leur gestion des entrées invalides.
- **`testPowersAndRoot`** : Teste les fonctions de puissance et de racine carrée, ainsi que la gestion des entrées invalides.
- **`testFactorial`** : Vérifie le calcul du factoriel et la gestion des entrées négatives.
- **`testLastResult`** : Assure que `lastResult` reflète correctement le dernier calcul effectué.

### Conclusion
Les tests de `CalculatorEngineTest` garantissent que toutes les opérations mathématiques implémentées dans [`CalculatorEngine`](calculatorEngine.md) fonctionnent correctement et que les exceptions sont bien gérées, assurant ainsi la fiabilité des calculs effectués par l'application.

---

## CalculationResultTest.java

### Vue d'ensemble
La classe `CalculationResultTest` contient des tests unitaires pour la classe [`CalculationResult`](calculationResult.md). Elle vérifie le formatage correct des résultats numériques, en s'assurant que les nombres entiers et décimaux sont affichés de manière appropriée.

### Points clés

- **Formatage des résultats entiers** : Assure que les résultats qui sont des nombres entiers sont formatés sans décimales.
- **Formatage des résultats décimaux** : Vérifie que les résultats avec des parties décimales sont correctement formatés.
- **Gestion des quasi-entiers** : Teste le formatage des nombres qui sont proches d'un entier mais qui ont une petite partie décimale.

### Méthodes de Test

- **`testFormattedResult`** : Vérifie que les résultats entiers sont formatés sans décimales.
- **`testNonIntegerFormattedResult`** : Assure que les résultats décimaux sont formatés avec les décimales appropriées.

### Conclusion
Les tests de `CalculationResultTest` garantissent que la classe [`CalculationResult`](calculationResult.md) formate les résultats numériques de manière cohérente et précise, améliorant ainsi la lisibilité et la compréhension des résultats affichés à l'utilisateur.

---

## Technologies et Bonnes Pratiques Utilisées dans les Tests

- **JUnit 5** : Utilisé comme framework de test unitaire pour structurer et exécuter les tests.
- **Assertions** : Utilisation des assertions fournies par JUnit pour vérifier l'exactitude des résultats.
- **Gestion des Exceptions** : Tests spécifiques pour s'assurer que les exceptions sont bien lancées dans les scénarios d'erreur.
- **Setup Pré-Test** : Utilisation de `@BeforeEach` pour initialiser les instances nécessaires avant chaque test, garantissant un environnement de test propre et indépendant.
- **Précision des Tests** : Définition d'une constante `DELTA` pour les comparaisons de nombres décimaux, assurant une précision appropriée dans les assertions.

## Conclusion Générale sur les Tests

Les classes de tests unitaires fournissent une couverture complète des fonctionnalités essentielles de l'application de calculatrice. En vérifiant à la fois les opérations valides et la gestion des erreurs, elles assurent que l'application fonctionne de manière fiable et conforme aux attentes. L'utilisation de JUnit 5 et le respect des bonnes pratiques de test permettent de maintenir une base de code de haute qualité et facilitent la détection précoce des régressions lors des évolutions futures de l'application.