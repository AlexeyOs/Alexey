package ru.osetsky.parcerSQLru;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by koldy on 24.04.2018.
 */
public class Parser {
    private String siteUrl = "http://www.sql.ru/forum/job-offers/";
    public Document getDocumentFromURL(int page) {
        String request = siteUrl + "" + page;
        Document document = null;
        try {
            document = Jsoup.connect(request).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public Set<Vacancy> getAllVacanciesFromDocument(Document document) throws SQLException {
        Set<Vacancy> vacancies = new HashSet<>();
        Elements elements = document.select(".postslisttopic");
        for (Element element : elements) {
            String s = element.toString();
            if (!s.contains("Важно")) {
                    Vacancy vacancy = getVacancy(element);
                    if (vacancy != null) {
                        vacancies.add(vacancy);
                    }
            }
        }

        return vacancies;
    }

    public Set<Vacancy> getJavaVacanciesFromDocument(Document document, DbConnect dbConnect){
        Set<Vacancy> vacancies = new HashSet<>();
        Elements elements = document.select(".postslisttopic");
        for (Element element : elements) {
            String s = element.toString();
            if (!s.contains("Важно")) {
                if (s.indexOf("Java") > 0 && s.lastIndexOf("JavaScript") < 1 && s.lastIndexOf("Java Script") < 1) {
                    Vacancy vacancy = getVacancy(element);
                    if (vacancy != null) {
                        vacancies.add(vacancy);
                        dbConnect.addIntoTable(vacancy.getName(),vacancy.getUrl());
                        dbConnect.commit();
                    }
                }
            }
        }
        return vacancies;
    }

    public Vacancy getVacancy(Element element) {
        Vacancy vacancy = new Vacancy(
                getVacancyName(element),
                getVacancyUrl(element)
        );
        return vacancy;
    }
    public String getVacancyName(Element element) {
        return element.select("a").text();
    }
    public String getVacancyUrl(Element element) {
        return element.select("a").attr("href");
    }

}
