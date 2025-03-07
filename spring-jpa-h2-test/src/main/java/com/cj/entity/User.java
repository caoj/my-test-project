package com.cj.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User 简介
 *
 * @author caojun44
 * @date 2025-03-07
 **/
@Entity
@Data
@Table(name = "`user`") // 转义保留字（H2 中 `user` 是保留字）
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name") // 显式指定列名
    private String name;
    @Column(name = "email")
    private String email;
}
