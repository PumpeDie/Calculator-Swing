package fr.tse.fise2.ui;

import fr.tse.fise2.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe CalculatorUI gère l'interface utilisateur graphique de la calculatrice.
 * Elle est responsable de la création des composants de l'interface utilisateur et de la gestion des événements des boutons.
 * Cette classe peut être étendue par ScientificCalculatorUI pour ajouter des fonctionnalités supplémentaires.
 */
public class CalculatorUI {
    // Contrôleur pour gérer les événements des boutons
    private Controller controller;

    // Boutons de la calculatrice
    private static final String[] BUTTON_LABELS = {
        "AC", "±", "%", "÷",
        "7", "8", "9", "x",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "Sci", "0", ".", "="
    };
    private static final String OPERATORS = "+-x÷";

    // Composants de l'interface utilisateur
    private JTextField display;
    private JTextField expressionDisplay;
    private JPanel panel;
    private JButton acButton;

    // Stockage de l'entrée utilisateur
    private StringBuilder currentInput;

    /**
     * Constructeur de la classe CalculatorUI.
     * Initialise le contrôleur et les composants de l'interface utilisateur.
     */
    public CalculatorUI() {
        currentInput = new StringBuilder();
        controller = new Controller(this);
        initComponents();
    }

    /**
     * Initialise les composants de l'interface utilisateur.
     * Crée les champs d'affichage, les boutons et les gestionnaires d'événements.
     */
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

    /**
     * Initialise les boutons de l'interface utilisateur.
     * Crée chaque bouton à partir des labels définis et les ajoute au panneau.
     */
    private void initializeButtons() {
        for (String text : BUTTON_LABELS) {
            JButton button = createButton(text);
            panel.add(button);
            if ("AC".equals(text)) {
                acButton = button;
            }
        }
    }

    /**
     * Crée un bouton avec le texte spécifié et ajoute un gestionnaire d'événements.
     * 
     * @param text Le texte du bouton.
     * @return Le bouton créé.
     */
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        styleButton(button, text);
        button.addActionListener(new ButtonClickListener());
        return button;
    }

    /**
     * Applique le style approprié en fonction du texte du bouton.
     * 
     * @param button Le bouton à styliser.
     * @param text Le texte du bouton.
     */
    private void styleButton(JButton button, String text) {
        if (OPERATORS.contains(text) || "=".equals(text)) {
            UIStyle.styleButton(button, Color.ORANGE, Color.WHITE, UIStyle.getUIFont());
        } else if ("AC±%".contains(text)) {
            UIStyle.styleButton(button, Color.LIGHT_GRAY, Color.WHITE, UIStyle.getUIFont());
        } else {
            UIStyle.styleButton(button, Color.DARK_GRAY, Color.WHITE, UIStyle.getUIFont());
        }
    }

    /**
     * Crée et affiche l'interface graphique de la calculatrice.
     * Configure la fenêtre principale et ajoute les composants.
     */
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

        // Changer icone de l'application
        ImageIcon icon = new ImageIcon("src/main/resources/calculator.png");
        frame.setIconImage(icon.getImage());

        // Centrer la fenêtre à l'écran
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Demander le focus sur le champ d'affichage
        display.requestFocusInWindow();
        SwingUtilities.invokeLater(() -> display.requestFocusInWindow());
    }

    /**
     * Ferme la fenêtre de l'application.
     */
    public void closeWindow() {
        Window window = SwingUtilities.getWindowAncestor(panel);
        window.dispose();
    }

    /**
     * Classe interne pour gérer les clics sur les boutons.
     */
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            controller.handleInput(command);
        }
    }

    // Getters et setters

    /**
     * Retourne le panneau contenant les boutons.
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Retourne le champ d'affichage principal.
     */
    public JTextField getDisplay() {
        return display;
    }

    /**
     * Retourne l'entrée utilisateur actuelle.
     */
    public StringBuilder getCurrentInput() {
        return currentInput;
    }

    /**
     * Retourne le bouton AC.
     */
    public JButton getAcButton() {
        return acButton;
    }

    /**
     * Retourne le contrôleur associé à l'interface.
     */
    public Controller getController() {
        return controller;
    }

    /**
     * Met à jour le champ d'affichage principal avec le texte spécifié.
     * 
     * @param text Le texte à afficher.
     */
    public void setDisplay(String text) {
        display.setText(text);
    }

    /**
     * Met à jour l'entrée utilisateur actuelle avec le texte spécifié.
     * 
     * @param text Le texte à définir.
     */
    public void setCurrentInput(String text) {
        currentInput.setLength(0);
        currentInput.append(text);
    }

    /**
     * Met à jour le champ d'affichage de l'expression avec le texte spécifié.
     * 
     * @param text Le texte de l'expression à afficher.
     */
    public void setExpressionDisplay(String text) {
        expressionDisplay.setText(text);
    }

    /**
     * Change le texte du bouton AC en un bouton de retour arrière.
     */
    public void setACButtonToBackspace() {
        acButton.setText("←");
    }

    /**
     * Change le texte du bouton AC en "AC".
     */
    public void setACButtonToAC() {
        acButton.setText("AC");
    }

    /**
     * Efface l'entrée utilisateur actuelle.
     */
    public void clearCurrentInput() {
        currentInput.setLength(0);
    }

    /**
     * Ajoute du texte à l'entrée utilisateur actuelle.
     * 
     * @param text Le texte à ajouter.
     */
    public void appendToCurrentInput(String text) {
        currentInput.append(text);
    }
}