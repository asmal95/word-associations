package ru.javazen.nlp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javazen.nlp.association.entity.WordAssociation;
import ru.javazen.nlp.association.repository.WordAssociationRepository;
import ru.javazen.nlp.association.service.WordAssociationService;

import java.util.Set;

@RestController
@RequestMapping(path = "associations")
public class WordAssociationController {


    private WordAssociationService wordAssociationService;

    @Autowired
    public void setWordAssociationService(WordAssociationService wordAssociationService) {
        this.wordAssociationService = wordAssociationService;
    }

    @GetMapping(path = "find/{word}")
    private Set<String> findAssociations(@PathVariable("word") String word) {
        return wordAssociationService.findAssociations(word);
    }

}
