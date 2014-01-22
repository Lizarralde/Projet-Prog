package equipment;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public enum OS {

    IOS("iOS"), ANDROID("Android");

    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    OS(String name) {

        this.setName(name);
    }

    @Override
    public String toString() {

        return name;
    }
}
