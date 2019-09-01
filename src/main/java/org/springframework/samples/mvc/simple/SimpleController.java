package org.springframework.samples.mvc.simple;

import org.springframework.samples.mvc.form.FormBean;
import org.springframework.samples.mvc.form.FormController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@GetMapping("/forms")
	public String getAllForms() {
		StringBuilder sb = new StringBuilder();
		sb.append("All Current Todos!\n");
		for (FormBean fb: FormController.formBeans) {
			sb.append(fb.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

}
