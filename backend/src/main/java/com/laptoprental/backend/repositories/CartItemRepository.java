package com.laptoprental.backend.repositories;

import com.laptoprental.backend.entity.Cartitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<Cartitem, Long> {
}
