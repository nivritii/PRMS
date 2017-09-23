/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.restful;

import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.service.ScheduleService;

/**
 *
 * @author nivi
 */
@Path("scheduleprogram")
@RequestScoped
public class ScheduleRESTService {
    
     @Context
    private UriInfo context;
    
    private ScheduleService scheduleService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProgramSlot getProgramSlot() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("/psall")
    @Produces(MediaType.APPLICATION_JSON)
    public ProgramSlots getAllProgramSlots() {
        ArrayList<ProgramSlot> pslist = scheduleService.findAllPS();
        ProgramSlots pssList = new ProgramSlots();
        pssList.setPsList(pslist);  
        
        for (int i = 0; i < pslist.size(); i++) {
            System.out.println(pslist.get(i).getProgramName());      
        }
        return pssList;
    }

    @PUT
    @Path("/createps")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProgramSlot(ProgramSlot ps) {
        scheduleService.processCreate(ps);
    }
    
    @POST
    @Path("/updateps")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProgramSlot(ProgramSlot ps) {
        scheduleService.processModify(ps);
    }
}
