package com.cg.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="guest_role")
public class GuestRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long guestRoleId;

    public GuestRole () {}

    public GuestRole (Guest guest, Role role) {
        this.guest = guest;
        this.role = role;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    public long getGuestRoleId() {
        return guestRoleId;
    }

    public void setGuestRoleId(long guestRoleId) {
        this.guestRoleId = guestRoleId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
