package syksy2024.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import syksy2024.bookstore.domain.AppUser;
import syksy2024.bookstore.domain.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) 
    throws UsernameNotFoundException {
        AppUser curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(
            username, curruser.getPasswordHash(),
            AuthorityUtils.createAuthorityList(curruser.getRole())
        );
        return user;
    }
}
