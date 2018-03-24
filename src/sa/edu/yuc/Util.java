package sa.edu.yuc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Util {

    public static void save(String filename, Object saveIt) throws Exception {
        File file = new File (filename);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(saveIt);
        oos.close();
        fos.close();
    }
    
    public static Object load(String filename)throws Exception {
        File file = new File (filename);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object result = ois.readObject();
        ois.close();
        fis.close();
        return result;
    }    
}
