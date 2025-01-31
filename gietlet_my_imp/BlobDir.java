package gitlet;

import java.util.*;

import static gitlet.Repository.BLOB_DIR;
import static gitlet.Utils.*;

public class BlobDir {

    // .gitlet_dir/blob_dir/sha_of_file ----> serlized(file);

    static void init() {
        BLOB_DIR.mkdir();
    }

    static Set<String> fileSet() {
        return GitletDir.filesInDir(BLOB_DIR);
    }

    static void add(byte[] cont) {
        writeContents(join(BLOB_DIR, sha1(cont)), cont);
    }

    static void del(String sha) {
        join(BLOB_DIR, sha).delete();
    }

    static byte[] forceFetch(String sha) {
        return readContents(join(BLOB_DIR, sha));
    }

}
