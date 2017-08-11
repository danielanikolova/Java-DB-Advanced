package game.store.models.bindingModel.user;


import game.store.enums.Role;

public class LoggedInUser {

    private Long Id;
    private Role role;
    private String fullName;


    public LoggedInUser() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
