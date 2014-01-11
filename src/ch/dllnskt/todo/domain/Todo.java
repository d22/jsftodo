package ch.dllnskt.todo.domain;

public class Todo {

	private String text;
	private boolean done;

	public Todo(String text, Boolean done) {
		this.setText(text);
		this.setDone(done);
	}

	public Todo(String text) {
		this(text, false);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}
