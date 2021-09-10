package ffos.p3.ontologijap3;

import java.io.Serializable;

public class Ontologija implements Serializable {

    public Ontologija() {
        this.type = type;
        this.properties = properties;
    }

    private String type;
    private String properties;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getProperties() {
        return properties;
    }
    public void setProperties(String properties) {
        this.properties = properties;
    }

}
