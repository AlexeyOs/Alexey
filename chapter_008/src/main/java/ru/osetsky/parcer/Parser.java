package ru.osetsky.parcer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * Created by koldy on 24.04.2018.
 */
public class Parser {
    /**
     * Адрес сайта для парсинга.
     */
    private String siteUrl = "http://www.sql.ru/forum/job-offers/";
    /**
     * Поле которое хранит уникальные вакансии по Java технологии.
     */
    private List<Vacancy> vacanciesJava = new DbConnect().getAllItems();

    /**
     * Пустой конструктор для исключения SQLException.
     * @throws SQLException
     */
    public Parser() throws SQLException {
    }

    /**
     * Метод выскивает html страницу с сайта.
     * @param page
     * @return
     */
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

    /**
     * Метод вытаскивает все вакансии из html страниц.
     * @param document
     * @return
     * @throws SQLException
     */
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
    /**
     * Метод сортирует из всех вакансий, вакансии с Java технологией.
     */
    public List<Vacancy> getJavaFilterVacanciesFromDocument(Document document, DbConnect dbConnect) {
        Elements elements = document.select(".postslisttopic");
        boolean repeat = false;
        for (Element element : elements) {
            String s = element.toString();
            if (!s.contains("Важно")) {
                // Фильтруются Java вакансии
                if ((s.indexOf("Java") > 0 || s.indexOf("JAVA") > 0) && s.lastIndexOf("JavaScript") < 1 && s.lastIndexOf("Java Script") < 1 && s.lastIndexOf("Javascript") < 1) {
                    Vacancy vacancy = getVacancy(element);
                    // проверка вакансий на уникальность
                    if (!vacanciesJava.isEmpty()) {
                        for (Vacancy v : vacanciesJava) {
                            if (vacancy.equals(v)) {
                                repeat = true;
                            }
                        }
                    }
                    if (!repeat && vacancy != null) {
                        vacanciesJava.add(vacancy);
                        dbConnect.addIntoTable(vacancy.getName(), vacancy.getUrl());
                    }
                    repeat = false;
                }
            }
        }
        return vacanciesJava;
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
