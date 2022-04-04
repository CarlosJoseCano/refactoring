package com.kreitek.refactor.mal;

class  Main
{
    public static void main(String args[])
    {
        DocumentFactory documentFactory;
        printTitle();

        // creamos un DNI correcto
        documentFactory= new NifFactory();
        Document dniCorrecto = documentFactory.createDocument();
        dniCorrecto.setDocumentNumber("11111111H");
        Boolean esValido = dniCorrecto.validate();
        dniCorrecto.consolePrint(dniCorrecto.documentNumber, esValido);

        // creamos un DNI incorrecto
        documentFactory= new NifFactory();
        Document dniIncorrecto01 = documentFactory.createDocument();
        dniIncorrecto01.setDocumentNumber("24324356A");
        Boolean esValido1 = dniIncorrecto01.validate();
        dniIncorrecto01.consolePrint(dniIncorrecto01.documentNumber, esValido1);

        // creamos un NIE correcto
        documentFactory= new NieFactory();
        Document nieCorrecto = documentFactory.createDocument();
        nieCorrecto.setDocumentNumber("X0932707B");
        Boolean esValido2 = nieCorrecto.validate();
        nieCorrecto.consolePrint(nieCorrecto.documentNumber, esValido2);


        // creamos un NIE incorrecto
        documentFactory= new NieFactory();
        Document nieIncorrecto = documentFactory.createDocument();
        nieIncorrecto.setDocumentNumber("Z2691139Z");
        Boolean esValido3 = nieIncorrecto.validate();
        nieIncorrecto.consolePrint(nieIncorrecto.documentNumber, esValido3);


        // creamos un CIF correcto
        documentFactory= new CifFactory();
        Document cifCorrecto = documentFactory.createDocument();
        cifCorrecto.setDocumentNumber("W9696294I");
        Boolean esValido4 = cifCorrecto.validate();
        cifCorrecto.consolePrint(cifCorrecto.documentNumber, esValido4);

        // creamos un CIF incorrecto
        documentFactory= new NifFactory();
        Document cifIncorrecto = documentFactory.createDocument();
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