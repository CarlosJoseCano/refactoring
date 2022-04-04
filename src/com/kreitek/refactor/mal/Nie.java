package com.kreitek.refactor.mal;

import java.util.Date;

public class Nie extends Document{

    @Override
    public boolean validate() {

        if(isValidatedStructure()){

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

        char controlDigit= ' ';
        int numericalSerie = 0;
        int remainder = 0;
        char[] controlDigits = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};


        controlDigit = Character.toUpperCase(this.documentNumber.charAt(8));
        numericalSerie = Integer.parseInt(this.documentNumber.substring(1,8));

        remainder = numericalSerie % 23;

        return (controlDigit == controlDigits[remainder]);

    }

    private void completeNieNumber() {

        if(this.documentNumber.substring(0,1).toUpperCase().equals("X")) {

            this.documentNumber = "0" + this.documentNumber.substring(1,9);

        } else if(this.documentNumber.substring(0,1).toUpperCase().equals("Y")) {

            this.documentNumber = "1" + this.documentNumber.substring(1,9);

        } else if(this.documentNumber.substring(0,1).toUpperCase().equals("Z")) {

            this.documentNumber = "2" + this.documentNumber.substring(1,9);
        }

    }

    private boolean isValidatedStructure(){
        final int NIE_LENGTH=9;
        boolean isValidStructure= false;
        int i = 1;
        int caracterASCII = 0;
        if(this.documentNumber.length() == NIE_LENGTH && Character.isLetter(this.documentNumber.charAt(8))
                && isValidFirstItem()) {

            do {
                caracterASCII = this.documentNumber.codePointAt(i);
                isValidStructure = (caracterASCII > 47 && caracterASCII < 58);
                i++;
            } while(i < this.documentNumber.length() - 1 && isValidStructure);
        }
        return isValidStructure;
    }

    private boolean isValidFirstItem(){

        if(this.documentNumber.substring(0,1).toUpperCase().equals("X")) {

            return true;

        } else if(this.documentNumber.substring(0,1).toUpperCase().equals("Y")) {

            return true;

        } else if(this.documentNumber.substring(0,1).toUpperCase().equals("Z")) {

            return true;
        }else{
            return false;
        }

    }

    @Override
    public void consolePrint(String documentNumber, boolean isValidated) {
        System.out.println( "NIE " + documentNumber + " es: " + isValidated);
    }
}
