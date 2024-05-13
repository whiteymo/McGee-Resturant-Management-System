package bll;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Response implements Serializable  {
    public boolean success;
    public String message;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
