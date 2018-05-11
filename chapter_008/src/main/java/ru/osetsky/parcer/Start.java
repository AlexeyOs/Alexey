package ru.osetsky.parcer;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import sun.reflect.generics.tree.Tree;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static org.quartz.JobBuilder.newJob;

/**
 * Created by koldy on 20.04.2018.
 */
public class Start {

    public static void main(String[] args) throws IOException, SQLException {
//        try {
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//            scheduler.start();
//            scheduler.shutdown();
//        } catch (SchedulerException se) {
//            se.printStackTrace();
//        }
        Parser parser = new Parser();
        // Парсит страницы начиная с первой вакансии.
        int page = 1;
        DbConnect dbConnect = new DbConnect();
        dbConnect.deleteTable();
        // Парсит страницы пока на страницах есть вакансии.
        while (true) {
            Document document = parser.getDocumentFromURL(page);
            Set<Vacancy> set = null;
            set = parser.getAllVacanciesFromDocument(document);
            if (set.isEmpty()) {
                break;
            }
            parser.getJavaFilterVacanciesFromDocument(document, dbConnect);
            page++;
        }
        // фиксирует изменения в базе
        dbConnect.commit();
        //выводит в консоль новые вакансии из базы данных.
        List<Vacancy> arr = dbConnect.getAllItems();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).getName() + " " + arr.get(i).getUrl());
        }
    }




}
