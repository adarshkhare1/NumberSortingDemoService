/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Adarsh.Demo.SortingService;

import org.Adarsh.Demo.SortingAlgorithms.NumberSortingSession;
import java.util.Hashtable;

/**
 *
 * @author adkhare
 */
public class NumberSortingSessionCache {
    
    private static Hashtable<String, NumberSortingSession> sessionCache 
            = new Hashtable<String, NumberSortingSession>();
    
    public static void addSession(NumberSortingSession session)
    {
        sessionCache.put(session.getSessionId(), session);
    }
    
    public static NumberSortingSession getSession(String sessionId)
    {
        return sessionCache.get(sessionId);
    }
}
