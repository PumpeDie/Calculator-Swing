# CalculatorUI.java - Documentation technique

## Vue d'ensemble
La classe `CalculatorUI` gère l'interface utilisateur graphique de la calculatrice en utilisant Swing. Elle est responsable de la création et de la disposition des composants de l'interface, ainsi que de la gestion des événements des boutons. Cette classe suit le pattern MVC en délégant la logique métier au [`Controller`](controller.md), assurant ainsi une séparation claire des responsabilités.

## Points pédagogiques clés

### 1. Conception orientée objet
- **Encapsulation** : Tous les composants de l'interface sont encapsulés au sein de la classe, garantissant une gestion centralisée et sécurisée.
- **Extensibilité** : La classe est conçue pour être étendue par [`ScientificCalculatorUI`](scientificCalculatorUI.md), permettant l'ajout de fonctionnalités scientifiques sans modifier la classe de base.
- **Modularité** : La séparation des méthodes d'initialisation et de stylisation des composants facilite la maintenance et les futures extensions.

### 2. Utilisation de Swing pour l'interface graphique
- **Components Swing** : Utilisation de `JFrame`, `JPanel`, `JTextField`, et `JButton` pour construire l'interface utilisateur.
- **Layouts** : Utilisation de `GridLayout` et `BoxLayout` pour organiser les composants de manière cohérente et réactive.
- **Gestion des événements** : Implémentation de `ActionListener` pour gérer les actions des boutons, déléguant la logique au [`Controller`](controller.md).

### 3. Bonnes pratiques de programmation
- **Constantes bien définies** : Utilisation de tableaux et de chaînes de caractères constants pour les labels des boutons et les opérateurs, facilitant les modifications futures.
- **Style cohérent** : Application uniforme des styles via la classe [`UIStyle`](UIStyle.md), assurant une apparence homogène de l'interface.
- **Documentation claire** : Documentation JavaDoc pour chaque méthode et composant, facilitant la compréhension et la maintenance du code.

## Composants techniques principaux

### 1. Initialisation des composants (`initComponents`)
La méthode `initComponents` est responsable de la création et de la configuration des champs d'affichage et du panneau des boutons. Elle configure également les styles des composants en utilisant les méthodes statiques de [`UIStyle`](UIStyle.md).

```java
private void initComponents() {
    // Initialiser les champs d'affichage
    display = new JTextField();
    display.setName("display");
    display.setEditable(false);
    display.setText("0");

    expressionDisplay = new JTextField();
    expressionDisplay.setName("expressionDisplay");
    expressionDisplay.setEditable(false);

    // Appliquer les styles
    UIStyle.styleTextField(display, Color.BLACK, Color.WHITE, UIStyle.getUIFont(), 50);
    UIStyle.styleTextField(expressionDisplay, Color.BLACK, Color.LIGHT_GRAY, new Font(UIStyle.getUIFont().getName(), Font.BOLD, 14), 50);

    // Initialiser le panneau des boutons
    panel = new JPanel();
    panel.setLayout(new GridLayout(5, 4, 5, 5));
    UIStyle.stylePanel(panel, Color.BLACK);

    initializeButtons();
}
```

### 2. Création et stylisation des boutons (`initializeButtons` et `createButton`)
Ces méthodes créent les boutons de l'interface en utilisant les labels définis dans `BUTTON_LABELS`. Chaque bouton est stylisé en fonction de son rôle (opérateur, commande spéciale, etc.) et un `ActionListener` est ajouté pour gérer les événements.

```java
private void initializeButtons() {
    for (String text : BUTTON_LABELS) {
        JButton button = createButton(text);
        panel.add(button);
        if ("AC".equals(text)) {
            acButton = button;
        }
    }
}

private JButton createButton(String text) {
    JButton button = new JButton(text);
    styleButton(button, text);
    button.addActionListener(new ButtonClickListener());
    return button;
}

private void styleButton(JButton button, String text) {
    if (OPERATORS.contains(text) || "=".equals(text)) {
        UIStyle.styleButton(button, Color.ORANGE, Color.WHITE, UIStyle.getUIFont());
    } else if ("AC±%".contains(text)) {
        UIStyle.styleButton(button, Color.LIGHT_GRAY, Color.WHITE, UIStyle.getUIFont());
    } else {
        UIStyle.styleButton(button, Color.DARK_GRAY, Color.WHITE, UIStyle.getUIFont());
    }
}
```

### 3. Gestion des événements (`ButtonClickListener`)
La classe interne `ButtonClickListener` implémente `ActionListener` et délègue la gestion des événements au [`Controller`](controller.md) en appelant `controller.handleInput(command)` lorsqu'un bouton est cliqué.

```java
private class ButtonClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        controller.handleInput(command);
    }
}
```

### 4. Création et affichage de l'interface graphique (`createAndShowGUI`)
Cette méthode assemble les différents composants de l'interface dans un `JFrame`, applique les styles nécessaires, et rend la fenêtre visible. Elle ajoute également un `KeyListener` pour gérer les entrées clavier.

```java
public void createAndShowGUI() {
    JFrame frame = new JFrame("Calculatrice");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
    frame.setResizable(false);

    // Panneau d'affichage
    JPanel displayPanel = new JPanel();
    displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
    UIStyle.stylePanel(displayPanel, Color.BLACK);
    displayPanel.add(expressionDisplay);
    displayPanel.add(display);

    frame.add(displayPanel, BorderLayout.NORTH);
    frame.add(panel, BorderLayout.CENTER);

    // Gestion des événements clavier
    display.addKeyListener(controller.getKeyListener());

    frame.setVisible(true);

    display.requestFocusInWindow();
    SwingUtilities.invokeLater(() -> display.requestFocusInWindow());
}
```

## Design et Architecture

### Séparation des préoccupations
La classe `CalculatorUI` se concentre exclusivement sur la gestion de l'interface utilisateur. Elle ne contient aucune logique métier ou de calcul, qui est déléguée au [`Controller`](controller.md). Cette séparation permet de rendre le code plus modulaire et plus facile à maintenir.

### Interaction avec le Controller
- **Délégation des événements** : Les interactions utilisateur (clics sur les boutons) sont capturées par les écouteurs d'événements et transmises au [`Controller`](controller.md) pour traitement.
- **Mise à jour de l'affichage** : Après traitement des entrées par le [`Controller`](controller.md), la `CalculatorUI` met à jour les champs d'affichage (`display` et `expressionDisplay`) en fonction des résultats obtenus.

### Extensibilité
La conception permet d'étendre facilement l'interface utilisateur en créant des classes dérivées, comme [`ScientificCalculatorUI`](scientificCalculatorUI.md), qui ajoutent des fonctionnalités supplémentaires sans modifier la classe de base.

## Méthodes principales

### `createAndShowGUI()`
Crée et affiche la fenêtre principale de la calculatrice, en configurant les panneaux d'affichage et les boutons, et en ajoutant les gestionnaires d'événements nécessaires.

### `initializeButtons()`
Crée et ajoute tous les boutons de la calculatrice au panneau principal, en appliquant les styles appropriés.

### `createButton(String text)`
Crée un bouton avec le label spécifié, applique le style correspondant, et ajoute un écouteur d'événements.

### `styleButton(JButton button, String text)`
Applique un style spécifique à un bouton en fonction de son rôle (opérateur, commande spéciale, etc.).

### Gestion des accès
La classe fournit plusieurs getters et setters pour permettre au [`Controller`](controller.md) de manipuler l'affichage et le contenu actuel de l'entrée utilisateur.

## Conclusion
La classe `CalculatorUI` est essentielle pour fournir une interface utilisateur intuitive et réactive pour l'application de calculatrice. En respectant le pattern MVC, elle assure une séparation claire entre la présentation et la logique métier, facilitant ainsi la maintenance, l'extensibilité et la testabilité de l'application.