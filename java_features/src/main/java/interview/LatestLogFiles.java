package interview;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class LatestLogFiles {

    public static void main(String[] args) {
        List<File> fileList = new ArrayList<>();

        fileList.stream()
                .sorted(Comparator.comparing(File::lastModified))
                .forEach(file -> {
                    Set<File> top3FilesOfEachService = new HashSet<>();
                    if (top3FilesOfEachService.isEmpty())
                         top3FilesOfEachService.add(file);
                    //else if (isContains(file, top3FilesOfEachService))

                });

    }

    private boolean isContains(File file, Set<File> top3FilesOfEachService) {
        return false;/*top3FilesOfEachService.stream()
                .anyMatch(f -> {
                    if (!f.getName().contains(file.getName()))
                        return true;
                });*/
    }
}

class LogDetail {
    private String fileName;
    private LocalDateTime localDateTime;

    public LogDetail(String fileName, LocalDateTime localDateTime) {
        this.fileName = fileName;
        this.localDateTime = localDateTime;
    }
}
