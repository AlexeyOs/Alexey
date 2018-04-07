package ru.osetsky.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * Поле необходимое для подключения к базе данных.
     */
    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class);
    private String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
    private String username = "postgres";
    private String password = "1234";

    /*
     * Метод проверяет есть ли таблица, если нет, то создает, затем удялет все значения
     * и вставляет новые значния.
     */
    private List<Integer> create_table_insert_select(int countElements){
        List<Integer> arr = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        try {
            // соединене
            conn = DriverManager.getConnection(url, username, password);

            // создание таблицы в базе данных
            stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS TEST " +
                    "(field INTEGER not NULL)";
            stmt.executeUpdate(sql);

            // Удаление записей если они есть
            sql = "DELETE FROM TEST";
            stmt.executeUpdate(sql);

            //вставка
            for (int i = 0; i < countElements; i++) {
                PreparedStatement st = conn.prepareStatement("INSERT INTO test(field) values(?)");
                st.setInt(1, i);
                st.executeUpdate();
                st.close();
            }

            // создание таблицы в базе данных
            String query = "select field from TEST";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int field = rs.getInt(1);
                arr.add(field);
            }

        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
        return arr;
    }
    /*
     * Поле для хранении индекса аттрибута во втором файле.
     */
    private int attr_index = 0;
    /*
     * Поле возвращает сумму элементов в уже исправленном с помощью xlst xml файле.
     */
    private int getSum(){
        int i = 0;
        String fileName = "C:\\projects\\Alexey\\chapter_008\\src\\main\\java\\ru\\osetsky\\jdbc\\2.xml";
        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));
            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement() && xmlr.getName().toString().equals("entry")) {
                    i += Integer.parseInt(xmlr.getAttributeValue(attr_index));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return i;
    }
    /*
     * Берет элементы из базы данных и записывает их в xml файл.
     */
    private void write_into_xml(List<Integer> arrxml) {
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
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList();
        SQLStorage sqlStorage = new SQLStorage();
        arr = sqlStorage.create_table_insert_select(10000);
        sqlStorage.write_into_xml(arr);
        Stylizer stylizer = new Stylizer();
        stylizer.xmlEdit();
        System.out.println("Сумма всех атрибутов " + sqlStorage.getSum());
    }
}
