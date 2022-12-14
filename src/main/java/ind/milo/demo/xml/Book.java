package ind.milo.demo.xml;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String name;
    private String author;
    private int year;
    private double price;
}
