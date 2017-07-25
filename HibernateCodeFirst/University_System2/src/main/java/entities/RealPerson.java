package entities;

import javax.persistence.*;

@Entity
@Table(name = "real_person" )
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class RealPerson implements Person{
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public RealPerson() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    @Override
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
