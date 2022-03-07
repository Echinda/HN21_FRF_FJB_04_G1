package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.models.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
