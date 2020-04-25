package tables;

public class Category {

    private int categoryId;
    private String categoryName;
    private String categoryDescription;


    public Category(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    private void setId(int id) {
        this.categoryId = id;
    }

    public int getId() {
        return categoryId;
    }

    private void setName(String name) {
        this.categoryName = name;
    }

    public String getName() {
        return categoryName;
    }

    private void setDescription(String description) {
        this.categoryDescription = description;
    }

    public String getDescription() {
        return categoryDescription;
    }

    @Override
    public String toString() {
        return this.categoryId + " " + this.categoryName + " " + this.categoryDescription;
    }
}
