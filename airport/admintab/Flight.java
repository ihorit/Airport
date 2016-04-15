/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.admintab;

/**
 *
 * @author it01
 */
public class Flight {
    private String time;
    private String flight;
    private String destination;
    private String carrier;
    private String terminal;
    private String status;

    public Flight(String time, String flight, String destination, String carrier, String terminal, String status) {
        this.time = time;
        this.flight = flight;
        this.destination = destination;
        this.carrier = carrier;
        this.terminal = terminal;
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public String getFlight() {
        return flight;
    }

    public String getDestination() {
        return destination;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getTerminal() {
        return terminal;
    }

    public String getStatus() {
        return status;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
