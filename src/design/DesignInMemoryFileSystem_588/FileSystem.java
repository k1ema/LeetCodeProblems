package design.DesignInMemoryFileSystem_588;

import java.util.*;

/**
 * 588. Design In-Memory File System
 * https://leetcode.com/articles/design-in-memory-file-system/
 *
 * Design an in-memory file system to simulate the following functions:
 *
 * ls: Given a path in string format. If it is a file path, return a list that only contains
 * this file's name. If it is a directory path, return the list of file and directory names
 * in this directory. Your output (file and directory names together) should in lexicographic order.
 *
 * mkdir: Given a directory path that does not exist, you should make a new directory according
 * to the path. If the middle directories in the path don't exist either, you should create them
 * as well. This function has void return type.
 *
 * addContentToFile: Given a file path and file content in string format. If the file doesn't
 * exist, you need to create that file containing given content. If the file already exists,
 * you need to append given content to original content. This function has void return type.
 *
 * readContentFromFile: Given a file path, return its content in string format.
 *
 * Example:
 *
 * Input:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 *
 * Output:
 * [null,[],null,null,["a"],"hello"]
 *
 * Note:
 * You can assume all file or directory paths are absolute paths which begin with / and do not
 * end with / except that the path is just "/".
 * You can assume that all operations will be passed valid parameters and users will not attempt
 * to retrieve file content or list a directory or file that does not exist.
 * You can assume that all directory names and file names only contain lower-case letters, and
 * same names won't exist in the same directory.
 */
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

    // tc O(m)
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
