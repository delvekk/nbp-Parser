package pl.parser.nbp.services;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirFileServiceImpl implements DirFileService {

    private static final String FILE_URL = "http://www.nbp.pl/kursy/xml/dir.txt";
    private static final String HOST_URL = "http://www.nbp.pl/kursy/xml/";
    private static final String XML_EXTENSION = ".xml";

    @Override
    public File loadFile() throws IOException {
        Path path = Path.of("dir.txt");
        URL url = new URL(FILE_URL);
        try(InputStream in = url.openStream()){
            Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
        }
        return new File("dir.txt");
    }

    @Override
    public Set<String> createUrlStringsFromExistingTablesInFile(List<String> dateStrings) throws IOException {
        File dirFile = loadFile();
        Set<String> urlStrings = new HashSet<>();
        Set<String> cTypeTableNames = findAllCTypeTables(dirFile);
        Set<String> tableNamesInRange = getTableNamesInGivenDates(cTypeTableNames, dateStrings);
        tableNamesInRange.forEach(tableName -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(HOST_URL);
            stringBuilder.append(tableName);
            stringBuilder.append(XML_EXTENSION);
            urlStrings.add(stringBuilder.toString());
        });
            return urlStrings;
    }

    private Set<String> findAllCTypeTables(File file) throws IOException {
        Set<String> cTypeTableNames;
        try (Stream<String> stream = new BufferedReader(new FileReader(file)).lines()) {
            cTypeTableNames = stream.filter(line -> line.contains("c")).map(line-> line.substring(line.indexOf("c"))).collect(Collectors.toSet());
        }
        return cTypeTableNames;
    }

    private Set<String> getTableNamesInGivenDates(Set<String> cTypeTableNames, List<String> dateStrings) {
        Set<String> properFileNamesSet = new HashSet<>();
        for(String dateString : dateStrings) {
            for(String cTypeTableName : cTypeTableNames) {
                if(cTypeTableName.contains(dateString)) {
                    properFileNamesSet.add(cTypeTableName);
                }
            }
        }
        return properFileNamesSet;
    }
}
