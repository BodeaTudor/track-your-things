package com.example.trackyourthings.persistence;

import com.example.trackyourthings.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
