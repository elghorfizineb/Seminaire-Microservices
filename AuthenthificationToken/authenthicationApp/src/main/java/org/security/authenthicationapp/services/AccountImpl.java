package org.security.authenthicationapp.services;

import org.security.authenthicationapp.entities.AppRoles;
import org.security.authenthicationapp.entities.AppUser;
import org.security.authenthicationapp.repositories.AppRolesRepository;
import org.security.authenthicationapp.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class AccountImpl implements AccountService{

    @Autowired
    private AppUserRepository appUserRepo;
    @Autowired
    private AppRolesRepository appRolesRepo;


    @Override
    public AppUser addNewUser(AppUser user) {
        return appUserRepo.save(user);
    }

    @Override
    public AppRoles addNewRole(AppRoles newrole) {
        return appRolesRepo.save(newrole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser user1= appUserRepo.findAppUserByUsername(username);
        AppRoles role1 = appRolesRepo.findAppRolesByRoleName(role);
        user1.getAppRoles().add(role1);

    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepo.findAppUserByUsername(username);
    }

    @Override
    public List<AppUser> list_users() {
        return appUserRepo.findAll();
    }
}
