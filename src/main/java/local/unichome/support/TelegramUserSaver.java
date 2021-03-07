package local.unichome.support;

import local.unichome.TelegramUser;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Транспорт
 */
public class TelegramUserSaver implements SaveSupport {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public boolean saveLog(String line, String data) {
        return false;
    }

    /**
     * записывает данные в файла
     */
    @Override
    public boolean save(Object obj) {
        try {
            FileOutputStream f = new FileOutputStream(new File("udata_tg_tukero_org\\",((TelegramUser) obj).getuID()));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(obj);

            o.close();
            f.close();
            return true;
        } catch (IOException e) {
            logger.warning("fileerr");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * считывает данные из файла
     * @param line название файла
     */
    @Override
    public Object load(String line) {
        try {
            FileInputStream fi = new FileInputStream("udata_tg_tukero_org\\" + line);
            ObjectInputStream oi = new ObjectInputStream(fi);

            TelegramUser userObj = (TelegramUser) oi.readObject();

            oi.close();
            fi.close();
            return userObj;
        } catch (IOException | ClassNotFoundException e) {
            logger.warning("fileerr");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * получает имена всех файлов в каталоге
     * @return список
     */
    @Override
    public ArrayList<String> getAllFilesName() {
        ArrayList<String> list = new ArrayList<>();
        try {
            File folder = new File("udata_tg_tukero_org\\");
            File[] listOfFiles = folder.listFiles();
            assert listOfFiles != null;
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    list.add(file.getName());
                    System.out.println(file.getName());
                }
            }
        } catch (NullPointerException ignore) {
            System.out.println("NullPointerException: Directory is not found!");
        }
        return list;
    }

    @Override
    public String getFileLastModified(String filename) {
        return null;
    }
}