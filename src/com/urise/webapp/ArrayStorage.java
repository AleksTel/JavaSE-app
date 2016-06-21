import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.String.valueOf;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];

    void clear() {
        //for (int i = 0; i < storage.length; i++)
        //   storage[i] = null;

        Arrays.fill(storage, null);
    }

    void save(Resume r) {

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }

        }

    }

    String get(String uuid) {

        return uuid;
    }

    void delete(String uuid) {

        // System.out.println("delete(String uuid) " + uuid);
        for (int i = 0; i < storage.length; i++) {

            String s = valueOf(storage[i]);

            if (uuid.equals(s)) {
                storage[i] = null;

            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] storage1 = new Resume[size()];

       // try {
            for (int j = 0; j < storage1.length; j++) {
                for (int i = 0; i < storage.length; i++) {
                    if (storage[i] != null) {
                        storage1[j] = storage[i];
                        j++;
                        //System.out.println("storage1[j] " + j + " " + storage1[j]);


                    }
                }
            }
       // } catch (ArrayIndexOutOfBoundsException e){

         //   System.out.println("*************");

      //  }

        return storage1;
    }

    int size() {

        int y = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                y++;
            }
        }

        return y;
    }
}
