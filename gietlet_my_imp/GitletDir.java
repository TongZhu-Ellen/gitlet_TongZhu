package gitlet;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import static gitlet.Repository.GITLET_DIR;

public class GitletDir {
    void init() {
        try {
            GITLET_DIR.mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Set<String> filesInDir(File searchedDir) {
        Set<String> relativePathsSet = new HashSet<>();
        for (File file : searchedDir.listFiles()) {
            if (file.getName().equals(".gitlet")) {
                continue;
            }
            String relativePath = searchedDir.toPath().relativize(file.toPath()).toString();
            relativePathsSet.add(relativePath);  // 添加到 set，自动去重
        }
        return relativePathsSet;
    }


}
