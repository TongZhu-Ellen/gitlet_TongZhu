package gitlet;

import java.util.*;

import static gitlet.Repository.ADD_STAGE;
import static gitlet.Utils.*;

public class AddStage {

    // .gitlet/add_stage/name ----> content;

    static void init() {
        ADD_STAGE.mkdir();
    }

    static Set<String> fileSet() {
        return GitletDir.filesInDir(ADD_STAGE);
    }

    static void add(String name, byte[] cont) {
        writeContents(join(ADD_STAGE, name), cont);
    }

    static void del(String name) {
        join(ADD_STAGE, name).delete();
    }

    static byte[] forceFetch(String name) {
        return readContents(join(ADD_STAGE, name));
    }

    static void clear() {
        HashSet<String> addSet = new HashSet<>(AddStage.fileSet());
        for (String name: addSet) {
            AddStage.del(name);
        }
    }
}
