package gitlet;



import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

import static gitlet.Utils.serialize;
import static gitlet.Utils.sha1;


/** Represents a gitlet commit object.
 *
 *  does at a high level.
 *
 *  @author TODO
 */
class Commit implements Serializable {

    String message;
    Date time;
    Commit parent;
    Commit otherParent;
    Map<String, String> nameShaMap;

    Commit(String inputMsg, Commit inputParent) {
        this.message = inputMsg;
        if (inputParent == null) {
            this.time = new Date(0);
        } else {
            this.time = new Date();
        }
        this.parent = inputParent;
        this.otherParent = null;
        this.nameShaMap = new HashMap<>();
    }

    /*
    here, for Commit c,
    c.fileSet returns Set<fileNames> of all files that this Commit records;
    c.add adds name-sha pair;
    c.del removes name-sha pair;
    c.fetch get sha by name;
     */

    Set<String> fileSet() {
        return this.nameShaMap.keySet();
    }

    void add(String name, String sha) {
        this.nameShaMap.put(name, sha);
    }

    void del(String name) {
        this.nameShaMap.remove(name);
    }

    String forceFetch(String name) {
        return this.nameShaMap.get(name);
    }












    List<Commit> ancestersList() {

        List<Commit> ancestorList = new LinkedList<>();
        Queue<Commit> fringe = new LinkedList<>();
        Set<Commit> marked = new HashSet<>();

        fringe.add(this);
        marked.add(this);
        ancestorList.add(this);

        while (!fringe.isEmpty()) {
            Commit v = fringe.remove();
            List<Commit> parOfV = new ArrayList<>();
            if (v.parent != null) {
                parOfV.add(v.parent);
            }
            if (v.otherParent != null) {
                parOfV.add(v.otherParent);
            }
            for (Commit w : parOfV) {
                if (!marked.contains(w)) {
                    fringe.add(w);
                    marked.add(w);
                    ancestorList.add(w);
                }
            }
        }
        return ancestorList;
    }

    void printThisLog() {
        System.out.println("===");
        System.out.println("commit " + sha1(serialize(this)));
        // Adjust the format to remove timezone offset, and match the required format
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy Z", Locale.ENGLISH);
        System.out.println("Date: " + dateFormat.format(this.time));  // Prints without timezone offset
        System.out.println(this.message);
        System.out.println("");
    }

    void printLogFromThis() {
        this.printThisLog();
        if (this.parent != null) {
            this.parent.printLogFromThis();
        }
    }








}
