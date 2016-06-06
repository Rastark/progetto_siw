package it.uniroma3.model;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name= "findAllExamTypology", query="SELECT t FROM ExamTypology t")
public class ExamTypology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, unique=true)
	private String code;
	
	@Column(length=2000)
	private String description;
	
	@Column(nullable=false)
	private float cost;
	
	//private Map<String, String> prereqMap;
	
	public ExamTypology(String name, String code, String description, float cost) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.cost = cost;
	}
	
	public ExamTypology(){}
	
/*	public void addPrereq(String nome, String valore) {
		this.prereqMap.put(nome, valore);
	}
*/	
	public long getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean equals(Object o) {
		ExamTypology type = (ExamTypology)o;
		return this.getCode().equals(type.getCode());
	}
	
	public int hashCode() {
		return this.code.hashCode();
	}
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Exam Typology");
		sb.append("{id=").append(id);
		sb.append("name=").append(name);
		sb.append("cost=").append(cost);
		sb.append("description=").append(description);
		sb.append(", code=").append(code);
		sb.append("}\n");
		return sb.toString();
	}
}
