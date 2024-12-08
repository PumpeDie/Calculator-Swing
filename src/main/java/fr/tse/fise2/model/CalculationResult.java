package fr.tse.fise2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe CalculationResult qui représente le résultat d'une opération de calcul.
 */
public class CalculationResult {
    private final double result;
    private final String expression; // L'expression originale

    /**
     * Constructeur de CalculationResult.
     * 
     * @param result     Le résultat numérique de l'opération.
     * @param expression L'expression mathématique originale.
     */
    public CalculationResult(double result, String expression) {
        this.result = result;
        this.expression = expression;
    }

    /**
     * Retourne le résultat numérique de l'opération.
     * 
     * @return Le résultat en tant que double.
     */
    public double getResult() {
        return result;
    }

    /**
     * Retourne l'expression mathématique originale.
     * 
     * @return L'expression sous forme de chaîne de caractères.
     */
    public String getExpression() {
        return expression;
    }

    /** 
     * Renvoie le résultat formaté sous forme de chaîne.
     * 
     * Cette méthode formate le résultat pour éviter les représentations en
     * virgule flottante indésirables. Elle élimine les zéros non significatifs
     * et arrondit le résultat si nécessaire.
     * 
     * @return Le résultat formaté en tant que chaîne de caractères.
     */
    public String getFormattedResult() {
        // Vérifie si le résultat est un entier
        if (result == (long) result) {
            return String.valueOf((long) result);
        }
        
        // Vérifie si le résultat est proche d'un entier
        if (Math.abs(result - Math.round(result)) < 1e-9) {
            return String.valueOf(Math.round(result));
        }

        // Utilise BigDecimal pour une meilleure précision et formatage
        BigDecimal bd = new BigDecimal(result).setScale(10, RoundingMode.HALF_UP);
        String formatted = bd.stripTrailingZeros().toPlainString();

        return formatted;
    }
}