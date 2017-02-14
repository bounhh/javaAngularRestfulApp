package models;

public class Friends {
    int    id;
    String _id;
    String name;

    public Friends() {
        super();
    }

    public Friends( int id, String _id, String name ) {
        super();
        this.id = id;
        this._id = _id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id( String _id ) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

}
