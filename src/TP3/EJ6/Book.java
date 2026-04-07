package TP3.EJ6;

public class Book {
    private int id;
    private String autor;
    private String gender;
    private int publicationDate;
    private int qtyBooks;

    public Book(int id, String autor, String gender, int publicationDate, int qtyBooks) {
        this.id = id;
        this.autor = autor;
        this.gender = gender;
        this.publicationDate = publicationDate;
        this.qtyBooks = qtyBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getQtyBooks() {
        return qtyBooks;
    }

    public void setQtyBooks(int qtyBooks) {
        this.qtyBooks = qtyBooks;
    }
}
