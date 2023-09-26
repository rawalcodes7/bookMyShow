package com.bookMyShow.bookMyShow.Service;

import com.bookMyShow.bookMyShow.Exception.ShowSeatNtAvailableException;
import com.bookMyShow.bookMyShow.Repositories.ShowSeatRepo;
import com.bookMyShow.bookMyShow.models.ShowSeat;
import com.bookMyShow.bookMyShow.models.ShowSeatState;
import com.bookMyShow.bookMyShow.models.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {

    private ShowSeatRepo showSeatRepo;

    public TicketService(ShowSeatRepo showSeatRepo){
        this.showSeatRepo=showSeatRepo;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(long userId, long showId, List<Long> seatIds)
            throws ShowSeatNtAvailableException {

//        Step 1: Checking Availability
        List<ShowSeat> showSeats= showSeatRepo.findAllById(seatIds);
        for(ShowSeat s:showSeats){
            if(s.getState()!= ShowSeatState.AVAILABLE){
                throw new ShowSeatNtAvailableException(s.getId());
            }
        }
//        Step 2: Else Book Ticket

//        Step Intermediate: Lock the seats while the payment is being done!

        for(ShowSeat s:showSeats){
            s.setState(ShowSeatState.LOCKED);
            showSeatRepo.save(s);
        }


//        Step 3: After Successful payment
        for(ShowSeat s:showSeats){
            s.setState(ShowSeatState.BOOKED);
            showSeatRepo.save(s);
        }
//        Step 4: Return Ticket after setting all the values
        Ticket ticket=new Ticket(); // NOTE: values hasn't been set yet!

        return null;
    }
}
