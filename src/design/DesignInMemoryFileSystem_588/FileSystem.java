package design.DesignInMemoryFileSystem_588;

import java.util.*;

public class FileSystem implements IFileSystem {
    // https://leetcode.com/articles/design-in-memory-file-system/
    private Dir root;

    private class Dir {
        Map<String, Dir> dirs = new HashMap<>();
        Map<String, String> files = new HashMap<>();
    }

    FileSystem() {
        root = new Dir();
    }

    // tc O(m + n + k*logk), m - path length, n - depth of last dir level,
    // k - the number of entries(files + subdirectories) in the last level directory
    public List<String> ls(String path) {
        List<String> files = new ArrayList<>();
        Dir t = root;
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length - 1; i++) {
                t = t.dirs.get(d[i]);
            }
            if (t.files.containsKey(d[d.length - 1])) {
                files.add(d[d.length - 1]);
                return files;
            } else {
                t = t.dirs.get(d[d.length - 1]);
            }
        }
        files.addAll(new ArrayList<>(t.dirs.keySet()));
        files.addAll(new ArrayList<>(t.files.keySet()));
        Collections.sort(files);
        return files;
    }

    // tc O(m + n)
    public void mkdir(String path) {
        Dir t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!t.dirs.containsKey(d[i])) {
                t.dirs.put(d[i], new Dir());
            }
            t = t.dirs.get(d[i]);
        }
    }

    // tc O(m + n)
    public void addContentToFile(String filePath, String content) {
        Dir t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.dirs.get(d[i]);
        }
        t.files.merge(d[d.length - 1], content, String::concat);
    }

    // tc O(m + n)
    public String readContentFromFile(String filePath) {
        Dir t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.dirs.get(d[i]);
        }
        return t.files.get(d[d.length - 1]);
    }

    @Override
    public String toString() {
        return "FileSystem";
    }
}
