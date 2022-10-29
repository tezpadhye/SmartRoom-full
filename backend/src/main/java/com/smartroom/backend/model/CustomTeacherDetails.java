package com.smartroom.backend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class CustomTeacherDetails implements UserDetails {
    private final TeacherModel model;

    public CustomTeacherDetails(TeacherModel model) {
        this.model = model;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> roleSet = new HashSet<>();
        roleSet.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
        return roleSet;
    }

    @Override
    public String getPassword() {
        return model.getPassword();
    }

    @Override
    public String getUsername() {
        return model.getTeacherName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
