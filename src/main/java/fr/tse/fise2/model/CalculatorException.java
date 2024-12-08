package fr.tse.fise2.model;

/**
 * Classe CalculatorException qui gère les exceptions spécifiques de la calculatrice.
 */
public class CalculatorException extends Exception {

    /**
     * Constructeur de la classe CalculatorException.
     * @param message Message d'erreur
     * @param cause Cause de l'exception
     */
    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }
}