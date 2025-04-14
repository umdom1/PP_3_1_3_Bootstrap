package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entitys.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();

    Role findRoleById(Long id);
}
