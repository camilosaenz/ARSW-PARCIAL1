package eci.arsw.covidanalyzer.model;

public class Result {
	
	public String name;
	public String lastName;
	public String id;
	public ResultType tipo;
	public int cantidad;

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ResultType getTipo() {
		return tipo;
	}

	public void setTipo(ResultType tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
		
}