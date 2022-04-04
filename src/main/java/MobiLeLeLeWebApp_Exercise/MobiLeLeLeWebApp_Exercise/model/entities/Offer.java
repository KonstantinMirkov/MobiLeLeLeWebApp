package MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities;

import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities.enums.Engine;
import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities.enums.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.*;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    private String description;
    private Engine engine;
    private String imageUrl;
    private int mileAge;
    private BigDecimal price;
    private Transmission transmission;
    private int year;
    private Instant created;
    private Instant modified;
    private Model model;
    private User user;

    public Offer() {
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "mile_age")
    public int getMileAge() {
        return mileAge;
    }

    public void setMileAge(int mileAge) {
        this.mileAge = mileAge;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Enumerated(EnumType.STRING)
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Column
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(nullable = false)
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    @Column(nullable = false)
    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    @ManyToOne
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
