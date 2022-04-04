package com.kreitek.refactor.mal;

import java.util.Date;

public abstract class Document implements DocumentPrint,DocumentValidation{
    protected String documentNumber;

    public Document() {
    }

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
