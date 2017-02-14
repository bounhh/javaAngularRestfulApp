package models;

import java.util.List;

public class Customer {
    private String        _id;
    private int           index;
    private String        guid;
    private boolean       isActive;
    private String        balance;
    private String        picture;
    private int           age;
    private String        eyeColor;
    private String        name;
    private String        gender;
    private String        company;
    private String        email;
    private String        phone;
    private String        address;
    private String        about;
    private String        registered;
    private float         latitude;
    private float         longitude;
    private List<String>  tags;
    private List<Friends> friends;
    private String        greeting;
    private String        favoriteFruit;

    public Customer() {
        super();
    }

    public Customer( String _id, int index, String guid, boolean isActive, String balance, String picture, int age,
            String eyeColor, String name, String gender, String company, String email, String phone, String address,
            String about, String registered, float latitude, float longitude, List<String> tags, List<Friends> friends,
            String greeting, String favoriteFruit ) {
        super();
        this._id = _id;
        this.index = index;
        this.guid = guid;
        this.isActive = isActive;
        this.balance = balance;
        this.picture = picture;
        this.age = age;
        this.eyeColor = eyeColor;
        this.name = name;
        this.gender = gender;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.about = about;
        this.registered = registered;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tags = tags;
        this.friends = friends;
        this.greeting = greeting;
        this.favoriteFruit = favoriteFruit;
    }

    public String get_id() {
        return _id;
    }

    public void set_id( String _id ) {
        this._id = _id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex( int index ) {
        this.index = index;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid( String guid ) {
        this.guid = guid;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive( boolean isActive ) {
        this.isActive = isActive;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance( String balance ) {
        this.balance = balance;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture( String picture ) {
        this.picture = picture;
    }

    public int getAge() {
        return age;
    }

    public void setAge( int age ) {
        this.age = age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor( String eyeColor ) {
        this.eyeColor = eyeColor;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender( String gender ) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany( String company ) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout( String about ) {
        this.about = about;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered( String registered ) {
        this.registered = registered;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude( float latitude ) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude( float longitude ) {
        this.longitude = longitude;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags( List<String> tags ) {
        this.tags = tags;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting( String greeting ) {
        this.greeting = greeting;
    }

    public String getFavoriteFruit() {
        return favoriteFruit;
    }

    public void setFavoriteFruit( String favoriteFruit ) {
        this.favoriteFruit = favoriteFruit;
    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends( List<Friends> friends ) {
        this.friends = friends;
    }

}
