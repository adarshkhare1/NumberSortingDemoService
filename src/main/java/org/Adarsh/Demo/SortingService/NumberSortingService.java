package org.Adarsh.Demo.SortingService;

import org.Adarsh.Demo.SortingAlgorithms.NumberSortingSession;
import org.Adarsh.Demo.SortingAlgorithms.NumberSortingSessionFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author adkhare
 */
@Path("NumberSorter")
public class NumberSortingService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public NumberSortingService() {
    }

    /**
     * Retrieves representation of an instance of NumberSorter.GenericResource
     * @param sessionId Id of the session.
     * @return list of numbers in current state for a given Session.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public int[] getNumberList(String sessionId) 
    {
       NumberSortingSession session = NumberSortingSessionCache.getSession(sessionId);
       return session.getNumbers();
       
    }

    /**
     * PUT method for updating or creating an instance of NumberSortingSession
     * @param algorithm algorithm for sorting
     * @param numbers list of numbers for sorting.
     * @return an id of newly created session.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String createNewSession(String algorithm, int[] numbers) {
        NumberSortingSession session = NumberSortingSessionFactory.CreateSortingSession(algorithm, numbers);   
        NumberSortingSessionCache.addSession(session);
        return session.getSessionId();
    }
    
    /**
     * POST method to execute one iteration step for sorting.
     * @param sessionId representation for the resource
     * @return numberList after sorting Step
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int[] sortStep(String sessionId) {
       NumberSortingSession session = NumberSortingSessionCache.getSession(sessionId);
       session.executeSortingIteration();
       return session.getNumbers();
    }
}
