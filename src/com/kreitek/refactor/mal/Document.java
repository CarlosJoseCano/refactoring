package com.kreitek.refactor.mal;

import java.util.Date;

public abstract class Document implements DocumentPrint,DocumentValidation{
    protected String documentNumber;
    protected Date validityDate;


    public Document(String documentNumber, Date validityDate) {
        this.documentNumber = documentNumber;
        this.validityDate = validityDate;

    }

    @Override
    public abstract boolean validate();

    @Override
    public abstract void consolePrint(String documentNumber, boolean isValidated);
}
