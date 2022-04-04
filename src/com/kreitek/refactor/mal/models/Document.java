package com.kreitek.refactor.mal.models;

import com.kreitek.refactor.mal.interfaces.DocumentPrint;
import com.kreitek.refactor.mal.interfaces.DocumentValidation;

public abstract class Document implements DocumentPrint, DocumentValidation {
    protected String documentNumber;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public abstract boolean validate();

    @Override
    public abstract void consolePrint(String documentNumber, boolean isValidated);
}
