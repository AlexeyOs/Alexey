package ru.osetsky.jdbc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.sql.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Created by koldy on 01.02.2018.
 */
public class SQLStorage {
    /*
     * Поле для хранении индекса аттрибута во втором файле.
     */
    private int attrindex = 0;
    /*
     * Поле возвращает сумму элементов из файла 2.xml
     */
    private int getSum() {
        int i = 0;
        String fileName = "C:\\projects\\Alexey\\chapter_008\\src\\main\\java\\ru\\osetsky\\jdbc\\2.xml";
        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));
            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement() && xmlr.getName().toString().equals("entry")) {
                    i += Integer.parseInt(xmlr.getAttributeValue(attrindex));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return i;
    }
    private void writeIntoXml(List<Integer> arrxml) {
        Entries entries = new Entries();
        entries.setEntries(new ArrayList<Entry>());
        for (int i = 0; i < arrxml.size(); i++) {
            Entry emp1 = new Entry();
            // добавляют объекты из массива, который сформировался после select-а из базы
            emp1.setField(arrxml.get(i));
            //Добавляю объекты в массив
            entries.getEntries().add(emp1);
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal список записей в консоли
            //jaxbMarshaller.marshal(entries, System.out);

            //Marshal список записей в файле
            jaxbMarshaller.marshal(entries, new File("C:\\projects\\Alexey\\chapter_008\\src\\main\\java\\ru\\osetsky\\jdbc\\1.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {
        DbHandler dbHandler = new DbHandler();
        dbHandler.deleteTable();
        // Добавляем запись
        dbHandler.addIntoTable(10);
        dbHandler.commit();
        // Получаем все записи и вывожу их в консоль
        List<Integer> arr1 = dbHandler.getAllItems();
        SQLStorage sqlStorage = new SQLStorage();
        sqlStorage.writeIntoXml(arr1);
        Stylizer stylizer = new Stylizer();
        stylizer.xmlEdit();
        System.out.println("Сумма всех атрибутов " + sqlStorage.getSum());
    }
}
