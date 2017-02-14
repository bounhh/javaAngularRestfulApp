package controllers;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Customer;
import models.Friends;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
    private static Connection     con         = DB.getConnection();
    private List<Friends>         friendsList = new ArrayList<Friends>();
    private static List<Customer> customersList;
    private static String         query;
    private static Array          tag;
    private Friends               friends;
    private static Statement      st;
    private static ResultSet      res;
    private static ObjectMapper   mapper;
    private static MyDAO          myDAO;

    public static Result customers() throws SQLException {
        myDAO = new MyDAO();
        customersList = new ArrayList<Customer>();
        mapper = new ObjectMapper();
        customersList = myDAO.getAllCustumers();
        allowServeur();
        JsonNode node = mapper.convertValue( customersList, JsonNode.class );
        return ok( node );
    }

    public static Result deletCustumer( String id ) throws SQLException {
        myDAO = new MyDAO();
        myDAO.deletPerId( id );
        allowServeur();
        return ok();

    }

    public static Result addCustumer( String name, String email, String company, String numPhone, String adress )
            throws Exception {

        myDAO = new MyDAO();
        myDAO.addCustomer( name, email, company, numPhone, adress );
        allowServeur();
        return ok();
    }

    public static Result updatCustumer( String id ) throws SQLException {
        myDAO = new MyDAO();
        myDAO.deletPerId( id );
        return ok();

    }

    public static void allowServeur() {
        response().setHeader( "Access-Control-Allow-Origin", "*" );
        response().setHeader( "Access-Control-Allow-Methods", "POST" );
        response().setHeader( "Access-Control-Allow-Methods", "GET" );
        response().setHeader( "Access-Control-Max-Age", "300" );
        response().setHeader( "Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept" );
    }

}
