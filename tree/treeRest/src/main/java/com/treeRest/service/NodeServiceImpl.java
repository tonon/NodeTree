package com.treeRest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.treeRest.EntityManager.JpaEntityManager;
import com.treeRest.entities.Node;


@Path("/node")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NodeServiceImpl {
	
		private JpaEntityManager JPAEM = new JpaEntityManager();
		private EntityManager objEM = JPAEM.getEntityManager();
		  	

		@GET
		@Path("/getAll")
		@Produces("application/json")
		public List<Node> getAll(){

			try {
				String query = "select c from Node c";
				List<Node> nodes = objEM.createQuery(query, Node.class).getResultList();
				objEM.close();
				return nodes;
			} catch (Exception e) {
				throw new WebApplicationException(500);
			}
		}

		@GET
		@Path("/get/{id}")
		@Produces("application/json")
		
		public Node getNode(@PathParam("id") int id){
			try {
				Node node = objEM.find(Node.class, id);
				objEM.close();
				return node;
			} catch (Exception e) {
				throw new WebApplicationException(500);
			}
		}

		@POST
		@Path("/post")
		@Consumes("application/json")
		public Response addNode(Node obj) {
			try {
				objEM.getTransaction().begin();
				objEM.persist(obj);
				objEM.getTransaction().commit();
				objEM.close();
				return Response.status(200).entity("cadastro realizado.").build();
			} catch (Exception e) {
				throw new WebApplicationException(500);
			}
		}

		@PUT
		@Path("/put")
		@Consumes("application/json")
		public Response updateNode(Node obj){
			try {
				objEM.getTransaction().begin();
				objEM.merge(obj);
				objEM.getTransaction().commit();
				objEM.close();
				return Response.status(200).entity("cadastro alterado.").build();
			} catch (Exception e) {
				throw new WebApplicationException(500);
			}
		}

			@DELETE
			@Path("/delete/{id}")
			public Response excluir(@PathParam("id") int id){
				try {
					Node obj = objEM.find(Node.class, id);

					objEM.getTransaction().begin();
					objEM.remove(obj);
					objEM.getTransaction().commit();
					objEM.close();

					return Response.status(200).entity("cadastro excluído.").build();
				} catch (Exception e) {
					throw new WebApplicationException(500);
				}
			}

			
			
	}
