package MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.view;

import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities.enums.Category;

public class ModelViewModel {
    private long id;
    private String name;
    private Category category;
    private String imageUrl;
    private int startYear;
    private Integer endYear;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    @Override
    public String toString() {
        return "ModelViewModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}
