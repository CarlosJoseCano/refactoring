package com.kreitek.refactor.mal;

class  Main
{
    public static void main(String args[])
    {
        printTitle();

        // creamos un DNI correcto
        Document dniCorrecto = new Nif();
        dniCorrecto.setDocumentNumber("11111111H");
        Boolean esValido = dniCorrecto.validate();
        dniCorrecto.consolePrint(dniCorrecto.documentNumber, esValido);

        // creamos un DNI incorrecto
        Document dniIncorrecto01 = new Nif();
        dniIncorrecto01.setDocumentNumber("24324356A");
        Boolean esValido1 = dniIncorrecto01.validate();
        dniIncorrecto01.consolePrint(dniIncorrecto01.documentNumber, esValido1);

        // creamos un NIE correcto
        Document nieCorrecto = new Nie();
        nieCorrecto.setDocumentNumber("X0932707B");
        Boolean esValido2 = nieCorrecto.validate();
        nieCorrecto.consolePrint(nieCorrecto.documentNumber, esValido2);


        // creamos un NIE incorrecto
        Document nieIncorrecto = new Nie();
        nieIncorrecto.setDocumentNumber("Z2691139Z");
        Boolean esValido3 = nieIncorrecto.validate();
        nieIncorrecto.consolePrint(nieIncorrecto.documentNumber, esValido3);


        // creamos un CIF correcto
        Document cifCorrecto = new Cif();
        cifCorrecto.setDocumentNumber("W9696294I");
        Boolean esValido4 = cifCorrecto.validate();
        cifCorrecto.consolePrint(cifCorrecto.documentNumber, esValido4);

        // creamos un CIF incorrecto
        Document cifIncorrecto = new Cif();
        cifIncorrecto.setDocumentNumber("W9696294A");
        Boolean esValido5 = cifIncorrecto.validate();
        cifIncorrecto.consolePrint(cifIncorrecto.documentNumber, esValido5);

    }

    private static void printTitle() {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");
    }


}