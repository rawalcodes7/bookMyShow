package com.bookMyShow.bookMyShow.Controller;



import com.bookMyShow.bookMyShow.DTO.ResponseStatus;
import com.bookMyShow.bookMyShow.DTO.bookTicketRequestDTO;
import com.bookMyShow.bookMyShow.DTO.bookTicketResponseDTO;
import com.bookMyShow.bookMyShow.Service.TicketService;
import com.bookMyShow.bookMyShow.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    public  TicketController( TicketService ticketService){
        this.ticketService=ticketService;
    }
    public bookTicketResponseDTO bookTicker(bookTicketRequestDTO bookTicketRequestDTO){
        try {
            Ticket ticket = ticketService.bookTicket(bookTicketRequestDTO.getUserId(),
                    bookTicketRequestDTO.getShowId(),
                    bookTicketRequestDTO.getSeatIds());
            bookTicketResponseDTO bookTicketResponseDTO = new bookTicketResponseDTO();
            bookTicketResponseDTO.setTicket(ticket);
            bookTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return bookTicketResponseDTO;
        }
        catch (Exception e){
            bookTicketResponseDTO bookTicketResponseDTO=new bookTicketResponseDTO();
            bookTicketResponseDTO.setResponseStatus(ResponseStatus.FAILED);
            return bookTicketResponseDTO;
        }
    }
}
