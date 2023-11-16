package mk.ukim.finki.wp.lab.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.service.TicketOrderService;
import mk.ukim.finki.wp.lab.service.impl.MovieServiceImpl;
import mk.ukim.finki.wp.lab.service.impl.TicketOrderImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/servlet/ticketOrder")
public class TicketOrderServlet extends HttpServlet {

    private final MovieServiceImpl inMemoryService;
    private final SpringTemplateEngine springTemplateEngine;

    private final TicketOrderService inMemoryTIcketOrder;

    public TicketOrderServlet(MovieServiceImpl inMemoryService, SpringTemplateEngine springTemplateEngine, TicketOrderService inMemoryTIcketOrder) {
        this.inMemoryService = inMemoryService;
        this.springTemplateEngine = springTemplateEngine;
        this.inMemoryTIcketOrder = inMemoryTIcketOrder;
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context =  new WebContext(webExchange);
//
//        context.setVariable("movie", req.getParameter("title"));
//        context.setVariable("numTickets", req.getParameter("ticket"));
//
////        String title = req.getParameter("title");
////        String ticket = req.getParameter("ticket");
//
//        springTemplateEngine.process(
//                "orderConfirmation.html",
//                context,
//                resp.getWriter()
//        );
    }

    //TODO: da se dopravi
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("movie"); //gi zimame od html names kako parametri
        int ticket = Integer.parseInt(req.getParameter("numTickets"));

//        req.setAttribute("title", title);
//        req.setAttribute("ticket", ticket);

        TicketOrder order = inMemoryTIcketOrder.placeOrder(title, "Stefan Tosev", req.getRemoteAddr(), ticket);  //instancirame objekt od ticket

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context =  new WebContext(webExchange);

        context.setVariable("adress", order.getClientAddress());
        context.setVariable("name", order.getClientName());
        context.setVariable("movie",title);
        context.setVariable("numTickets", ticket);

        springTemplateEngine.process(
                "orderConfirmation.html",
                context,
                resp.getWriter()
        );


    }
}
