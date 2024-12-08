package fr.tse.fise2.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Classe UIStyle qui gère les styles de mise en forme pour l'interface utilisateur Swing.
 * Fournit des méthodes statiques pour appliquer des styles cohérents aux composants Swing.
 */
public class UIStyle {

    /**
     * Applique un style personnalisé à un bouton.
     * 
     * @param button Bouton à styliser.
     * @param background Couleur de fond du bouton.
     * @param foreground Couleur du texte du bouton.
     * @param font Police utilisée pour le texte du bouton.
     */
    public static void styleButton(JButton button, Color background, Color foreground, Font font) {
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFont(font);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
    }

    /**
     * Applique un style personnalisé à un champ de texte.
     * 
     * @param textField Champ de texte à styliser.
     * @param background Couleur de fond du champ de texte.
     * @param foreground Couleur du texte du champ de texte.
     * @param font Police utilisée pour le texte du champ de texte.
     * @param height Hauteur préférée du champ de texte.
     */
    public static void styleTextField(JTextField textField, Color background, Color foreground, Font font, int height) {
        textField.setBackground(background);
        textField.setForeground(foreground);
        textField.setFont(font);
        textField.setEditable(false); // Empêche la modification si nécessaire
        textField.setHorizontalAlignment(JTextField.RIGHT); // Alignement à droite
        textField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Marges internes
        textField.setPreferredSize(new Dimension(textField.getPreferredSize().width, height)); // Définir la hauteur
    }

    /**
     * Retourne la police de caractère prédéfinie pour l'interface utilisateur.
     * 
     * @return Police de caractère utilisée dans l'application.
     */
    static Font getUIFont() {
        return new Font("Arial", Font.BOLD, 20);
    }

    /**
     * Applique un style de fond personnalisé à un panneau.
     * 
     * @param panel Panneau à styliser.
     * @param background Couleur de fond du panneau.
     */
    public static void stylePanel(JPanel panel, Color background) {
        panel.setBackground(background);
    }
}