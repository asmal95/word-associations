package ru.javazen.nlp.association.repository;

import org.springframework.data.repository.CrudRepository;
import ru.javazen.nlp.association.entity.WordAssociation;

import java.util.List;

public interface WordAssociationRepository extends CrudRepository<WordAssociation, Long> {

    List<WordAssociation> findByWord(String word);

    List<WordAssociation> findByAssociation(String association);

    List<WordAssociation> findByWordAndWeightGreaterThan(String word, Double than);

    List<WordAssociation> findByAssociationAndMirrorWeightGreaterThan(String association, Double than);
}
