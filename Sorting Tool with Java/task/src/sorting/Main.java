package sorting;

import java.io.*;
import java.util.*;

/**
 * The Main class provides functionality to sort and process various types of data
 * including words, lines, and numbers. The sorting can be performed in natural
 * order or by frequency count. The application supports reading from and writing
 * to files, as well as working with standard input and output.
 *
 * Functionality includes:
 * - Parsing command-line arguments to specify sorting type, data type, input file, and output file.
 * - Initializing input and output mechanisms based on the provided arguments.
 * - Sorting and processing data based on the specified configurations.
 * - Providing informative output for the sorted data and their frequency counts.
 *
 * Supported command-line arguments:
 * - "-sortingType": Specifies the sorting type. Valid values are "natural" or "byCount".
 * - "-dataType": Specifies the type of data to process. Valid values are "word", "line", or "long".
 * - "-inputFile": Specifies the input file to read data from. If not provided, reads from standard input.
 * - "-outputFile": Specifies the output file to write data to. If not provided, writes to standard output.
 *
 * Throws IllegalArgumentException if mandatory arguments are missing or invalid.
 * Throws IOException for file-related issues during initialization or processing.
 */
public class Main {

    private enum DataType {
        WORD("words"),
        LONG("longs"),
        LINE("lines");

        private final String label;

        DataType(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }

    private enum SortingType {
        NATURAL,
        BY_COUNT
    }

    private static Scanner scanner;
    private static PrintWriter writer;
    private static boolean writingToFile = false;
    private static SortingType sortingType = SortingType.NATURAL;
    private static DataType dataType = DataType.WORD;
    private static String inputFile = null;
    private static String outputFile = null;

    public static void main(final String[] args) {
        try {
            parseArgs(args);
            initIO();

            switch (dataType) {
                case LONG -> sortLongs();
                case LINE -> sortLines();
                case WORD -> sortWords();
            }
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (writer != null && writingToFile) {
                writer.close();
            }
        }
    }

    private static void parseArgs(String[] args) {
        Map<String, String> options = new HashMap<>();
        List<String> unknownArgs = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            switch (arg) {
                case "-sortingType", "-dataType", "-inputFile", "-outputFile" -> {
                    if (i + 1 >= args.length || args[i + 1].startsWith("-")) {
                        if (arg.equals("-sortingType")) {
                            throw new IllegalArgumentException("No sorting type defined!");
                        }
                        if (arg.equals("-dataType")) {
                            throw new IllegalArgumentException("No data type defined!");
                        }
                        continue;
                    }
                    options.put(arg, args[++i]);
                }
                default -> unknownArgs.add(arg);
            }
        }

        if (options.containsKey("-sortingType")) {
            String type = options.get("-sortingType");
            switch (type) {
                case "natural" -> sortingType = SortingType.NATURAL;
                case "byCount" -> sortingType = SortingType.BY_COUNT;
                default -> throw new IllegalArgumentException("No sorting type defined!");
            }
        }

        if (options.containsKey("-dataType")) {
            String type = options.get("-dataType");
            switch (type) {
                case "word" -> dataType = DataType.WORD;
                case "line" -> dataType = DataType.LINE;
                case "long" -> dataType = DataType.LONG;
                default -> throw new IllegalArgumentException("No data type defined!");
            }
        }

        if (options.containsKey("-inputFile")) {
            inputFile = options.get("-inputFile");
        }

        if (options.containsKey("-outputFile")) {
            outputFile = options.get("-outputFile");
        }

        for (String arg : unknownArgs) {
            System.out.println("\"" + arg + "\"" + " is not a valid parameter. It will be skipped.");
        }
    }

    private static void initIO() throws IOException {
        if (inputFile != null) {
            try {
                scanner = new Scanner(new File(inputFile));
            } catch (FileNotFoundException e) {
                throw new IOException("Input file not found");
            }
        } else {
            scanner = new Scanner(System.in);
        }

        if (outputFile != null) {
            writer = new PrintWriter(new FileWriter(outputFile));
            writingToFile = true;
        } else {
            writer = new PrintWriter(System.out, true);
            writingToFile = false;
        }
    }

    private static void sortLongs() {
        List<Long> longs = readLongs();

        if (sortingType == SortingType.NATURAL) {
            Collections.sort(longs);
            printInfo(longs, DataType.LONG);
        } else {
            sortByCount(longs, DataType.LONG);
        }
    }

    private static List<Long> readLongs() {
        List<Long> result = new ArrayList<>();
        while (scanner.hasNext()) {
            String number = scanner.next();
            try {
                long value = Long.parseLong(number);
                result.add(value);
            } catch (NumberFormatException e) {
                System.out.println("\"" + number + "\"" + " is not a long. It will be skipped.");
            }
        }
        return result;
    }

    private static void sortLines() {
        List<String> lines = readLines();

        if (sortingType == SortingType.NATURAL) {
            Collections.sort(lines);
            printInfo(lines, DataType.LINE);
        } else {
            sortByCount(lines, DataType.LINE);
        }
    }

    private static List<String> readLines() {
        List<String> result = new ArrayList<>();
        while (scanner.hasNextLine()) {
            result.add(scanner.nextLine());
        }
        return result;
    }

    private static void sortWords() {
        List<String> words = readWords();

        if (sortingType == SortingType.NATURAL) {
            Collections.sort(words);
            printInfo(words, DataType.WORD);
        } else {
            sortByCount(words, DataType.WORD);
        }
    }

    private static List<String> readWords() {
        List<String> result = new ArrayList<>();
        while (scanner.hasNext()) {
            result.add(scanner.next());
        }
        return result;
    }

    private static <T> void sortByCount(List<T> list, DataType type) {
        int total = list.size();
        Map<T, Long> counts = new TreeMap<>();

        for (T value : list) {
            counts.put(value, counts.getOrDefault(value, 0L) + 1);
        }

        printInfo(counts, total, type);
    }

    private static void printInfo(List<?> list, DataType type) {
        writer.printf("Total %s: %d.%n", type.label(), list.size());
        writer.print("Sorted data: ");
        for (Object o : list) {
            writer.print(o + " ");
        }
        writer.println();
    }

    private static void printInfo(Map<?, Long> map, int counter, DataType type) {
        writer.printf("Total %s: %d.%n", type.label(), counter);

        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(entry -> {
                    long count = entry.getValue();
                    long percent = counter == 0 ? 0 : count * 100 / counter;
                    writer.printf("%s: %d time(s), %d%%%n",
                            entry.getKey(), count, percent);
                });
    }
}
