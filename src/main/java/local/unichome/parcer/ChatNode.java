package local.unichome.parcer;

import java.util.Objects;

public class ChatNode {
    private int id;
    private String author;
    private String message;

    public ChatNode(int id, String author, String message) {
        this.id = id;
        this.author = author;
        this.message = message;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public String printNode(){
        return author + ": " + message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatNode chatNode = (ChatNode) o;
        return id == chatNode.id && Objects.equals(author, chatNode.author) && Objects.equals(message, chatNode.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, message);
    }
}