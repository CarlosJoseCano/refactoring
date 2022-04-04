package com.kreitek.refactor.mal.factories;

import com.kreitek.refactor.mal.models.Cif;
import com.kreitek.refactor.mal.models.Document;

public class CifFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new Cif();
    }
}
