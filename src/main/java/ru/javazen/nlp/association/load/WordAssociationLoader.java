package ru.javazen.nlp.association.load;

import ru.javazen.nlp.association.entity.WordAssociation;

import java.util.List;

public interface WordAssociationLoader {

    List<WordAssociation> loadAssociations();
}
