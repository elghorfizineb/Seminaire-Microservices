package org.security.authenthicationapp.repositories;

import org.security.authenthicationapp.entities.AppRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AppRolesRepository extends JpaRepository<AppRoles,Long> {

    AppRoles findAppRolesByRoleName(String rolename);
}
