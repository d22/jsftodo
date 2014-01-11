package ch.dllnskt.todo.beans;

import ch.dllnskt.todo.domain.Todo;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class DataBean {

	private List<Todo> todos;

	public DataBean() {
		todos = new LinkedList<>();
		todos.add(new Todo("Buy Milk"));
		todos.add(new Todo("Learn JSF"));
		todos.add(new Todo("Learn Angular"));
		todos.add(new Todo("Drink Coffee", true));
		todos.add(new Todo("Hug Ruedi", false));
		todos.add(new Todo("Sip champagne from dent", false));
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void addTodo(Todo todo) {
		todos.add(todo);
	}

	public void removeTodo(Todo todo) {
		todos.remove(todo);
	}
}
