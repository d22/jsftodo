package ch.dllnskt.todo.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ch.dllnskt.todo.validators.TodoNameValidator")
public class TodoNameValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String todoName = (String) arg2;

		if (todoName.length() < 3) {
			throw new ValidatorException(new FacesMessage("Todoname too short"));
		}

	}
}
