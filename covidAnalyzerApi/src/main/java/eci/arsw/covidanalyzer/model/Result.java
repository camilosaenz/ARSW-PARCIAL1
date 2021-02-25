package eci.arsw.covidanalyzer.model;

public class Result {
	
	public String name;
	public String id;
	public ResultType tipo;
	
	public Result(String name, String id, ResultType tipo) {
		this.name = name;
		this.id = id;
		this.tipo = tipo;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		
}