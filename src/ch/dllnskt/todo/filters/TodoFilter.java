package ch.dllnskt.todo.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ch.dllnskt.todo.beans.TodoListBean;
import ch.dllnskt.todo.domain.Todo;

@WebFilter(filterName = "todoFilter", urlPatterns = "/*")
public class TodoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		filterChain.doFilter(servletRequest, servletResponse);

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpSession session = request.getSession(true);
		TodoListBean todoList = (TodoListBean) session
				.getAttribute("todoListBean");

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
