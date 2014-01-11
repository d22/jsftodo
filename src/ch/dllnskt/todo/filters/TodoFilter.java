package ch.dllnskt.todo.filters;


import ch.dllnskt.todo.beans.TodoListBean;
import ch.dllnskt.todo.domain.Todo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "todoFilter", urlPatterns = "/*")
public class TodoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		filterChain.doFilter(servletRequest, servletResponse);

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpSession session = request.getSession(true);
		TodoListBean todoList = (TodoListBean) session.getAttribute("todoListBean");

		if (todoList != null) {
			List<Todo> todos = todoList.getTodoList();

			for (Todo t : todos) {
				t.setText(t.getText().toUpperCase());
			}
		}
	}

	public void destroy() {
	}


}
