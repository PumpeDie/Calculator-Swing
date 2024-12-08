package fr.tse.fise2.model;

import java.math.BigInteger;

/**
 * Classe CalculatorEngine qui gère les logiques de base de la calculatrice.
 */
public class CalculatorEngine {

    // Dernier résultat calculé.
    private double lastResult;

    // Constructeur de la classe CalculatorEngine.
    public CalculatorEngine() {
        lastResult = 0;
    }

    /**
     * Additionne deux nombres.
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return Résultat de l'addition
     */
    public double add(double a, double b) {
        lastResult = a + b;
        return lastResult;
    }

    /**
     * Soustrait deux nombres.
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return Résultat de la soustraction
     */
    public double subtract(double a, double b) {
        lastResult = a - b;
        return lastResult;
    }

    /**
     * Multiplie deux nombres.
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return Résultat de la multiplication
     */
    public double multiply(double a, double b) {
        lastResult = a * b;
        return lastResult;
    }

    /**
     * Divise deux nombres.
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return Résultat de la division
     * @throws CalculatorException Si la division par zéro est tentée
     */
    public double divide(double a, double b) throws CalculatorException {
        if (b == 0) {
            throw new CalculatorException("Division par zéro non permise.");
        }
        lastResult = a / b; // Division si le dénominateur n'est pas zéro
        return lastResult;
    }

    /**
     * Applique l'opération modulo entre deux nombres.
     * @param a Le premier nombre.
     * @param b Le deuxième nombre (facultatif pour le pourcentage).
     * @return Le résultat du modulo si b est fourni.
     * @throws CalculatorException Si le modulo par zéro est tenté
     */
    public double modulo(double a, double b) throws CalculatorException {
        if (b == 0) {
            throw new CalculatorException("Modulo par zéro non permis.");
        }
        lastResult = a % b; 
        return lastResult;
    }

    /**
     * Calcule le pourcentage d'un nombre.
     * @param a Le nombre
     * @return Le pourcentage du nombre
     */
    public double percent(double a) {
        lastResult = a / 100; // Pourcentage si un seul opérande est fourni
        return lastResult;
    }

    /**
     * Calcule le sinus d'un angle en degrés.
     * @param a L'angle en degrés
     * @return Le sinus de l'angle
     * @throws CalculatorException Si une erreur se produit lors du calcul
     */
    public double sin(double a) throws CalculatorException {
        lastResult = Math.sin(Math.toRadians(a));
        return lastResult;
    }

    /**
     * Calcule l'arc sinus d'un nombre.
     * @param a Le nombre
     * @return L'arc sinus du nombre
     * @throws CalculatorException Si une erreur se produit lors du calcul
     */
    public double arcsin(double a) throws CalculatorException {
        if (a < -1 || a > 1) {
            throw new CalculatorException("L'arc sinus n'est défini que pour les nombres entre -1 et 1.");
        }
        lastResult = Math.toDegrees(Math.asin(a));
        return lastResult;
    }

    /**
     * Calcule le cosinus d'un angle en degrés.
     * @param a L'angle en degrés
     * @return Le cosinus de l'angle
     * @throws CalculatorException Si une erreur se produit lors du calcul
     */
    public double cos(double a) throws CalculatorException {
        lastResult = Math.cos(Math.toRadians(a));
        return lastResult;
    }

    /**
     * Calcule l'arc cosinus d'un nombre.
     * @param a Le nombre
     * @return L'arc cosinus du nombre
     * @throws CalculatorException Si une erreur se produit lors du calcul
     */
    public double arccos(double a) throws CalculatorException {
        if (a < -1 || a > 1) {
            throw new CalculatorException("L'arc cosinus n'est défini que pour les nombres entre -1 et 1.");
        }
        lastResult = Math.toDegrees(Math.acos(a));
        return lastResult;
    }

    /**
     * Calcule la tangente d'un angle en degrés.
     * @param a L'angle en degrés
     * @return La tangente de l'angle
     * @throws CalculatorException Si une erreur se produit lors du calcul
     */
    public double tan(double a) throws CalculatorException {
        lastResult = Math.tan(Math.toRadians(a));
        return lastResult;
    }

    /**
     * Calcule l'arc tangente d'un nombre.
     * @param a Le nombre
     * @return L'arc tangente du nombre
     * @throws CalculatorException Si une erreur se produit lors du calcul
     */
    public double arctan(double a) throws CalculatorException {
        lastResult = Math.toDegrees(Math.atan(a));
        return lastResult;
    }

    /**
     * Calcule le logarithme naturel d'un nombre.
     * @param a Le nombre
     * @return Le logarithme naturel du nombre
     * @throws CalculatorException Si une erreur se produit lors du calcul
     */
    public double ln(double a) throws CalculatorException {
        if (a <= 0) {
            throw new CalculatorException("Le logarithme naturel n'est défini que pour les nombres positifs.");
        }
        lastResult = Math.log(a);
        return lastResult;
    }

    /**
     * Calcule l'exponentielle d'un nombre.
     * @param a Le nombre
     * @return L'exponentielle du nombre
     * @throws CalculatorException Si une erreur se produit lors du calcul
     */
    public double exp(double a) throws CalculatorException {
        double result = Math.exp(a);
        if (Double.isInfinite(result)) {
            throw new CalculatorException("Le résultat est trop grand pour être représenté.");
        }
        if (Double.isNaN(result)) {
            throw new CalculatorException("Le calcul a produit un résultat invalide.");
        }
        lastResult = result;
        return lastResult;
    }

    /**
     * Calcule la racine carrée d'un nombre.
     * @param a Le nombre
     * @return La racine carrée du nombre
     * @throws CalculatorException Si une erreur se produit lors du calcul
     */
    public double sqrt(double a) throws CalculatorException {
        if (a < 0) {
            throw new CalculatorException("La racine carrée n'est définie que pour les nombres positifs.");
        }
        double result = Math.sqrt(a);
        if (Double.isNaN(result)) {
            throw new CalculatorException("Le calcul a produit un résultat invalide.");
        }
        lastResult = result;
        return lastResult;
    }

    /**
     * Calcule la puissance d'un nombre.
     * @param a La base
     * @param b L'exposant
     * @return La puissance de la base à l'exposant
     * @throws CalculatorException Si le résultat dépasse les limites ou est invalide
     */
    public double pow(double a, double b) throws CalculatorException {
        double result = Math.pow(a, b);
        if (Double.isInfinite(result)) {
            throw new CalculatorException("Le résultat est trop grand pour être représenté.");
        }
        if (Double.isNaN(result)) {
            throw new CalculatorException("Le calcul a produit un résultat invalide.");
        }
        lastResult = result;
        return lastResult;
    }

    /**
     * Calcule le factoriel d'un nombre.
     * @param a Le nombre
     * @return Le factoriel du nombre
     * @throws CalculatorException Si une erreur se produit lors du calcul
     */
    public double factorial(double a) throws CalculatorException {
        if (a < 0) {
            throw new CalculatorException("Le factoriel n'est défini que pour les nombres positifs.");
        }
        if (a > 110) { // Limite pour éviter les dépassements
            throw new CalculatorException("Le nombre est trop grand pour être calculé.");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= a; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        lastResult = result.doubleValue();
        return lastResult;
    }

    /**
     * Retourne le dernier résultat calculé.
     * @return Dernier résultat
     */
    public double getLastResult() {
        return lastResult;
    }
}