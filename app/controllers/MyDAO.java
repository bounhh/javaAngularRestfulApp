package controllers;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import models.Customer;
import models.Friends;
import play.db.DB;

public class MyDAO {

    private static Connection con = DB.getConnection();

    // recupérer touts les clients de la base donnée
    public List<Customer> getAllCustumers() throws SQLException {
        List<Friends> friendsList = new ArrayList<Friends>();
        List<Customer> customersList = new ArrayList<Customer>();
        Customer customer;
        String query = "select * from customer";
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery( query );
        List<String> tag = new ArrayList<String>();
        while ( res.next() ) {
            customer = new Customer();
            tag = new ArrayList<String>();
            customer.set_id( res.getString( 1 ) );
            customer.setIndex( Integer.parseInt( res.getString( 2 ) ) );
            customer.setGuid( res.getString( 3 ) );
            customer.setActive( Boolean.valueOf( res.getString( 4 ) ) );
            customer.setBalance( res.getString( 5 ) );
            customer.setPicture( res.getString( 6 ) );
            customer.setAge( Integer.parseInt( res.getString( 7 ) ) );
            customer.setEyeColor( res.getString( 8 ) );
            customer.setName( res.getString( 9 ) );
            customer.setGender( res.getString( 10 ) );
            customer.setCompany( res.getString( 11 ) );
            customer.setEmail( res.getString( 12 ) );
            customer.setPhone( res.getString( 13 ) );
            customer.setAddress( res.getString( 14 ) );
            customer.setAbout( res.getString( 15 ) );
            customer.setRegistered( res.getString( 16 ) );
            customer.setLatitude( Float.parseFloat( res.getString( 17 ) ) );
            customer.setLongitude( Float.parseFloat( res.getString( 18 ) ) );
            customer.setTags( listOfString( res.getString( 19 ) ) );
            friendsList = getFriends( res.getString( 1 ) );
            customer.setFriends( friendsList );
            customer.setGreeting( res.getString( 20 ) );
            customer.setFavoriteFruit( res.getString( 21 ) );
            customersList.add( customer );
        }
        return customersList;
    }

    // supprimer un client par son ID
    public void deletPerId( String id ) throws SQLException {
        PreparedStatement st1 = con.prepareStatement( String.format( "delete from friend where _id = '%s'", id ) );
        int i = st1.executeUpdate();
        PreparedStatement st2 = con.prepareStatement( String.format( "delete from customer where _id = '%s'", id ) );
        int j = st2.executeUpdate();
    }

    // ajouter un client
    public void addCustomer( String name, String email, String company, String numPhone, String adress )
            throws Exception {
        String id = encryptPassWord( name );
        int age = 30;
        String gendre = "mal";
        String about = "je suis moi";
        String registred = getDat();
        boolean isActive = true;
        String balance = "je sais aps";
        String guid = "6dfe7718-301e-46e2-b2ac-248ca634a8bd";
        String picture = "http://placehold.it/32x32";
        String eyecolor = "bleu";
        String tags = listTags();
        String greeting = "Hello, Mullins Hull! You have 10 unread messages.";
        String favoritefruit = "apple";
        List<Friends> friends = setFriends( id );

        PreparedStatement st1 = con.prepareStatement( String.format(
                "INSERT INTO customer (_id, guid, isactive, balance, picture, age, eyecolor, name, gender, company, email, phone, adresse, about, registered, latitude, longitude, tags, greeting, favoritefruit) VALUES "
                        + "            ('%s', '%s', '%b',      '%s',    '%s',  '%d',  '%s',   '%s',  '%s',   '%s',    '%s',  '%s',  '%s',   '%s',   '%s',        10.00,  20.00,    '%s',   '%s',      '%s'   )",
                id, guid, isActive, balance, picture, age, eyecolor, name, gendre, company, email, numPhone, adress,
                about, registred, tags, greeting, favoritefruit ) );
        st1.executeUpdate();
    }

    // modifier un client
    public void updateCustomer( Customer customer ) throws SQLException {
        String id = customer.get_id();
        String name = customer.getName();
        String email = customer.getEmail();
        String company = customer.getCompany();
        PreparedStatement st1 = con
                .prepareStatement(
                        String.format( "UPDATE custumer SET name = '%s', email = '%s', company = '%s' WHERE _id = 'id'",
                                name, email, company ) );
        int i = st1.executeUpdate();
    }

    // methode pour récuperer la liste des amis d'un client
    public static List<Friends> getFriends( String id ) throws SQLException {
        Friends friend = new Friends();
        List<Friends> friendsList = new ArrayList<Friends>();
        String query = String.format( "select * from friend where _id = '%s'", id );
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery( query );
        while ( res.next() ) {
            friend = new Friends();
            friend.setId( Integer.parseInt( res.getString( 1 ) ) );
            friend.set_id( res.getString( 2 ) );
            friend.setName( res.getString( 3 ) );
            friendsList.add( friend );
        }
        return friendsList;
    }

    // methode pour rendre lec champs TAG une liste
    public static List<String> listOfString( String str ) {
        List<String> listOfString = new ArrayList<String>();
        listOfString = Arrays.asList( str.split( "\\s*,\\s*" ) );
        return listOfString;
    }

    // methode pour recupérer la date
    public String getDat() {
        DateFormat dateFormat = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
        Date date = new Date();
        dateFormat.format( date );
        return dateFormat.format( date ).toString();
    }

    // pour crer un ID en fonction du nom de client
    public String encryptPassWord( String pw ) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance( "MD5" );
        String cryptedPW = ( new HexBinaryAdapter() ).marshal( md5.digest( pw.getBytes() ) );
        return cryptedPW;
    }

    // liste provésoir des TAG
    public String listTags() {
        List<String> tags = new ArrayList<String>();
        tags.add( "exercitation" );
        tags.add( "non" );
        tags.add( "anim" );
        tags.add( "laborum" );
        tags.add( "proident" );
        tags.add( "nostrud" );
        tags.add( "exercitation" );
        return tags.toString();
    }

    // liste provésoir des amis
    public List<Friends> setFriends( String id ) {
        List<Friends> listOfFriends = new ArrayList<Friends>();
        Friends friend1 = new Friends();
        friend1.set_id( id );
        friend1.setId( 10 );
        friend1.setName( "zaki" );
        listOfFriends.add( friend1 );
        return listOfFriends;
    }

}
