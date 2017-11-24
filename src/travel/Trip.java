/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1795647
 */
public class Trip {   
    private String name;
    private String passNo;
    private String destination;
    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    private Date departure;
    private Date returnDate;

    
    //Trip constructor 
    public Trip(String name,String passNo,String destination,Date departure,Date returnDate) {
        setName(name);
        setPassNo(passNo);
        setDestination(destination);
        setDepartureReturn(departure, returnDate);
            
    }
    
    
    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public final void setDestination(String destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination must be filled in.");
        }
        if (destination.length() < 1 || destination.length() > 50) {
            throw new IllegalArgumentException("Destination must be between 1-50 characters.");
        }
        this.destination = destination;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name must be filled in.");
        }
        if(name.length() < 1 || name.length() >50){
            throw new IllegalArgumentException("Name must be between 1-50 characters.");
        }
        this.name = name;
    }

    /**
     * @return the passNo
     */
    public String getPassNo() {
        return passNo;
    }

    /**
     * @param passNo the passNo to set
     */
    public final void setPassNo(String passNo) {
        if (!passNo.toUpperCase().matches("[A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9]")) {
            throw new IllegalArgumentException("Passport number must follow AB123456 format.");
        } else {
             this.passNo = passNo;
        }
       
    }
    
    // setting departure return
    public final void setDepartureReturn(Date departure, Date returnDate) {
//        String departureString = "";
//        Date depart = new SimpleDateFormat("MMMM d, yyyy").parse(departureString);
//        String returnString = "";
//        Date returnD = new SimpleDateFormat("MMMM d, yyyy").parse(returnString);
        if (departure == null) {
            throw new IllegalArgumentException("Departure date must be entered.");
        }
        if (departure.after(returnDate)) {
            throw new IllegalArgumentException("Departure date must be be before return date.");
        }
        if(returnDate.before(departure)){
            throw new IllegalArgumentException("Return date must be after Departure date.");
        }
        if (returnDate == null) {
            throw new IllegalArgumentException("Return date must be entered.");
        }
        this.departure = departure;
        this.returnDate = returnDate;     
    }
    
    /**
     * @return the departure
     */
    public Date getDeparture() {
        return departure;
    }

    /**
     * @return the returnDate
     */
    public Date getReturnDate() {
        return returnDate;
    }
     @Override
    public String toString() {
        return String.format("%s (%s) travels to %s on %tD and returns %tD", name, passNo, destination, departure, returnDate);
    }

    
    
}
