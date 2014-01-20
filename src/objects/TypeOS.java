package objects;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public enum TypeOS {

    IOS("iOS"), ANDROID("Android");

    private String name;

    TypeOS(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return name;
    }
}
