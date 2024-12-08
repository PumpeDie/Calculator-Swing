package fr.tse.fise2.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe ScientificCalculatorUI qui étend CalculatorUI pour ajouter des fonctionnalités scientifiques.
 * Gère l'affichage et les interactions des boutons scientifiques supplémentaires.
 */
public class ScientificCalculatorUI extends CalculatorUI {
    private JPanel scientificPanel;
    private boolean isScientificMode = false;

    // Boutons scientifiques supplémentaires
    private static final String[] SCIENTIFIC_BUTTONS = {
        "sin", "cos", "tan",
        "asin", "acos", "atan",
        "ln", "exp", "n!",
        "√", "x²", "xʸ",
        "π", "(", ")",
    };

    /**
     * Constructeur de la classe ScientificCalculatorUI.
     * Initialise le panneau scientifique et configure l'interface utilisateur.
     */
    public ScientificCalculatorUI() {
        super();
        initializeScientificPanel();
    }

    /**
     * Initialise le panneau contenant les boutons scientifiques.
     * Configure le layout et ajoute les boutons au panneau.
     */
    private void initializeScientificPanel() {
        scientificPanel = new JPanel();
        scientificPanel.setLayout(new GridLayout(5, 3, 5, 5));

        // Style du panneau scientifique
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

    /**
     * Applique le style approprié à un bouton en fonction de son texte.
     * 
     * @param button Le bouton à styliser.
     * @param text Le texte du bouton.
     */
    private void applyButtonStyle(JButton button, String text) {
        if (isTrigoButton(text)) {
            UIStyle.styleButton(button, Color.ORANGE, Color.WHITE, UIStyle.getUIFont());
        } else {
            UIStyle.styleButton(button, Color.DARK_GRAY, Color.WHITE, UIStyle.getUIFont());
        }
    }

    /**
     * Détermine si un bouton est une fonction trigonométrique.
     * 
     * @param text Le texte du bouton.
     * @return true si le bouton est une fonction trigonométrique, false sinon.
     */
    private boolean isTrigoButton(String text) {
        return text.matches("sin|cos|tan|asin|acos|atan");
    }

    /**
     * Crée et affiche l'interface graphique de la calculatrice scientifique.
     * Ajoute le panneau scientifique à l'interface principale.
     */
    @Override
    public void createAndShowGUI() {
        super.createAndShowGUI();

        // Récupérer la frame principale
        Window window = SwingUtilities.getWindowAncestor(getPanel());
        if (window instanceof JFrame) {

            // Créer un conteneur principal pour organiser les panneaux
            JPanel mainContainer = new JPanel();
            mainContainer.setLayout(new BorderLayout(5, 5));
            UIStyle.stylePanel(mainContainer, Color.BLACK);

            // Déplacer les composants existants dans le conteneur principal
            Container parent = getPanel().getParent();
            parent.remove(getPanel());

            // Ajouter les panneaux au conteneur principal
            mainContainer.add(scientificPanel, BorderLayout.WEST);
            mainContainer.add(getPanel(), BorderLayout.CENTER);

            // Ajouter le conteneur principal à la frame
            parent.add(mainContainer);

            // Initialiser en mode non-scientifique
            scientificPanel.setVisible(false);
        }
    }

    /**
     * Retourne le texte actuellement affiché dans le champ principal.
     */
    protected String getCurrentDisplayText() {
        return getDisplay().getText();
    }

    /**
     * Met à jour le champ d'affichage principal avec le texte spécifié.
     * 
     * @param text Le texte à afficher.
     */
    protected void updateDisplay(String text) {
        setDisplay(text);
        setCurrentInput(text);
    }

    /**
     * Bascule le mode scientifique de l'interface utilisateur.
     * Affiche ou masque le panneau scientifique et ajuste la taille de la fenêtre.
     */
    public void toggleScientificMode() {
        isScientificMode = !isScientificMode;
        scientificPanel.setVisible(isScientificMode);

        Window window = SwingUtilities.getWindowAncestor(getPanel());
        if (window instanceof JFrame) {
            JFrame frame = (JFrame) window;
            frame.setSize(isScientificMode ? 700 : 400, 600);

            // Forcer la mise à jour de la disposition de la fenêtre
            frame.setLocationRelativeTo(null);
            frame.revalidate();
            frame.repaint();
        }
    }

    /**
     * Classe interne pour gérer les clics sur les boutons scientifiques.
     * Envoie la commande au contrôleur pour traitement.
     */
    private class ScientificButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            getController().handleScientificInput(command);
        }
    }
}