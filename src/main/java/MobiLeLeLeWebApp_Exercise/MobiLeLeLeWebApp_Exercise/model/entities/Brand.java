package MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    private String name;
    private Instant created;
    private Instant modified;

    public Brand() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column()
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    @Column()
    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Brand{").append("name='").append(name).append('\'')
                .append(", created=").append(created).append(", modified=").append(modified)
                .append('}').toString();
    }
}
