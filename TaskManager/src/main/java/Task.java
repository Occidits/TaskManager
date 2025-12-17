import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate creationDate;

    public Task(int id, String title, String description, TaskStatus status, LocalDate creationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
    }

    public int getId() {return id;}
    public String getTitle() {return title;}
    public String getDescription() {return description;}
    public TaskStatus getStatus() {return status;}
    public LocalDate getCreationDate() {return creationDate;}

    public void setId(int id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setStatus(TaskStatus status) {this.status = status;}
    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}
}
