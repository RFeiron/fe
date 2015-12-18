package ua.com.feiron.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "DATE_CR")
    private Timestamp date_cr;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private Integer phone;

    @Column(name = "NOTE")
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate_cr() {
        return date_cr;
    }

    public void setDate_cr(Timestamp date_cr) {
        this.date_cr = date_cr;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
