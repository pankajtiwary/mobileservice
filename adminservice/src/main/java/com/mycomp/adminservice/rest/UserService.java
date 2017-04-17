package com.mycomp.adminservice.rest;

import javax.jws.WebService;
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

import com.mycomp.adminservice.common.exceptions.AdminServiceException;
import com.mycomp.adminservice.common.exceptions.ValidationException;
import com.mycomp.adminservice.db.manager.dao.dto.User;

@Path("/")
@WebService(name = "userservice")
public interface UserService {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("getAllUsers")
	public Response getAllUsers() throws ValidationException,AdminServiceException;
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("/createuser")
	public Response createUser(User user) throws ValidationException,AdminServiceException;
	
	
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("/updateuser")
	public Response updateUser(User user) throws ValidationException,AdminServiceException;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/searchuser/{userid}")
	public Response getUser(@PathParam("userid") String userid) throws ValidationException, AdminServiceException;
	
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/deleteuser/{userid}")
	public Response deleteUser(@PathParam("userid") String userid) throws ValidationException,AdminServiceException;


}
