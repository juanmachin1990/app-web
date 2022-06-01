package ejercicio;

public class Persona {
	Long idPersona;
	String name;
	String age;
	String address;
	String phone;
	
	public Persona() {
		super();

	}

	public Persona(String name, String age, String address, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		idPersona = idPersona;
	}


	@Override
	public String toString() {
		return "Persona [id= "+idPersona+"name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone + "]";
	}
	
}
