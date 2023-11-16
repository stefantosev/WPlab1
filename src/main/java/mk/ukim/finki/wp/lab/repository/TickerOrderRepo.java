package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.TicketOrder;
import org.springframework.stereotype.Repository;

@Repository
public class TickerOrderRepo {

    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {
        return new TicketOrder(movieTitle, clientName, address, (long) numberOfTickets);
    }

}
