package classes;

public class Todo {

	private String description;
	private boolean done;
	
	public Todo(String description) {
		setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}
	
	public void changeDone()
	{
		setDone(!done);
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	
	
	
}
