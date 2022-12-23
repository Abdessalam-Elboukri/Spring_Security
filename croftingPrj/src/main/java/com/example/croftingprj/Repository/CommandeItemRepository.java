package com.example.croftingprj.Repository;

import com.example.croftingprj.Entities.CommandeItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeItemRepository extends JpaRepository<CommandeItems , Long> {
}
