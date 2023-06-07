package JTable;



public class ModelAction <T>{

    private T elemento;
    private EventAction event;

    public ModelAction(T elemento, EventAction event) {
        this.elemento = elemento;
        this.event = event;
    }
    

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

     

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

}
