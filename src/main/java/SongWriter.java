import java.util.ArrayList;
import java.util.List;

class SongWriter {

    private String firstAnimal;
    private ArrayList<String> caughtAnimals = new ArrayList<>();
    private ArrayList<String> rhymes = new ArrayList<>();

    public SongWriter() {
        rhymes.add("That wriggled and wiggled and tickled inside her.");
        rhymes.add("How absurd to swallow a ");
        rhymes.add("Fancy that to swallow a ");
        rhymes.add("What a hog, to swallow a ");
        rhymes.add("I don't know how she swallowed a ");
    }

    public String writeSong(List<String> animals) {
        StringBuilder song = new StringBuilder();
        firstAnimal = animals.get(0);
        String rhyme = "That wriggled and wiggled and tickled inside her.";
        int rhymeIndex = 0;

        for (int i = 0; i < animals.size(); i++) {
            if (i == 0) {
                song.append(writeFirstParagraph(animals.get(i)));
            } else if (i == animals.size() - 1) {
                song.append(finalParagraph(animals.get(i)));
            } else {
                song.append(writeRegularParagraph(animals.get(i), animals.get(i - 1), writeRhyme(rhymes, rhymeIndex, animals.get(i))));
                rhymeIndex++;
            }
        }
        return song.toString();
    }

    private String writeRhyme(ArrayList<String> rhymes, int rhymeIndex, String animal) {
        if (rhymeIndex == 0) {
            return rhymes.get(0);
        }
        return String.format("%s%s!",rhymes.get(rhymeIndex), animal);
    }

    private String writeRegularParagraph(String animal, String previousAnimal, String rhyme) {
        caughtAnimals.add(oneToCatchTwo(animal, previousAnimal));
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

    private String oneToCatchTwo(String current, String previous) {
        return String.format("She swallowed the %s to catch the %s;", current, previous);
    }

    private String firstLine(String animal) {
        return String.format("There was an old lady who swallowed a %s;", animal);
    }

    private String lastLine() {
        return String.format("I don't know why she swallowed a %s - perhaps she'll die!\n", firstAnimal);
    }
}