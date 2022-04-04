package com.kreitek.refactor.mal.models;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cif extends Document {

    @Override
    public boolean validate() {

        if (this.documentNumber != null) {
            String cifUP = this.documentNumber.toUpperCase();

            if (!isValidFirstCharacter(cifUP) || !isValidPattern(cifUP)) {
                return false;
            } else {
                if (isValidLastDigit(cifUP)) {
                    int totalValueNumericalSerie = getTotalofDigitsValues(cifUP);

                    int controlValue = calculateControlValue(totalValueNumericalSerie);

                    int positionControlDigit = calculatePositionControlDigit(controlValue);

                    char controlDigit = getControlDigit(positionControlDigit);

                    if (controlDigit != cifUP.charAt(cifUP.length() - 1)) {
                        return false;
                    }
                    return true;
                } else {
                    return false;
                }

            }

        }else{
            return false;
        }

    }
    private char getControlDigit(int positionControlDigit) {
        final String CONTROL_DIGIT_OPTIONS= "JABCDEFGHI";

        return CONTROL_DIGIT_OPTIONS.charAt(positionControlDigit);
    }

    private int calculatePositionControlDigit(int controlDigit) {

        if(controlDigit == 10){
            return 0;
        }else{
            return controlDigit;
        }

    }

    private int calculateControlValue(int totalValueNumericalSerie) {
       return 10 - (totalValueNumericalSerie % 10);
    }

    private int getTotalofDigitsValues(String cifUP) {
        String numericalSerie = cifUP.substring(1, cifUP.length() - 1);
        int evenDigits = getTotalEvenDigits(numericalSerie);
        int oddDigits = getTotalOddDigits(numericalSerie);
        return  evenDigits + oddDigits;
    }

    private int getTotalOddDigits(String numericalSerie) {
        int oddSum = 0;
        for (int i = 0; i <= numericalSerie.length() - 1; i = i + 2) {
            int cal = Integer.parseInt(numericalSerie.substring(i, i + 1)) * 2;
            if (Integer.toString(cal).length() > 1) {
                cal = Integer.parseInt(Integer.toString(cal).substring(0, 1))
                        + Integer.parseInt(Integer.toString(cal).substring(1, 2));
            }
            oddSum += cal;
        }
        return oddSum;
    }

    private int getTotalEvenDigits(String numericalSerie) {

        int evenSum = 0;
        for (int i = 1; i <= numericalSerie.length() - 1; i = i + 2) {
            evenSum += Integer.parseInt(numericalSerie.substring(i, i + 1));
        }
        return evenSum;
    }

    private boolean isValidLastDigit(String cifUP) {

        char lastChar = cifUP.charAt(cifUP.length() - 1);

        return Character.isLetter(lastChar);
    }

    private boolean isValidPattern(String cifUP) {
        final Pattern mask = Pattern
                .compile("[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z[0-9]]{1}");
        final Matcher matcher = mask.matcher(cifUP);
        return matcher.matches();

    }

    private boolean isValidFirstCharacter(String cifUP) {
        final String FIRST_CHARACTER_OPTIONS= "ABCDEFGHJKLMNPQRSUVW";
        return FIRST_CHARACTER_OPTIONS.indexOf(cifUP.charAt(0)) != -1;

    }

    @Override
    public void consolePrint(String documentNumber, boolean isValidated) {
        System.out.println("CIF " + documentNumber + " es: " + isValidated);
    }
}
