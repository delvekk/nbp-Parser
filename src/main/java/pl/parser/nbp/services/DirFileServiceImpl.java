package pl.parser.nbp.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class DirFileServiceImpl implements DirFileService {

    private static final String FILE_URL = "https://www.nbp.pl/kursy/xml/dir.txt";
    private static final String HOST_URL = "http://www.nbp.pl/kursy/xml/";

    @Override
    public File loadFile() throws IOException {
        URL url = new URL(FILE_URL);
        return new File(url.getFile());
    }

    @Override
    public Set<String> createUrlStringsFromExistingTablesInFile(List<String> dateStrings) throws IOException {
        File dirFile = loadFile();
        Set<String> urlStrings = new HashSet<>();
        Set<String> cTypeTableNames = findAllCTypeTables(dirFile);
        Set<String> tableNamesInRange = getTableNamesInGivenDates(cTypeTableNames, dateStrings);
        StringBuilder stringBuilder = new StringBuilder();
        tableNamesInRange.forEach(tableName -> {
            stringBuilder.setLength(0);
            stringBuilder.append(HOST_URL);
            stringBuilder.append(tableName);
            urlStrings.add(stringBuilder.toString());
        });
        return urlStrings;
    }

    // 99 in ASCI - char 'c'
    private Set<String> findAllCTypeTables(File file) throws IOException {
        Set<String> cTypeTableNames = new HashSet<>();
        try (Stream<String> stream = new BufferedReader(new FileReader(file)).lines()) {
            stream.forEach(line -> {
                if (line.charAt(0) == 99) {
                    cTypeTableNames.add(line);
                }
            });
        }
        return cTypeTableNames;
    }

    private Set<String> getTableNamesInGivenDates(Set<String> cTypeTableNames, List<String> dateStrings) {
        Set<String> properFileNamesSet = new HashSet<>();
        dateStrings.forEach(dateString ->
                cTypeTableNames.forEach(tableFileName -> {
                    if (tableFileName.contains(dateString)) {
                        properFileNamesSet.add(tableFileName);
                    }
                }));
        return properFileNamesSet;
    }
}
