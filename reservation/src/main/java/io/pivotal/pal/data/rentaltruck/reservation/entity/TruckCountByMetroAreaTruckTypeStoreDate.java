package io.pivotal.pal.data.rentaltruck.reservation.entity;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Objects;

import static com.datastax.driver.core.DataType.Name.COUNTER;

@Table("truck_count_by_metro_area_truck_type_store_date")
public class TruckCountByMetroAreaTruckTypeStoreDate {

    @PrimaryKey
    private final TruckCountByMetroAreaTruckTypeStoreDateKey key;

    @Column("count_on_hand")
    @CassandraType(type = COUNTER)
    private Long countOnHand;

    public TruckCountByMetroAreaTruckTypeStoreDate(TruckCountByMetroAreaTruckTypeStoreDateKey key,
                                                   Long countOnHand) {
        this.key = key;
        this.countOnHand = countOnHand;
    }

    private TruckCountByMetroAreaTruckTypeStoreDate() {
        this.key = null;
        this.countOnHand = null;
    }

    public TruckCountByMetroAreaTruckTypeStoreDateKey getKey() {
        return key;
    }

    public Long getCountOnHand() {
        return countOnHand;
    }

    public void setCountOnHand(Long countOnHand) {
        this.countOnHand = countOnHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckCountByMetroAreaTruckTypeStoreDate that = (TruckCountByMetroAreaTruckTypeStoreDate) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "TruckCountByMetroAreaTruckTypeStoreDate{" +
                "key=" + key +
                ", countOnHand=" + countOnHand +
                '}';
    }
}
