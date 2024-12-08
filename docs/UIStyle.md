# UIStyle.java - Documentation technique

## Vue d'ensemble
La classe `UIStyle` fournit des méthodes utilitaires statiques pour appliquer des styles cohérents aux composants de l'interface utilisateur Swing de l'application de calculatrice. Elle centralise la configuration des éléments graphiques tels que les boutons, les champs de texte et les panneaux, facilitant ainsi la maintenance et l'uniformité de l'apparence de l'application.

## Points pédagogiques clés

### 1. Centralisation des styles
- **Uniformité visuelle** : En regroupant les styles dans une seule classe, `UIStyle` assure une apparence cohérente à travers tous les composants de l'interface utilisateur.
- **Facilité de maintenance** : Modifier le style d'un composant devient simple et rapide, sans avoir à parcourir l'ensemble du code de l'application.

### 2. Conception orientée objet
- **Méthodes statiques** : Les méthodes étant statiques, elles peuvent être appelées directement sans instanciation de la classe, ce qui simplifie leur utilisation.
- **Encapsulation des styles** : Les détails de mise en forme sont encapsulés au sein de la classe, séparant la logique de présentation de la logique métier.

### 3. Bonnes pratiques de programmation
- **Réutilisabilité** : Les méthodes de `UIStyle` peuvent être réutilisées pour styliser différents types de composants, réduisant la duplication de code.
- **Paramétrisation** : Les méthodes acceptent des paramètres tels que les couleurs, les polices et les dimensions, offrant une flexibilité dans la personnalisation des styles.

## Composants techniques principaux

### 1. Stylisation des boutons (`styleButton`)
```java
public static void styleButton(JButton button, Color background, Color foreground, Font font) {
    button.setBackground(background);
    button.setForeground(foreground);
    button.setFont(font);
    button.setFocusPainted(false);
    button.setBorderPainted(false);
    button.setOpaque(true);
}
```
Cette méthode applique un style personnalisé à un bouton en définissant son arrière-plan, sa couleur de premier plan, sa police, et en ajustant des propriétés visuelles telles que le contour et la focalisation.

### 2. Stylisation des champs de texte (`styleTextField`)
```java
public static void styleTextField(JTextField textField, Color background, Color foreground, Font font, int height) {
    textField.setBackground(background);
    textField.setForeground(foreground);
    textField.setFont(font);
    textField.setEditable(false); // Empêche la modification si nécessaire
    textField.setHorizontalAlignment(JTextField.RIGHT); // Alignement à droite
    textField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Marges internes
    textField.setPreferredSize(new Dimension(textField.getPreferredSize().width, height)); // Définir la hauteur
}
```
Cette méthode configure l'apparence et le comportement d'un champ de texte, y compris les couleurs, la police, l'alignement du texte et les dimensions.

### 3. Obtention de la police d'interface utilisateur (`getUIFont`)
```java
static Font getUIFont() {
    return new Font("Arial", Font.BOLD, 20);
}
```
Retourne une instance de `Font` prédéfinie utilisée pour styliser les composants de l'interface, assurant une cohérence typographique à travers l'application.

### 4. Stylisation des panneaux (`stylePanel`)
```java
public static void stylePanel(JPanel panel, Color background) {
    panel.setBackground(background);
}
```
Applique une couleur de fond prédéfinie à un panneau, permettant de regrouper visuellement les composants de l'interface.

## Design et Architecture

### Séparation des préoccupations
- **Responsabilité unique** : `UIStyle` est exclusivement responsable de la mise en forme des composants UI, ce qui respecte le principe de responsabilité unique.
- **Réduction du couplage** : En déléguant le stylisme des composants à une classe dédiée, les autres classes de l'application peuvent se concentrer sur leur propre logique sans se soucier des détails visuels.

### Flexibilité et extensibilité
- **Adaptabilité** : Les méthodes peuvent être facilement étendues ou modifiées pour inclure de nouveaux styles ou ajuster les existants en fonction des besoins futurs de l'application.
- **Paramétrisation** : En acceptant des paramètres pour les couleurs, les polices et les dimensions, `UIStyle` permet une personnalisation facile sans modifier la méthode elle-même.

## Méthodes principales

### `styleButton(JButton button, Color background, Color foreground, Font font)`
Applique un style spécifique à un bouton en définissant son arrière-plan, sa couleur de texte, sa police, et en ajustant les propriétés de bordure et de focus.

### `styleTextField(JTextField textField, Color background, Color foreground, Font font, int height)`
Configure l'apparence d'un champ de texte, incluant les couleurs, la police, l'alignement du texte, les marges internes et la taille.

### `getUIFont()`
Fournit une police standardisée pour l'interface, garantissant une uniformité typographique à travers l'application.

### `stylePanel(JPanel panel, Color background)`
Définit la couleur de fond d'un panneau, permettant de regrouper visuellement les composants et d'améliorer l'esthétique globale de l'interface.

## Conclusion
La classe `UIStyle` joue un rôle essentiel dans la création d'une interface utilisateur cohérente et esthétiquement plaisante pour l'application de calculatrice. En centralisant les styles des composants Swing, elle facilite la maintenance, l'extensibilité et assure une uniformité visuelle, tout en respectant les principes de conception orientée objet et les bonnes pratiques de programmation.