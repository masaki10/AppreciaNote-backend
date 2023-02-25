package com.taketeru.apprecianote.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taketeru.apprecianote.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}