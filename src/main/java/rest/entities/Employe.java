package rest.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Entité Employe enregistré dans swagger")
@XmlRootElement
public class Employe {
	
	private String cin;
	private String nom;
	private String prenom;
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String cin, String nom, String prenom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	@ApiModelProperty(value="ID est une valeur unique")
	@XmlAttribute(name="id",required=true)
	//<employe id="123456"> </employe>
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	@XmlElement(name="LastName")
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@XmlElement(name="FirstName")
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	//@Override
	/*public int hashCode() {
		final int prime = 31;
		//String result = 1;
		//result = prime * result + cin;
		String result = cin+ ((nom == null) ? 0 : nom.hashCode());
		result =  result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (cin != other.cin)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

}
