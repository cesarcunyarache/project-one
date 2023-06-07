
package DataAccessObject;
import java.util.ArrayList;

/**
 *
 * @author cesarcunyarache
 */
public interface DAO<Whisky> {

    public boolean Create(Whisky whisky);

    public ArrayList<Whisky> Read();

    public boolean Update(Whisky whisky);

    public boolean Delete(Whisky whisky);

    public Whisky Search(Whisky whisky);

}
