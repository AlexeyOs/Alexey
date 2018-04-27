package ru.osetsky.parcerSQLru;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import sun.reflect.generics.tree.Tree;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by koldy on 20.04.2018.
 */
public class Start {


    public static void main(String[] args) throws IOException, SQLException {
        Parser parser = new Parser();
        int page = 630;
        DbConnect dbConnect = new DbConnect();
        dbConnect.deleteTable();
        while (true) {
            Document document = parser.getDocumentFromURL(page);
            Set<Vacancy> set = null;
            set = parser.getAllVacanciesFromDocument(document);
            if (set.isEmpty()) {
                break;
            }
            parser.getJavaVacanciesFromDocument(document, dbConnect);
            page++;
        }
        List<String> arr = new ArrayList<>();
        arr = dbConnect.getAllItems();
        for(int i = 0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }


}
