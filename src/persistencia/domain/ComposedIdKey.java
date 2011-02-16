package persistencia.domain;
import java.io.Serializable;
import java.util.StringTokenizer;

public class ComposedIdKey implements Serializable
{
    public String latitud;
    public String longitud;

    public ComposedIdKey ()
    {
    }

    /**
     * Constructor accepting same input as generated by toString().
     */
    public ComposedIdKey(String value) 
    {
        StringTokenizer token = new StringTokenizer (value, "::");
        token.nextToken();               // className
        this.latitud = token.nextToken(); // latitud
        this.longitud = token.nextToken(); // field2
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof ComposedIdKey))
        {
            return false;
        }
        ComposedIdKey c = (ComposedIdKey)obj;

        return latitud.equals(c.latitud) && longitud.equals(c.longitud);
    }

    public int hashCode ()
    {
        return this.latitud.hashCode() ^ this.longitud.hashCode();
    }

    public String toString ()
    {
        // Give output expected by String constructor
        return this.getClass().getName() + "::"  + this.latitud + "::" + this.longitud;
    }
}