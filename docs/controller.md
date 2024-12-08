# Controller.java - Documentation technique

## Vue d'ensemble
La classe `Controller` joue un rôle central dans l'architecture MVC (Modèle-Vue-Contrôleur) de l'application de calculatrice. Elle sert d'intermédiaire entre l'interface utilisateur (`CalculatorUI` ou `ScientificCalculatorUI`) et le moteur de calcul (`Calculator`). Son objectif principal est de gérer les interactions de l'utilisateur, de traiter les entrées, de coordonner les calculs et de mettre à jour l'affichage en conséquence.

## Fonctionnalités principales

- **Gestion des entrées utilisateur** : La classe traite les entrées provenant des boutons de l'interface utilisateur ainsi que des entrées clavier, en interprétant les commandes et en les transmettant au modèle pour traitement.
  
- **Mise à jour de l'affichage** : Après le traitement des entrées, le contrôleur met à jour les champs d'affichage de l'expression et du résultat dans l'interface utilisateur.

- **Gestion du mode scientifique** : Elle permet de basculer entre le mode standard et le mode scientifique de la calculatrice, en ajustant l'interface utilisateur en conséquence.

- **Validation et gestion des erreurs** : Le contrôleur valide les entrées utilisateur, gère les erreurs potentielles (comme la division par zéro) et affiche des messages d'erreur appropriés via [`CalculatorException`](calculatorException.md).

## Design et Architecture

### Interaction avec la Vue et le Modèle
- **Vue (View)** : Le contrôleur détient une référence à l'instance de [`CalculatorUI`](calculatorUI.md) (ou [`ScientificCalculatorUI`](scientificCalculatorUI.md)) et utilise cette référence pour recevoir les entrées utilisateur et mettre à jour l'affichage.
  
- **Modèle (Model)** : Il interagit avec la classe [`Calculator`](calculator.md) pour évaluer les expressions mathématiques. Après l'évaluation, il récupère le résultat encapsulé dans une instance de [`CalculationResult`](calculationResult.md) et le transmet à la vue.

### Responsabilités
- **Séparation des préoccupations** : En suivant le pattern MVC, le contrôleur évite d'intégrer la logique métier ou la gestion de l'interface utilisateur directement, assurant ainsi une meilleure maintenabilité et évolutivité de l'application.
  
- **Abstraction des opérations** : Toutes les opérations liées à la gestion des entrées, au traitement des commandes et à la communication avec le modèle sont abstraites dans des méthodes dédiées au sein du contrôleur.

## Principales méthodes

### `handleInput(String command)`
Cette méthode est le point d'entrée pour la gestion des commandes utilisateur provenant de l'interface. Elle distingue les entrées numériques, les opérateurs et les commandes spéciales (comme "AC", "←", "±", "%", "=").

### `handleNumberInput(String command)`
Gère les entrées numériques et les points décimaux, en construisant dynamiquement l'expression mathématique à afficher.

### `handleOperatorInput(String command)`
Traite les opérateurs arithmétiques, en s'assurant de la validité syntaxique de l'expression (par exemple, en évitant deux opérateurs consécutifs).

### `handleAC()`, `handleBackspace()`, `handlePlusMinus()`, `handlePercent()`, `handleEquals()`
Ces méthodes gèrent des commandes spécifiques de l'utilisateur, telles que l'effacement complet de l'expression (`AC`), la suppression du dernier caractère (`←`), le changement de signe (`±`), l'application d'un pourcentage (`%`), et l'évaluation de l'expression (`=`).

### `handleScientificInput(String command)`
Gère les entrées spécifiques au mode scientifique, telles que les fonctions trigonométriques, les puissances, les racines carrées, etc.

### `toggleScientificMode()`
Permet de basculer entre le mode standard et le mode scientifique de la calculatrice en ajustant l'interface utilisateur.

### `handleKeyPress(KeyEvent e)`
Intercepte les événements clavier, permettant à l'utilisateur de contrôler la calculatrice via le clavier en plus des boutons de l'interface graphique.

## Gestion des événements

Le contrôleur implémente des écouteurs d'événements (`ActionListener` et `KeyAdapter`) pour intercepter et traiter les actions de l'utilisateur. Lorsqu'un événement est capturé (comme un clic sur un bouton ou une saisie clavier), le contrôleur détermine la nature de l'action et appelle la méthode appropriée pour la gérer.

### `CalculatorKeyListener`
Une classe interne qui étend `KeyAdapter` pour gérer les événements clavier. Elle traduit les pressions de touches en commandes compréhensibles par la méthode `handleInput`.

## Méthodes utilitaires

- **`evaluateExpression(String expression)`**
  Interagit avec la classe [`Calculator`](calculator.md) pour évaluer l'expression mathématique saisie par l'utilisateur et renvoie le résultat formaté.

- **`addMissingParentheses(String expression)`**
  Vérifie et ajoute les parenthèses manquantes dans l'expression pour assurer une évaluation correcte.

- **`isOperator(String token)` et `isNumeric(String str)`**
  Méthodes utilitaires pour déterminer si un token est un opérateur arithmétique ou un nombre valide.

## Points techniques notables

- **Utilisation de `StringBuilder` pour les entrées**
  Permet une manipulation efficace et dynamique de l'expression mathématique en cours de saisie.

- **Expressions régulières pour l'analyse syntaxique**
  Utilisées pour valider et analyser les entrées utilisateur, en particulier pour gérer les points décimaux et les opérateurs.

- **Gestion des erreurs avec [`CalculatorException`](calculatorException.md) **
  Le contrôleur capture et gère les exceptions spécifiques liées aux opérations de calcul, assurant une expérience utilisateur robuste et sans plantage.

## Conclusion

La classe `Controller` est essentielle pour orchestrer les interactions entre l'utilisateur, l'interface graphique et le moteur de calcul de l'application. En suivant les principes du pattern MVC, elle assure une séparation claire des responsabilités, facilitant ainsi la maintenance, l'extensibilité et la testabilité de l'application de calculatrice.