package MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities;

import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities.enums.Category;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {
    private String name;
    private Category category;
    private String imageUrl;
    private int startYear;
    private Integer endYear;
    private Instant created;
    private Instant modified;

    private Brand brand;



    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "image_url", length = 512)

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "start_year", nullable = false)
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    @Column(name = "end_year", nullable = false)
    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }
    @ManyToOne
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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


    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", created=" + created +
                ", modified=" + modified +
                ", brand=" + brand +
                '}';
    }
}
