package gitlet;

import static gitlet.Repository.COMMIT_DIR;
import static gitlet.Utils.*;


import java.util.*;


public class CommitDir {

   // .gitlet_dir/commit_dir/sha_of_Commit ----> serlized(Commit itself);

    static void init() {
        COMMIT_DIR.mkdir();
    }

    static Set<String> fileSet() {
        return GitletDir.filesInDir(COMMIT_DIR);
    }

    static void add(Commit cm) {
        writeObject(join(COMMIT_DIR, sha1(serialize(cm))), cm);
    }

    static void del(String sha) {
        join(COMMIT_DIR, sha).delete();
    }

    static Commit forceFetch(String sha) {
        return readObject(join(COMMIT_DIR, sha), Commit.class);
    }





}
