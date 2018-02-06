package ru.javazen.nlp.association.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "word_association")
public class WordAssociation {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String word;

    @Column
    private String association;

    @Column(name = "part_of_Speech")
    @JsonProperty("part_of_Speech")
    private String partOfSpeech;

    @Column
    private String dir;

    @Column
    private double weight;

    @Column(name = "mirror_weight")
    @JsonProperty("mirror_weight")
    private double mirrorWeight;

    @Column(name = "is_safe")
    @JsonProperty("is_safe")
    private boolean isSafe;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMirrorWeight() {
        return mirrorWeight;
    }

    public void setMirrorWeight(double mirrorWeight) {
        this.mirrorWeight = mirrorWeight;
    }

    public boolean isSafe() {
        return isSafe;
    }

    public void setSafe(boolean safe) {
        isSafe = safe;
    }
}
