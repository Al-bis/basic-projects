package pl.coderstrust.numbers;

import java.util.ArrayList;
import java.util.List;

public class Processor {

    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String filePath, String resultFilePath) {
        List<String> linesFromFile = fileProcessor.readLinesFromFile(filePath);
        List<String> linesWithNumbers = extractNumbers(linesFromFile);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesWithNumbers) {
            resultLines.add(numbersProcessor.processLine(line));
        }
        fileProcessor.writeLinesToFile(resultLines, resultFilePath);
    }

    private List<String> extractNumbers(List<String> linesFromFile) {
        List<String> linesWithNumbers = new ArrayList<>();
        for (String line : linesFromFile) {
            if (line.matches("^[ 0-9]+$")) {
                linesWithNumbers.add(line);
            }
        }
        return linesWithNumbers;
    }
}
