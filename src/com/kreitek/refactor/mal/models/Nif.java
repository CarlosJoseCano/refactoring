package com.kreitek.refactor.mal.models;

public class Nif extends Document {

    @Override
    public boolean validate() {
        if (!isCorrectLength() || !isCorrectStructure()){
            return false;
        } else {
            return true;
        }
    }

    private boolean isCorrectStructure(){

        String numericalSerieNif = this.documentNumber.trim().replaceAll(" ", "").substring(0, 8);

        if(!isNumeric(numericalSerieNif) || !isCorrectControlDigit(numericalSerieNif)){
            return false;
        }else{
            return true;
        }
    }

    private boolean isCorrectControlDigit(String numericalSerie){

        final String CONTROL_DIGITS="TRWAGMYFPDXBNJZSQVHLCKE";

        char controlDigitNif = this.documentNumber.charAt(8);

        // calculamos el módulo de 23 de la parte numérica que debería ser el caracter en esa
        // posición en la lista de CONTROL_DIGITS
        int controlDigitsposition = Integer.parseInt(numericalSerie) % 23;

        if(CONTROL_DIGITS.charAt(controlDigitsposition)!= controlDigitNif){
            return false;
        }else{
            return true;
        }
    }

    private boolean isCorrectLength() {
       final int NIF_LENGTH=9;

       if(this.documentNumber.length() != NIF_LENGTH){
           return false;
       }else{
           return true;
       }

    }

    private boolean isNumeric(String numericalSerie) {
        if (numericalSerie == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(numericalSerie);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public void consolePrint(String documentNumber, boolean isValidated) {
        System.out.println( "NIF " + documentNumber + " es: " + isValidated);

    }
}
