package ind.milo.demo.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLDemo {
    // Reference https://www.jianshu.com/p/71f51ed9da4d
    private static DocumentBuilderFactory dBuilderFactory = null;
    private static DocumentBuilder dBuilder = null;
    private static Document document = null;
    private static List<Book> books = null;
    static {
        try {
            /**
             * 要读入一个XML文档，首先要有一个DocumentBuilder对象 可以从DocumentBuilderFactory中得到这个对象
             */
            dBuilderFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static List<Book> listBooks(String filename) throws SAXException, IOException {
        List<Book> books=new ArrayList<Book>();
        // 可通过DocumentBuilder对象的parse()方法读入整个文档
        Document document = dBuilder.parse(filename);
        // 获得根节点，books.xml对应的就是bookstore节点
        Element root = document.getDocumentElement();
        // 输出根节点的名字，bookstore
        System.out.println(root.getTagName());
        // 获得所有的book节点
        NodeList children = root.getChildNodes();
        //循环遍历各个book节点
        for (int i = 0; i < children.getLength(); i++) {
            //获得第i个book节点
            Node child = children.item(i);
            //用来存储第i个节点的内容
            List<String> bookAttrbuteContent=new ArrayList<String>();
            Book book=new Book();
            /**
             * 这里要注意的是dom会把两个节点之间的空白字符也当做节点 要判断是否是子元素，
             * 而不是空白字符，这个可以参照 《Java核心技术卷 二》的解析XML文档章节，有详细的解释
             */

            if (child instanceof Element) {
                Element childElement = (Element) child;
                int bookId=Integer.parseInt(childElement.getAttribute("id"));
                System.out.println(bookId);
                book.setId(bookId);
                NodeList bookAttrbuteList = childElement.getChildNodes();
                // 循环遍历book节点的各个子节点，如name,author...
                for (int j = 0; j < bookAttrbuteList.getLength(); j++) {
                    Node bookAttrbute = bookAttrbuteList.item(j);
                    if (bookAttrbute instanceof Element) {
                        String content=bookAttrbute.getTextContent().trim();
                        System.out.println(
                                ((Element) bookAttrbute).getTagName() + ":" + content);
                        bookAttrbuteContent.add(content);
                    }
                }
                book.setName(bookAttrbuteContent.get(0));
                book.setAuthor(bookAttrbuteContent.get(1));
                book.setYear(Integer.parseInt(bookAttrbuteContent.get(2)));
                book.setPrice(Integer.parseInt(bookAttrbuteContent.get(3)));
                books.add(book);
            }
        }
        return books;
    }

    public static void main(String args[]) {
        String fileName = "F:\\GitHubNote\\HSTools\\src\\main\\java\\ind\\milo\\demo\\xml\\books.xml";
        try {
            List<Book> books=XMLDemo.listBooks(fileName);
            for(Book book:books) {
                System.out.println(book);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
