package ch.dllnskt.todo.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TodoBean {

	private String text;


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
