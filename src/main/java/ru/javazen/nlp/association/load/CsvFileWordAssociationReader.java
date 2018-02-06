package ru.javazen.nlp.association.load;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.javazen.nlp.association.entity.WordAssociation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

@Service
public class CsvFileWordAssociationReader implements WordAssociationLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvFileWordAssociationReader.class);

    private String setPath;

    @Value("${associations.resource:none}")
    public void setSetPath(String setPath) {
        this.setPath = setPath;
    }

    @Override
    public List<WordAssociation> loadAssociations() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream assocStream = classLoader.getResourceAsStream(setPath);

        List<WordAssociation> wordAssociations = new ArrayList<>();

        Stream<String> stringStream = new BufferedReader(new InputStreamReader(assocStream))
                .lines();

        stringStream.forEach(str -> {
                StringTokenizer tokenizer = new StringTokenizer(str, ";");
                if (tokenizer.countTokens() < 7) { return; }

                try {
                    String word = tokenizer.nextToken();
                    String association = tokenizer.nextToken();
                    String partOfSpeech = tokenizer.nextToken();
                    String dir = tokenizer.nextToken();
                    double weight = Double.valueOf(tokenizer.nextToken());
                    double mirrorWeight = Double.valueOf(tokenizer.nextToken());
                    boolean isSafe = Boolean.valueOf(tokenizer.nextToken());

                    WordAssociation wordAssoc = new WordAssociation();
                    wordAssoc.setWord(word);
                    wordAssoc.setAssociation(association);
                    wordAssoc.setPartOfSpeech(partOfSpeech);
                    wordAssoc.setPartOfSpeech(dir);
                    wordAssoc.setWeight(weight);
                    wordAssoc.setMirrorWeight(mirrorWeight);
                    wordAssoc.setSafe(isSafe);

                    wordAssociations.add(wordAssoc);
                } catch (Exception e) {
                    LOGGER.error("Can't load association: {}", str, e);
                }
        });
        LOGGER.debug("{} associations loaded", wordAssociations.size());
        return wordAssociations;
    }

}
