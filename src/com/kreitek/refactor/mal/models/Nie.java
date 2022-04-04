package com.kreitek.refactor.mal.models;

public class Nie extends Document {

    @Override
    public boolean validate() {

        if(isValidStructure()){

            completeNieNumber();

            if(isValidatedNumber()){
                return true;
            }else{
                return false;
            }
        } else{
            return false;
        }
    }

    private boolean isValidatedNumber() {

        char controlDigit;
        int numericalSerieValue;
        int remainder;
        char[] controlDigits = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        controlDigit = Character.toUpperCase(this.documentNumber.charAt(8));
        numericalSerieValue = Integer.parseInt(this.documentNumber.substring(1,8));
        remainder = numericalSerieValue % 23;

        return (controlDigit == controlDigits[remainder]);

    }

    private void completeNieNumber() {
        String firstItemNie = this.documentNumber.substring(0,1);
        String remainderDigitsNie = this.documentNumber.substring(1,9);

        if(firstItemNie.equalsIgnoreCase("X")) {

            this.documentNumber = "0" + remainderDigitsNie;

        } else if(firstItemNie.equalsIgnoreCase("Y")) {

            this.documentNumber = "1" + remainderDigitsNie;

        } else if(firstItemNie.equalsIgnoreCase("Z")) {

            this.documentNumber = "2" + remainderDigitsNie;
        }

    }

    private boolean isValidStructure(){
        final int NIE_LENGTH=9;
        boolean isValidStructure= false;
        int i = 1;
        int characterASCII;
        if(this.documentNumber.length() == NIE_LENGTH && Character.isLetter(this.documentNumber.charAt(8))
                && isValidFirstItem()) {

            do {
                characterASCII = this.documentNumber.codePointAt(i);
                isValidStructure = (characterASCII > 47 && characterASCII < 58);
                i++;
            } while(i < this.documentNumber.length() - 1 && isValidStructure);
        }
        return isValidStructure;
    }

    private boolean isValidFirstItem(){

        if(this.documentNumber.substring(0,1).equalsIgnoreCase("X")) {

            return true;

        } else if(this.documentNumber.substring(0,1).equalsIgnoreCase("Y")) {

            return true;

        } else return this.documentNumber.substring(0, 1).equalsIgnoreCase("Z");

    }

    @Override
    public void consolePrint(String documentNumber, boolean isValidated) {
        System.out.println( "NIE " + documentNumber + " es: " + isValidated);
    }
}
