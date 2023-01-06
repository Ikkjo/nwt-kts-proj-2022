package com.suuber.persistence.models;

import java.util.Collection;
import java.util.UUID;

import lombok.Getter;
import org.jboss.aerogear.security.otp.api.Base32;
import javax.persistence.*;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name = "user_accounts")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
public abstract class User {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @Column( name = "first_name")
    protected String firstName;
    @Column( name = "last_name")
    protected String lastName;
    @Column( name = "email")
    protected String email;
    @Column( name = "password")
    protected String password;
    @Column( name = "enabled")
    protected boolean enabled;
    @Column( name = "secret")
    protected String secret;
    @Column( name = "roles")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    protected Collection<Role> roles;
    @Column( name = "chats")
    @ManyToMany
    protected Collection<Chat> chats;

    public User() {
        super();
        this.secret = Base32.random();
        this.enabled = false;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(final String username) {
        this.email = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setRoles(final Collection<Role> roles) {
        this.roles = roles;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((getEmail() == null) ? 0 : getEmail().hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User user = (User) obj;
        if (!getEmail().equals(user.getEmail())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String userString = "User [id=" +
                id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", enabled=" + enabled +
                ", secret=" + secret +
                ", roles=" + roles +
                "]";
        return userString;
    }

}
