package org.springframework.samples.mvc.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.samples.mvc.convert.MaskFormat;

public class FormBean {

	@NotEmpty
	private String name;

	@Min(21)
	private int age;

	@DateTimeFormat(iso=ISO.DATE)
	@Past
	private Date date;

	@NotEmpty
	private String todo;
	// @MaskFormat("(###) ###-####")
	// private String phone;
	//
	// @NumberFormat(pattern="$###,###.00")
	// private BigDecimal currency;
	//
	// @NumberFormat(style=Style.PERCENT)
	// private BigDecimal percent;
	//
	// private InquiryType inquiry;
	//
	// private String inquiryDetails;
	//
	// private boolean subscribeNewsletter;
	//
	// private Map<String, String> additionalInfo;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date birthDate) {
		this.date = birthDate;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("properties name=");
        if (name != null) {
        	sb.append("'").append(name).append("', ");
        } else {
        	sb.append(name).append(", ");
        }
        sb.append("age=").append(age).append(", ");
        sb.append("birthDate=").append(date).append(", ");
        sb.append("todo=").append(todo).append(", ");
        return sb.toString();
    }
}
