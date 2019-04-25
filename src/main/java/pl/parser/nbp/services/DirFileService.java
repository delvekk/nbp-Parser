package pl.parser.nbp.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface DirFileService {

    File loadFile() throws IOException;
    Set<String> createUrlStringsFromExistingTablesInFile(List<String> dateStrings) throws IOException;
}
