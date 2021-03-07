package local.unichome;

import java.io.Serializable;
import java.util.Objects;

/**
 * Пользователь
 */
public class TelegramUser implements Serializable {
    private static final long serialVersionUID = -3295590026052296594L;

    private String uID;
    private boolean subscribe = false;


    TelegramUser(String id){
        this.uID = id;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public String getuID() {
        return uID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelegramUser that = (TelegramUser) o;
        return Objects.equals(uID, that.uID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uID);
    }
}
