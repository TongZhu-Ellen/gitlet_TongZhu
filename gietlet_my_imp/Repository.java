package gitlet;

import java.io.File;
import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {
    /**
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    public static final File COMMIT_DIR = join(GITLET_DIR, "commit_dir");
    public static final File BLOB_DIR = join(GITLET_DIR, "blob_dir");
    public static final File ADD_STAGE = join(GITLET_DIR, "add_stage");
    public static final File DEL_STAGE = join(GITLET_DIR, "del_stage");




}
