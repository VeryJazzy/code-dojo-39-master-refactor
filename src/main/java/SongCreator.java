import java.util.ArrayList;
import java.util.List;

class SongCreator {

    private final ArrayList<String> caughtAnimals = new ArrayList<>();
    private final ArrayList<String> rhymes = new ArrayList<>();
    private String firstAnimal;

    public SongCreator() {
        rhymes.add("That wriggled and wiggled and tickled inside her.");
        rhymes.add("How absurd to swallow a ");
        rhymes.add("Fancy that to swallow a ");
        rhymes.add("What a hog, to swallow a ");
        rhymes.add("I don't know how she swallowed a ");
    }

    public String writeSong(List<String> animals) {
        firstAnimal = animals.get(0);
        StringBuilder song = new StringBuilder();
        int rhymeIndex = 0;

        for (int i = 0; i < animals.size(); i++) {
            if (i == 0) {
                song.append(writeFirstParagraph(animals.get(i)));
            } else if (i == animals.size() - 1) {
                song.append(finalParagraph(animals.get(i)));
            } else {
                String rhyme = writeRhyme(rhymeIndex, animals.get(i));
                song.append(writeRegularParagraph(animals.get(i), animals.get(i - 1), rhyme));
                rhymeIndex++;
            }
        }
        return song.toString();
    }

    private String writeRhyme(int rhymeIndex, String animal) {
        if (rhymeIndex == 0) {
            return rhymes.get(0);
        }
        return String.format("%s%s!",rhymes.get(rhymeIndex), animal);
    }

    private String writeRegularParagraph(String animal, String previousAnimal, String rhyme) {
        caughtAnimals.add(sheSwallowedTwoToCatchOne(animal, previousAnimal));
        StringBuilder allTheCaughtAnimals = new StringBuilder();

        for (int i = caughtAnimals.size() - 1; i > -1; i--) {
            allTheCaughtAnimals.append(caughtAnimals.get(i)).append("\n");
        }

        return "\n" +
                firstLine(animal) +
                "\n" +
                rhyme +
                "\n" +
                allTheCaughtAnimals +
                lastLine();
    }

    private String writeFirstParagraph(String animal) {
        return String.format("There was an old lady who swallowed a %s.", animal) +
                "\n" +
                lastLine();
    }

    private String finalParagraph(String animal) {
        return String.format("""
                
                There was an old lady who swallowed a %s...
                ...She's dead, of course!""", animal);
    }

    private String sheSwallowedTwoToCatchOne(String current, String previous) {
        return String.format("She swallowed the %s to catch the %s,", current, previous);
    }

    private String firstLine(String animal) {
        return String.format("There was an old lady who swallowed a %s;", animal);
    }

    private String lastLine() {
        return String.format("I don't know why she swallowed a %s - perhaps she'll die!\n", firstAnimal);
    }
}