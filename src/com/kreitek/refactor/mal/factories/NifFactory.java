package com.kreitek.refactor.mal.factories;

import com.kreitek.refactor.mal.models.Document;
import com.kreitek.refactor.mal.models.Nif;

public class NifFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new Nif();
    }
}
