package com.bookMyShow.bookMyShow.Repositories;

import com.bookMyShow.bookMyShow.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepo extends JpaRepository<ShowSeat,Long> {


    public Optional<ShowSeat> findById(Long showSeatId);

    @Lock(LockModeType.PESSIMISTIC_READ)
    public List<ShowSeat> findAllById(List<Long> showSeatId);
}
