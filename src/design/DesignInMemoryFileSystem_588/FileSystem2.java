package design.DesignInMemoryFileSystem_588;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem2 implements IFileSystem {
    private File root;

    private class File {
        boolean isfile = false;
        Map<String, File> files = new HashMap<>();
        String content = "";
    }

    FileSystem2() {
        root = new File();
    }

    // tc O(m + n + k*logk), m - path length, n - depth of last dir level,
    // k - the number of entries(files + subdirectories) in the last level directory
    public List<String> ls(String path) {
        File t = root;
        List<String> files = new ArrayList<>();
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length; i++) {
                t = t.files.get(d[i]);
            }
            if (t.isfile) {
                files.add(d[d.length - 1]);
                return files;
            }
        }
        List<String> res_files = new ArrayList<>(t.files.keySet());
        Collections.sort(res_files);
        return res_files;
    }

    // tc O(m + n)
    public void mkdir(String path) {
        File t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!t.files.containsKey(d[i])) {
                t.files.put(d[i], new File());
            }
            t = t.files.get(d[i]);
        }
    }

    // tc O(m + n)
    public void addContentToFile(String filePath, String content) {
        File t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.files.get(d[i]);
        }
        if (!t.files.containsKey(d[d.length - 1])) {
            t.files.put(d[d.length - 1], new File());
        }
        t = t.files.get(d[d.length - 1]);
        t.isfile = true;
        t.content += content;
    }

    // tc O(m + n)
    public String readContentFromFile(String filePath) {
        File t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.files.get(d[i]);
        }
        return t.files.get(d[d.length - 1]).content;
    }

    @Override
    public String toString() {
        return "FileSystem-2";
    }
}
