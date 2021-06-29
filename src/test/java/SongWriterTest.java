import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class SongWriterTest {

    private SongWriter songWriter = new SongWriter();

    @Test
    void songWithOneAnimal() {
        String song = songWriter.writeSong(List.of("Z"));
        String compare = """
                There was an old lady who swallowed a Z
                I don't know why she swallowed a Z - perhaps she'll die!
                """;

        assertThat(song).isEqualTo(compare);
    }

    @Test
    void songWithTwoAnimals() {
        String song = songWriter.writeSong(List.of("Z", "A"));
        String compare = """
                There was an old lady who swallowed a Z
                I don't know why she swallowed a Z - perhaps she'll die!
                
                There was an old lady who swallowed a A...
                ...She's dead, of course!""";
        assertThat(song).isEqualTo(compare);
    }

    @Test
    void songWithThreeAnimals() {
        String song = songWriter.writeSong(List.of("Z", "Y", "A"));
        String compare = """
                There was an old lady who swallowed a Z
                I don't know why she swallowed a Z - perhaps she'll die!
                  
                There was an old lady who swallowed a Y;
                That wriggled and wiggled and tickled inside her.
                She swallowed the Y to catch the Z;
                I don't know why she swallowed a Z - perhaps she'll die!   
                
                There was an old lady who swallowed a A...
                ...She's dead, of course!""";
        assertThat(song).isEqualTo(compare);
    }

    @Test
    void songWithFourAnimals() {
        String song = songWriter.writeSong(List.of("Z", "Y", "X", "A"));
        String compare = """
                There was an old lady who swallowed a Z
                I don't know why she swallowed a Z - perhaps she'll die!
                  
                There was an old lady who swallowed a Y;
                That wriggled and wiggled and tickled inside her.
                She swallowed the Y to catch the Z;
                I don't know why she swallowed a Z - perhaps she'll die!    
                
                There was an old lady who swallowed a X;
                How absurd to swallow a X!
                She swallowed the X to catch the Y;
                She swallowed the Y to catch the Z;
                I don't know why she swallowed a Z - perhaps she'll die!   
                
                There was an old lady who swallowed a A...
                ...She's dead, of course!""";
        assertThat(song).isEqualTo(compare);
    }

    @Test
    void songWithOGAnimals() {
        String song = songWriter.writeSong(List.of("fly", "spider", "bird", "cat", "dog", "cow", "horse"));
        assertThat(song).isEqualTo(
                """
                        There was an old lady who swallowed a fly.
                        I don't know why she swallowed a fly - perhaps she'll die!

                        There was an old lady who swallowed a spider;
                        That wriggled and wiggled and tickled inside her.
                        She swallowed the spider to catch the fly;
                        I don't know why she swallowed a fly - perhaps she'll die!

                        There was an old lady who swallowed a bird;
                        How absurd to swallow a bird!
                        She swallowed the bird to catch the spider,
                        She swallowed the spider to catch the fly;
                        I don't know why she swallowed a fly - perhaps she'll die!

                        There was an old lady who swallowed a cat;
                        Fancy that to swallow a cat!
                        She swallowed the cat to catch the bird,
                        She swallowed the bird to catch the spider,
                        She swallowed the spider to catch the fly;
                        I don't know why she swallowed a fly - perhaps she'll die!

                        There was an old lady who swallowed a dog;
                        What a hog, to swallow a dog!
                        She swallowed the dog to catch the cat,
                        She swallowed the cat to catch the bird,
                        She swallowed the bird to catch the spider,
                        She swallowed the spider to catch the fly;
                        I don't know why she swallowed a fly - perhaps she'll die!

                        There was an old lady who swallowed a cow;
                        I don't know how she swallowed a cow!
                        She swallowed the cow to catch the dog,
                        She swallowed the dog to catch the cat,
                        She swallowed the cat to catch the bird,
                        She swallowed the bird to catch the spider,
                        She swallowed the spider to catch the fly;
                        I don't know why she swallowed a fly - perhaps she'll die!

                        There was an old lady who swallowed a horse...
                        ...She's dead, of course!""");
    }
}