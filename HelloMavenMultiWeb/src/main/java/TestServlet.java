

import HelloMavenMulti.TestEjbInterface;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by rakib on 8/1/16.
 */
@WebServlet(name = "test", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {

    @EJB
    private TestEjbInterface modelEjb;
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello Java EE</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<br>");
            out.println("<div align='center'>");
            out.println("<h2>Hello Java EE</h2>");
            out.println("Enter a message for Java EE which will pass through the web tier, the EJB tier to the database, and back again !");
            out.println("<br><br><br>");
            out.println("<form action='./WriteServlet' method='POST'>");
            out.println("<input type='submit' value='Enter'>");
            out.println("<input type='text' name='put_message'> ");
            out.println("</form>");
            out.println("<br>");
            String displayMessage;
            try {
                String storedMessage = modelEjb.testMethod();
                displayMessage = "Hello from (" + storedMessage + "), inside a web component";
            } catch (Exception nme) {
                displayMessage = "you should enter a value...";
            }
            out.println("The current message from Java EE: <br><b>"
                    + displayMessage + "</b>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
