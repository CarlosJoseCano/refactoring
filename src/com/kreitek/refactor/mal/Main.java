package com.kreitek.refactor.mal;

class  Main
{
    public static void main(String args[])
    {
        printTitle();

        // creamos un DNI correcto
        Document dniCorrecto = new Nif("11111111H", null);
        Boolean esValido = dniCorrecto.validate();
        dniCorrecto.consolePrint(dniCorrecto.documentNumber, esValido);

        // creamos un DNI incorrecto
        Document dniIncorrecto01 = new Nif("24324356A", null);
        Boolean esValido1 = dniIncorrecto01.validate();
        dniIncorrecto01.consolePrint(dniIncorrecto01.documentNumber, esValido1);

        // creamos un NIE correcto
        Document nieCorrecto = new Nie("X0932707B", null);
        Boolean esValido2 = nieCorrecto.validate();
        nieCorrecto.consolePrint(nieCorrecto.documentNumber, esValido2);


        // creamos un NIE incorrecto
        Document nieIncorrecto = new Nie("Z2691139Z", null);
        Boolean esValido3 = nieIncorrecto.validate();
        nieIncorrecto.consolePrint(nieIncorrecto.documentNumber, esValido3);


        // creamos un CIF correcto
        Document cifCorrecto = new Cif( "W9696294I", null);
        Boolean esValido4 = cifCorrecto.validate();
        cifCorrecto.consolePrint(cifCorrecto.documentNumber, esValido4);

        // creamos un CIF incorrecto
        Document cifIncorrecto = new Cif("W9696294A", null);
        Boolean esValido5 = cifIncorrecto.validate();
        cifIncorrecto.consolePrint(cifIncorrecto.documentNumber, esValido5);

    }

    private static void printTitle() {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");
    }


}