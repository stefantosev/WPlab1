package mk.ukim.finki.wp.lab.web.servlets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.service.impl.MovieServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet (urlPatterns = "/servlet/movies")
public class MovieListServlet  extends HttpServlet {

    private final MovieServiceImpl inMemoryService;
    private final SpringTemplateEngine springTemplateEngine;

    public MovieListServlet(SpringTemplateEngine springTemplateEngine, MovieServiceImpl inMemoryService) {
        this.inMemoryService = inMemoryService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context =  new WebContext(webExchange);

        //da se izlistaat site filmovi
        context.setVariable("Movies", inMemoryService.listAll());


        if(req.getParameter("searchedMovie") !=null && req.getParameter("searchedRating") !=null) {
            String searchedMovie = req.getParameter("searchedMovie");
            double searchedRating = Double.parseDouble(req.getParameter("searchedRating"));


            List<Movie> movies = inMemoryService.listAll().stream()
                    .filter(m -> m.getTitle().toLowerCase().contains(searchedMovie.toLowerCase())
                            && m.getRating() >= searchedRating)
                    .collect(Collectors.toList());

            if(!movies.isEmpty()){
                context.setVariable("movies", movies);
            }
        }

        springTemplateEngine.process(
                "listMovies.html",
                context,
                resp.getWriter()
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String title = req.getParameter("movie"); //gi zimame od html names
//        int ticket = Integer.parseInt(req.getParameter("numTickets"));
//
//        req.setAttribute("title", title);
//        req.setAttribute("ticket", ticket);
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/ticketOrder");
//        dispatcher.forward(req,resp);  //NE RABOTI

        //resp.sendRedirect("/ticketOrder");


    }
}
