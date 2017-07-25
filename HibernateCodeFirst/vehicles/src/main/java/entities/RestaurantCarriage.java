package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_carriage")
public class RestaurantCarriage extends BasicCarriage{

    private Integer tablesCount;

    public RestaurantCarriage() {
    }

    @Column(name = "tables_count")
    public Integer getTablesCount() {
        return tablesCount;
    }

    public void setTablesCount(Integer tablesCount) {
        this.tablesCount = tablesCount;
    }
}
