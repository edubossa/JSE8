package br.com.ews.jse8.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wallace on 20/06/16.
 */
public class Developer {

    private String name;
    private Set<String> languages =  new HashSet<>();

    public Developer(String name) {
        this.name = name;
    }

    public void add(String language) {
        this.languages.add(language);
    }

    public Set<String> getLanguages() {
        return languages;
    }
}
