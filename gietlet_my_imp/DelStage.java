package gitlet;



import java.util.HashSet;
import java.util.*;

import static gitlet.Repository.DEL_STAGE;
import static gitlet.Utils.*;

public class DelStage {

    // .gitlet/del_stage ----> serlized hashSet of a bunch of file names;

    static void init() {
        try {
            DEL_STAGE.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeObject(DEL_STAGE, new HashSet<String>());
    }

    static Set<String> fileSet() {
        return readObject(DEL_STAGE, HashSet.class);
    }

    static void add(String name) {
        HashSet<String> delSet = new HashSet<>(DelStage.fileSet());
        delSet.add(name);
        writeObject(DEL_STAGE, delSet);
    }

    static void del(String name) {
        HashSet<String> delSet = new HashSet<>(DelStage.fileSet());
        delSet.remove(name);
        writeObject(DEL_STAGE, delSet);
    }

    static void clear() {
        writeObject(DEL_STAGE, new HashSet<String>());
    }





}
