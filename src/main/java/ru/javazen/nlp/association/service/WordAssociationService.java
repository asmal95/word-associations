package ru.javazen.nlp.association.service;

import java.util.Set;

public interface WordAssociationService {
    Set<String> findAssociations(String word);
}
