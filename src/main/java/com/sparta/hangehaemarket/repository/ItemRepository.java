package com.sparta.hangehaemarket.repository;

import com.sparta.hangehaemarket.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
