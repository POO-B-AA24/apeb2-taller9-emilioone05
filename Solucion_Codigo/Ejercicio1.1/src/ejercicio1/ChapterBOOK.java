package ejercicio1;

import java.util.ArrayList;

public class ChapterBOOK {

    public static void main(String[] args) {

    }
}

class Chapter {

    ArrayList<Section> sections;

    public Chapter(ArrayList<Section> sections) {
        this.sections = sections;
    }
        

}

class Section {

    ArrayList<ComponentSection> ComponentsSections;

    public Section(ArrayList<ComponentSection> ComponentsSections) {
        this.ComponentsSections = ComponentsSections;
    }

}

class ComponentSection {
}

class Figure extends ComponentSection {

    public Figure() {
    }

}

class Paragraph extends ComponentSection {

    ArrayList<Judgment> judgments;

    public Paragraph(ArrayList<Judgment> judgments) {
        this.judgments = judgments;
    }

}

class Judgment {

    ArrayList<Word> words;

    public Judgment(ArrayList<Word> words) {
        this.words = words;
    }

}

class Word {
}
