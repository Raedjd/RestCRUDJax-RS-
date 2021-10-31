package rest.ressources;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import rest.entities.Employe;



@Path("employes")
public class GestionEmploye {
	
	public static  List<Employe> employes=new ArrayList<Employe>();
	

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public String addEmploye(Employe employe) {
		if(employes.add(employe)) {
			return "Employe ajouté ! ";
		}else
			return "Employé non ajouté";
	}
	
	//Ajouter un nouveau employé
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response addInfoEmploye(Employe info){
	 if (employes.add(info)){
	
		 return Response.status(Status.CREATED).entity(info).build();
	 }
	
	 return Response.status(Status.BAD_REQUEST).build();
}
   
	
	/*@GET
	@Produces(MediaType.APPLICATION_XML)
	@ApiOperation(value="Afficher objet XML employe")
	@ApiResponses({
		@ApiResponse(code=200,message="Success")
	})
	public List<Employe> afficherEmploye(){
		if(employes == null) {
			return null;
		}else
			return employes;
	}*/
	// Afficher la liste de tous les employés
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@ApiOperation(value="Afficher objet XML employe")
	@ApiResponses({
		@ApiResponse(code=200,message="Success")
	})
	public  Response  displayEmployeesList() {
		if(employes != null)
			return Response.status(Status.FOUND).build();
		else
			return Response.status(Status.NOT_FOUND).entity("").build();
			
		
	}
	

	
	/*@GET
	@Path("{cin}")
	@Produces(MediaType.APPLICATION_XML)
	public Employe chercherEmployeCIN(@PathParam("cin")String cin) {
		int index = this.getIndexEmployeByCin(cin);
		if(index != -1) {
			return employes.get(index);
		}
		return null;
	}*/
	//afficher un employé par son CIN
	@GET
	@Path("{cin}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getEmploye(String cin) {
		int index = this.getIndexEmployeByCin(cin);
		if(index != -1) {
	    	   return  Response.status(Status.FOUND)
						.entity(employes.get(index))
						.build(); 
	   		} return  Response.status(Status.NOT_FOUND).build();
	}
	
	/*@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public String modifierEmploye(Employe emp) {
		int index = this.getIndexEmployeByCin(emp.getCin());
		if(index != -1) {
			employes.set(index, emp);
			return "Employé modifié !";
		}
		return "Employé non modifié";
	}*/
	//modifier un employé
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateEmploye(Employe e) {
		int index= this.getIndexEmployeByCin(e.getCin());
		if (index!=-1) {
			employes.set(index, e);
			return Response.status(Status.OK).entity("update successful").build();
			
		}
		return Response.status(Status.NOT_FOUND).entity("update unsuccessful!").build();
	
	}

	//supprimer un employé
	@DELETE
	@Path("{cin}")
	public Response deleteEmpl(@PathParam("cin")String cin){
		int index= this.getIndexEmployeByCin(cin);		
		if (index!=-1) {
			employes.remove(index);
			return Response.status(204).build();
		}else 
			return Response.status(Response.Status.NOT_FOUND).build();
			
    }
	
	//methode java interne pour le filtrage
	public int getIndexEmployeByCin(String cin) {
		for(Object emp : employes) {
			if(((Employe) emp).getCin().equals(cin)) {
				return employes.indexOf(emp);
			}
		}
		return -1;
	}
	}
