package ua.com.feiron.domain;

import javax.persistence.*;

@Entity
@Table(name = "profnastil")
public class Pn {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "WORK_B")
    private Double work_b;

    @Column(name = "BASE_B")
    private Double base_b;

    @Column(name = "A")
    private Double a;

    @Column(name = "B")
    private Double b;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWork_b() {
        return work_b;
    }

    public void setWork_b(Double work_B) {
        this.work_b = work_B;
    }

    public Double getBase_b() {
        return base_b;
    }

    public void setBase_b(Double bas_B) {
        this.base_b = bas_B;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }
}
