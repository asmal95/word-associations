package ru.javazen.nlp.association.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javazen.nlp.association.entity.WordAssociation;
import ru.javazen.nlp.association.repository.WordAssociationRepository;

import java.util.*;

@Service
public class WordAssociationServiceImpl implements WordAssociationService {

    private WordAssociationRepository wordAssociationRepository;

    private Map<String, Set<String>> associations = new HashMap<>();

    @Autowired
    public void setWordAssociationRepository(WordAssociationRepository wordAssociationRepository) {
        this.wordAssociationRepository = wordAssociationRepository;
    }

    @Override
    public Set<String> findAssociations(String word) {
        List<WordAssociation> wordAssociations = wordAssociationRepository.findByWordAndWeightGreaterThan(word, 0.5);
        if (associations.containsKey(word)) {
            return associations.get(word);
        }
        Set<String> res = new HashSet<>();
        for (WordAssociation wordAssociation : wordAssociations) {
            res.add(wordAssociation.getAssociation());
        }
        associations.put(word, res);
        return res;
    }
}
