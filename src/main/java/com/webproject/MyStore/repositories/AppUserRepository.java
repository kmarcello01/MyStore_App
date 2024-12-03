package com.webproject.MyStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webproject.MyStore.models.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Integer>{

    public AppUser findByEmail(String email);
}
