package com.cj.manager;

import com.cj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * UserRepository 简介
 *
 * @author caojun44
 * @date 2025-03-07
 **/

public interface UserRepository extends JpaRepository<User, Long> {
}
