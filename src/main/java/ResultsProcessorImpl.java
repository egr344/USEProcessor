import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ResultsProcessorImpl implements ResultsProcessor {

    public ResultsProcessorImpl(List<Integer> scores) {
        this.scores = scores;
    }

    private List<Integer> scores;

    @Override
    public int getResultsForExam(File key, File answer) {
        int results = 0;
        Map<Integer, String> keyMap = parseFile(key);
        Map<Integer, String> answerMap = parseFile(answer);
        for (Integer numberAnswer : keyMap.keySet()) {
            if (keyMap.get(numberAnswer).equals(answerMap.get(numberAnswer))) {
                if (numberAnswer <= 4)
                    results += scores.get(0);
                else if (numberAnswer <= 9)
                    results += scores.get(1);
                else if (numberAnswer <= 10)
                    results += scores.get(2);
            }
        }
        return results;
    }

    private Map<Integer, String> parseFile(File file) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            return fileReader.lines().map(line -> line.trim().split("-"))
                    .collect(Collectors.toMap(p -> Integer.parseInt(p[0].trim()), p -> p[1].trim()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

}
