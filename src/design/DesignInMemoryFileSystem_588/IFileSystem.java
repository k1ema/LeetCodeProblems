package design.DesignInMemoryFileSystem_588;

import java.util.List;

public interface IFileSystem {
    List<String> ls(String path);
    void mkdir(String path);
    void addContentToFile(String filePath, String content);
    String readContentFromFile(String filePath);
}
