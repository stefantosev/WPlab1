package mk.ukim.finki.wp.lab.service.impl;


import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.service.MovieService;
import mk.ukim.finki.wp.lab.service.TicketOrderService;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderImpl  implements TicketOrderService {

    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {
        return new TicketOrder(movieTitle, clientName, address, (long) numberOfTickets);
    }
}
