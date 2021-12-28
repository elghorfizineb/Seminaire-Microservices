package org.security.authenthicationapp.services;

import org.security.authenthicationapp.entities.AppRoles;
import org.security.authenthicationapp.entities.AppUser;

import java.util.List;

public interface AccountService {

    AppUser addNewUser(AppUser user);
    AppRoles addNewRole(AppRoles newrole);
    void addRoleToUser(String username,String role);
    AppUser loadUserByUsername(String username);
    List<AppUser> list_users();
}
