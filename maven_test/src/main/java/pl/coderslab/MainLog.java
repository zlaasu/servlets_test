package pl.coderslab;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class MainLog {

    private static final Logger log = LogManager.getLogger(MainLog.class);

    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("Arek", "Czarek", "Darek");
        List<String> reversed = Lists.reverse(names);
        System.out.println(reversed);

//        log.debug("Debug");
//        log.info("Info");
//        log.warn("Warn");
//        log.error("Error");
//        log.fatal("Fatal");
//
//        log.info("string: {}.", "Hello world");

//        Connection connect = Jsoup.connect("http://www.onet.pl/");
//        try {
//            Document document = connect.get();
//            Elements links = document.select("span.title");
//            for (Element elem : links) {
//                log.info(elem.text());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}