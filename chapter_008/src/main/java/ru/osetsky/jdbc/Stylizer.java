package ru.osetsky.jdbc;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;


public class Stylizer {

    /*
     * Данный класс отвечает за преобразование файла 1.xml в 2.xml.
     */
    private Document document;

    public void xmlEdit() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            File stylesheet = new File("C:\\projects\\Alexey\\chapter_008\\src\\main\\java\\ru\\osetsky\\jdbc\\article1a.xsl");
            File datafile = new File("C:\\projects\\Alexey\\chapter_008\\src\\main\\java\\ru\\osetsky\\jdbc\\1.xml");

            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(datafile);

            // Используется трансформатор для вывода
            TransformerFactory tFactory = TransformerFactory.newInstance();
            StreamSource stylesource = new StreamSource(stylesheet);
            Transformer transformer = tFactory.newTransformer(stylesource);

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("C:\\projects\\Alexey\\chapter_008\\src\\main\\java\\ru\\osetsky\\jdbc\\2.xml"));
            transformer.transform(source, result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
