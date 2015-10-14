package mn.chinbat.surgery.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrimaryKeyJoinColumn;

@MappedSuperclass
public abstract class IDEntity implements IdHavingEntity<Long> {
    private Long id;

    @Id
    @PrimaryKeyJoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

}
