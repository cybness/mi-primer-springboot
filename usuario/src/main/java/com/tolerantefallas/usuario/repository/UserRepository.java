package com.tolerantefallas.usuario.repository;

import com.tolerantefallas.usuario.entity.Userz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<Userz,Long> {
    Userz findByUserId(Long userId);
}
