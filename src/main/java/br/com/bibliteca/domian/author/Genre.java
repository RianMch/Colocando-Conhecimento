package br.com.bibliteca.domian.author;

public enum Genre {

    FICTION("Fiction", "Ficção"),
    NON_FICTION("Non-fiction", "Não Ficção"),
    MYSTERY("Mystery", "Mistério"),
    FANTASY("Fantasy", "Fantasia"),
    SCIENCE_FICTION("Science Fiction", "Ficção Científica"),
    BIOGRAPHY("Biography", "Biografia"),
    ROMANCE("Romance", "Romance"),
    HORROR("Horror", "Terror"),
    POETRY("Poetry", "Poesia"),
    HISTORY("History", "História"),
    THRILLER("Thriller", "Suspense");

    private final String englishName;
    private final String portugueseName;

    Genre(String englishName, String portugueseName) {
        this.englishName = englishName;
        this.portugueseName = portugueseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getPortugueseName() {
        return portugueseName;
    }

    @Override
    public String toString() {
        return portugueseName + " (" + englishName + ")";
    }
}

