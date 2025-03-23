package com.uneecops.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uneecops.common.entity.Items;

public interface ItemRepo extends JpaRepository<Items , String>{

}
