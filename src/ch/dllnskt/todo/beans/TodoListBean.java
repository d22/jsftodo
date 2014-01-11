package ch.dllnskt.todo.beans;

import ch.dllnskt.todo.domain.Todo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;


@ManagedBean
@SessionScoped
public class TodoListBean {

	@ManagedProperty(name = "dataBean", value = "#{dataBean}")
	private DataBean dataBean;

	// setter needed for bean injection!
	@SuppressWarnings("unused")
	public void setDataBean(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	public List<Todo> getTodoList() {
		return dataBean.getTodos();
	}

	public void updateDone(Todo todo) {
		Boolean state = !todo.isDone();
		todo.setDone(state);
	}

	public void add(TodoBean todoBean) {
		Todo todo = new Todo(todoBean.getText());
		dataBean.addTodo(todo);
		todoBean.setText("");
	}

	public void remove(Todo todo) {
		dataBean.removeTodo(todo);
	}

}
