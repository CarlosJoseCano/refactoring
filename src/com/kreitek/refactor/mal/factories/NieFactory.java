package com.kreitek.refactor.mal.factories;

import com.kreitek.refactor.mal.models.Document;
import com.kreitek.refactor.mal.models.Nie;

public class NieFactory extends DocumentFactory{

    @Override
    public Document createDocument() {
        return new Nie();
    }
}
