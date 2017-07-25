package Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "occupancies")
public class Occupancy {

    private Long id;
    private Date dateOccupied;
    private Integer accountNumber;
    private Integer roomNumber;
    private Integer rateApplied;
    private Integer phoneCharge;
    private String notes;

    public Occupancy() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "dateOccupied")
    public Date getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(Date dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    @Column(name = "account_number")
    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(Integer rateApplied) {
        this.rateApplied = rateApplied;
    }

    public Integer getPhoneCharge() {
        return phoneCharge;
    }

    public void setPhoneCharge(Integer phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
