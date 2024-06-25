package ejercicio1;

import java.util.ArrayList;

public class ChapterBOOK {

    public static void main(String[] args) {
        // Aquí puedes crear instancias de Chapter, Section, y ComponentSection
        // y probar la estructura que has definido.
    }
}

// Clase Chapter representa un capítulo que contiene secciones.
class Chapter {

    ArrayList<Section> sections;

    public Chapter(ArrayList<Section> sections) {
        this.sections = sections;
    }
}

// Clase Section representa una sección dentro de un capítulo que contiene ComponentSection.
class Section {

    ArrayList<ComponentSection> componentsSections;

    public Section(ArrayList<ComponentSection> componentsSections) {
        this.componentsSections = componentsSections;
    }
}

// Clase ComponentSection es una clase base para los componentes de una sección.
class ComponentSection {
}

// Clase Figure representa una figura que puede estar dentro de una sección.
class Figure extends ComponentSection {

    public Figure() {
        // Constructor vacío
    }
}

// Clase Paragraph representa un párrafo que puede contener juicios (judgments).
class Paragraph extends ComponentSection {

    ArrayList<Judgment> judgments;

    public Paragraph(ArrayList<Judgment> judgments) {
        this.judgments = judgments;
    }
}

// Clase Judgment representa un juicio que contiene palabras (words).
class Judgment {

    ArrayList<Word> words;

    public Judgment(ArrayList<Word> words) {
        this.words = words;
    }
}

// Clase Word representa una palabra.
class Word {
}
