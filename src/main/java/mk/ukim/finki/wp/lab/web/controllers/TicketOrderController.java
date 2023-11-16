package mk.ukim.finki.wp.lab.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.service.impl.MovieServiceImpl;
import mk.ukim.finki.wp.lab.service.impl.TicketOrderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {

    private final TicketOrderImpl ticketOrder;
    private final MovieServiceImpl movieService;

    public TicketOrderController(TicketOrderImpl ticketOrder, MovieServiceImpl movieService) {
        this.ticketOrder = ticketOrder;
        this.movieService = movieService;
    }



    @PostMapping
    public String getMoviesPage(HttpServletRequest request,
                                @RequestParam(required = false) Integer numTickets,
                                @RequestParam(required = false) String movie,
                                Model model) {

        TicketOrder order = ticketOrder.placeOrder(movie, "Stefan Tosev", request.getRemoteAddr(), numTickets);
        model.addAttribute("adress", request.getRemoteAddr());
        model.addAttribute("name", order.getClientName());
        model.addAttribute("movie", movie);
        model.addAttribute("numTickets",numTickets);

        return "orderConfirmation.html";
    }


}
