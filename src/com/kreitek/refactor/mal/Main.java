package com.kreitek.refactor.mal;

import com.kreitek.refactor.mal.factories.CifFactory;
import com.kreitek.refactor.mal.factories.DocumentFactory;
import com.kreitek.refactor.mal.factories.NieFactory;
import com.kreitek.refactor.mal.factories.NifFactory;
import com.kreitek.refactor.mal.models.Document;

class  Main
{
    private static DocumentFactory documentFactory;

    public static void main(String args[])
    {

        printTitle();
        printNif();
        printNie();
        printCif();

    }

    private static void printCif() {

        documentFactory= new CifFactory();

        Document correctCif = documentFactory.createDocument();
        correctCif.setDocumentNumber("W9696294I");
        correctCif.consolePrint(correctCif.getDocumentNumber(), correctCif.validate());

        Document incorrectCif = documentFactory.createDocument();
        incorrectCif.setDocumentNumber("W9696294A");
        incorrectCif.consolePrint(incorrectCif.getDocumentNumber(), incorrectCif.validate());
    }

    private static void printNie() {

        documentFactory= new NieFactory();

        Document correctNie = documentFactory.createDocument();
        correctNie.setDocumentNumber("X0932707B");
        correctNie.consolePrint(correctNie.getDocumentNumber(), correctNie.validate());

        Document incorrectNie = documentFactory.createDocument();
        incorrectNie.setDocumentNumber("Z2691139Z");
        incorrectNie.consolePrint(incorrectNie.getDocumentNumber(), incorrectNie.validate());
    }

    private static void printNif() {

        documentFactory= new NifFactory();

        Document correctNif = documentFactory.createDocument();
        correctNif.setDocumentNumber("11111111H");
        correctNif.consolePrint(correctNif.getDocumentNumber(), correctNif.validate());

        Document incorrectNif = documentFactory.createDocument();
        incorrectNif.setDocumentNumber("24324356A");
        incorrectNif.consolePrint(incorrectNif.getDocumentNumber(), incorrectNif.validate());
    }

    private static void printTitle() {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");
    }


}