package fr.tse.fise2;

import fr.tse.fise2.ui.ScientificCalculatorUI;

/**
 * Classe ApplicationRun qui sert de point d'entrée pour l'application de calculatrice.
 * 
 * @author Samuel PLET
 * @version 2.0
 */
public class ApplicationRun {
    /**
    * Point d'entrée de l'application.
    * Crée une instance de CalculatorUI et affiche l'interface graphique.

    * @param args Arguments de la ligne de commande (non utilisés)
    */
    public static void main(String[] args) {
        // Utiliser SwingUtilities pour s'assurer que l'interface est créée dans l'EDT (Event Dispatch Thread)
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Créer une instance de ScientificCalculatorUI
            ScientificCalculatorUI calculator = new ScientificCalculatorUI();

            // Appelle la méthode pour créer et afficher l'interface graphique
            calculator.createAndShowGUI();
        });
    }
}