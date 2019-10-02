package pl.coreslab.day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/form2")
public class Form2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String text = request.getParameter("text");
        String accept = request.getParameter("accept");

        if (accept == null) {
            text = doCensor(text);
        }
        response.getWriter()
                .append("<h4>Twój tekst to:<h4>")
                .append("<p>")
                .append(text)
                .append("</p>")
                .append("<a href='/form2'>back</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/form2.html").forward(request, response);
    }

    private String doCensor(String text) {
//        for (int i = 0; i < CENSORED_WORDS.length; i++) {
//                 text.replaceAll(CENSORED_WORDS[i], asterisk(CENSORED_WORDS[i]));
//        }
//
//        return text;

        String censored = "";
        StringTokenizer stringTokenizer = new StringTokenizer(text);
        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken();
            if (CENSORED_WORDS.contains(word.toLowerCase())) {
                censored += asterisk(word) + " ";
            } else {
                censored += word + " ";
            }
        }
        return censored;
    }

    private String asterisk(String word) {
        String text = "";
        for (int i = 0; i < word.length(); i++) {
            text += "*";
        }
        return text;
    }

    //private static final String[] CENSORED_WORDS = new String[]{"cholera", "dupa", "kurka"};
    private static final Set<String> CENSORED_WORDS = new HashSet<>(Arrays.asList("cholera", "dupa", "kurka"));
}
