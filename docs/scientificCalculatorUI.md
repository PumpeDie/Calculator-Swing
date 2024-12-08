# ScientificCalculatorUI.java - Documentation technique

## Vue d'ensemble
La classe `ScientificCalculatorUI` étend la classe [`CalculatorUI`](calculatorUI.md) pour ajouter des fonctionnalités scientifiques supplémentaires à l'interface utilisateur de la calculatrice. Elle intègre des composants spécifiques tels que des boutons pour les fonctions trigonométriques, logarithmiques et autres opérations avancées, tout en maintenant une interface utilisateur cohérente et intuitive.

## Points pédagogiques clés

### 1. Extension de classes avec Swing
- **Héritage** : `ScientificCalculatorUI` hérite de [`CalculatorUI`](calculatorUI.md), réutilisant ainsi les composants et la logique de base de l'interface utilisateur.
- **Réutilisation du code** : En étendant la classe de base, elle évite la duplication de code et facilite l'ajout de nouvelles fonctionnalités spécifiques.

### 2. Gestion des modes d'affichage
- **Mode standard vs mode scientifique** : Implémentation d'un mécanisme permettant de basculer entre une interface de calculatrice standard et une interface scientifique étendue.
- **Dynamisme de l'interface** : La classe ajuste dynamiquement la disposition des composants en fonction du mode sélectionné, améliorant ainsi l'expérience utilisateur.

### 3. Stylisation et personnalisation des composants
- **Utilisation de [`UIStyle`](UIStyle.md)** : Application cohérente des styles aux nouveaux composants via la classe [`UIStyle`](UIStyle.md), assurant une apparence homogène avec la calculatrice de base.
- **Adaptabilité des styles** : Les méthodes de stylisation permettent de personnaliser l'apparence des boutons scientifiques en fonction de leur rôle (par exemple, boutons trigonométriques).

## Composants techniques principaux

### 1. Initialisation du panneau scientifique (`initializeScientificPanel`)
La méthode `initializeScientificPanel` est responsable de la création et de la configuration des boutons spécifiques au mode scientifique. Elle organise les boutons en grille et applique les styles appropriés.

```java
private void initializeScientificPanel() {
    scientificPanel = new JPanel();
    scientificPanel.setLayout(new GridLayout(5, 3, 5, 5));
    
    // Style du panel scientifique
    UIStyle.stylePanel(scientificPanel, Color.BLACK);
    scientificPanel.setPreferredSize(new Dimension(300, 600));
    
    // Ajouter les boutons scientifiques
    for (String text : SCIENTIFIC_BUTTONS) {
        JButton button = new JButton(text);
        applyButtonStyle(button, text);
        button.addActionListener(new ScientificButtonClickListener());
        scientificPanel.add(button);
    }
    scientificPanel.setVisible(false);
}
```

### 2. Stylisation des boutons scientifiques (`applyButtonStyle`)
Cette méthode applique des styles spécifiques aux boutons scientifiques en fonction de leur catégorie (par exemple, boutons trigonométriques vs autres fonctions).

```java
private void applyButtonStyle(JButton button, String text) {
    if (isTrigoButton(text)) {
        UIStyle.styleButton(button, Color.ORANGE, Color.WHITE, UIStyle.getUIFont());
    } else {
        UIStyle.styleButton(button, Color.DARK_GRAY, Color.WHITE, UIStyle.getUIFont());
    }
}
```

### 3. Gestion des événements spécifiques au mode scientifique (`ScientificButtonClickListener`)
La classe interne `ScientificButtonClickListener` implémente `ActionListener` pour gérer les actions des boutons scientifiques, en délégant le traitement au [`Controller`](controller.md).

```java
private class ScientificButtonClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        getController().handleScientificInput(command);
    }
}
```

### 4. Basculement entre les modes (`toggleScientificMode`)
La méthode `toggleScientificMode` permet de basculer entre le mode standard et le mode scientifique en ajustant la visibilité du panneau scientifique et en redimensionnant la fenêtre principale.

```java
public void toggleScientificMode() {
    isScientificMode = !isScientificMode;
    scientificPanel.setVisible(isScientificMode);
    
    Window window = SwingUtilities.getWindowAncestor(getPanel());
    if (window instanceof JFrame) {
        JFrame frame = (JFrame) window;
        frame.setSize(isScientificMode ? 700 : 400, 600);
        
        // Forcer la mise à jour de la disposition
        frame.revalidate();
        frame.repaint();
    }
}
```

## Design et Architecture

### Séparation des préoccupations
`ScientificCalculatorUI` maintient une séparation claire des responsabilités en étendant uniquement les aspects liés à l'interface utilisateur scientifique, tout en déléguant la logique métier au [`Controller`](controller.md). Cela permet de conserver une architecture modulaire et facilite la maintenance et l'extension de l'application.

### Interaction avec le Controller
- **Délégation des événements** : Les interactions utilisateur avec les boutons scientifiques sont capturées par les écouteurs d'événements internes et transmises au [`Controller`](controller.md) via des méthodes dédiées.
- **Mise à jour de l'affichage** : Après traitement par le [`Controller`](controller.md), les résultats des opérations scientifiques sont affichés en mettant à jour les composants d'affichage standard de la calculatrice.

### Extensibilité
La conception permet l'ajout facile de nouvelles fonctionnalités scientifiques en ajoutant simplement de nouveaux boutons et en définissant leur comportement dans le [`Controller`](controller.md). L'utilisation de tableaux constants pour les labels des boutons facilite l'ajout ou la modification des fonctionnalités disponibles en mode scientifique.

## Méthodes principales

### `createAndShowGUI()`
Cette méthode surcharge celle de la classe parente pour intégrer le panneau scientifique dans l'interface principale. Elle configure également la gestion des événements clavier pour inclure les nouvelles fonctions scientifiques.

### `initializeScientificPanel()`
Crée et configure les composants spécifiques au mode scientifique, en organisant les boutons dans un panneau dédié et en appliquant les styles appropriés.

### `applyButtonStyle(JButton button, String text)`
Applique des styles spécifiques aux boutons scientifiques en fonction de leur rôle, assurant une distinction visuelle entre les différents types de fonctionnalités.

### `toggleScientificMode()`
Permet de basculer l'affichage de l'interface utilisateur entre le mode standard et le mode scientifique, en ajustant la taille de la fenêtre et la visibilité des composants.

## Conclusion
La classe `ScientificCalculatorUI` enrichit l'interface utilisateur de l'application de calculatrice en y ajoutant des fonctionnalités scientifiques avancées tout en maintenant une architecture claire et modulaire. En étendant [`CalculatorUI`](calculatorUI.md) et en intégrant des composants spécifiques au calcul scientifique, elle assure une expérience utilisateur enrichie sans compromettre la maintenabilité et la simplicité du code. Cette approche respecte les principes du pattern MVC, facilitant ainsi la gestion et l'évolution future de l'application.
