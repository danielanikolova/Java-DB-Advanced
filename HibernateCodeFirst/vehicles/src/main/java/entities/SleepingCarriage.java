package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sleeping_carriages")
public class SleepingCarriage extends BasicCarriage{
    private Integer bedsCount;

    public SleepingCarriage() {
    }

    @Column(name = "beds_count")
    public Integer getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(Integer bedsCount) {
        this.bedsCount = bedsCount;
    }
}
