import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoordinatesFileReader {

    private Stream<String> linesStream;

    public CoordinatesFileReader(String filePath) {
        try {
            linesStream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getListFromFile(String separator) {
        return linesStream.map(s -> s.split(separator)).collect(Collectors.toList());
    }




}
