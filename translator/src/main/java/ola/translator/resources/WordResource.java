/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ola.translator.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olaba
 */
@Path("/translate")
public class WordResource {
    private final ParametersDAO parametersDAO;
    public WordResource() throws SQLException {
        this.parametersDAO = new ParametersDAO();
    }
    private static final Map<String, String> languageSwitch = new HashMap<>();
    @GET
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    public String add(@QueryParam("pl") String pl, @QueryParam("eng") String eng, @QueryParam("de") String de ) {
        if (pl == null || eng == null || de == null ){
            return "ERROR! Missing parameters!";
        }
        Word word = new Word(pl,eng,de);
        try{
            parametersDAO.addWord(word);
            return "I MANAGED TO ADD THE WORD";
        }catch(SQLException e){
            return "ERROR!"+ e.getMessage();
        }
    }
    
    @GET
    @Path("/dictionary")
    @Produces(MediaType.TEXT_PLAIN)
    public String dictionary(){
        try {
           var words = parametersDAO.getDictionary();
           StringBuilder dictionary = new StringBuilder();
           for(var word: words){
               dictionary.append(word.ToString());
           }
           return dictionary.toString();
        } catch (SQLException ex) {
            Logger.getLogger(WordResource.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR, couldn't read dictionary";
        }
    }

    @GET
    @Path("/switch/{switchfrom}/{switchto}")
    @Produces(MediaType.TEXT_PLAIN)
    public String Switchtranslotor(@PathParam("switchfrom") String switchfrom,@PathParam("switchto") String switchto){
        languageSwitch.put(switchfrom,switchto);
        String out = "Translator language "+switchfrom+" is now changed to "+switchto;
        return out;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String Miauczek(@QueryParam("translatefrom") String translatefrom,@QueryParam("translateto") String translateto,@QueryParam("phrase") String phrase){
        if(languageSwitch.containsKey(translatefrom)){
            translatefrom=languageSwitch.get(translatefrom);
        }
        if(languageSwitch.containsKey(translateto)){
            translateto=languageSwitch.get(translateto);
        }
        if(translatefrom.equals("pl")){
            if(translateto.equals("eng")){
                try {
                    var words = parametersDAO.getDictionary();
                    String eng="ERROR, translation not found";
                    for(var word: words){
                        if(word.getPL().equals(phrase))
                        eng = word.getENG();
                    }
                    return eng;
                 } catch (SQLException ex) {
                     Logger.getLogger(WordResource.class.getName()).log(Level.SEVERE, null, ex);
                     return "ERROR, couldn't read dictionary";
                 }
            }
            if(translateto.equals("de")){
                try {
                    var words = parametersDAO.getDictionary();
                    String de="ERROR, translation not found";
                    for(var word: words){
                        if(word.getPL().equals(phrase))
                        de = word.getDE();
                    }
                    return de;
                 } catch (SQLException ex) {
                     Logger.getLogger(WordResource.class.getName()).log(Level.SEVERE, null, ex);
                     return "ERROR, couldn't read dictionary";
                 }
            }
        }
        if(translatefrom.equals("eng")){
            if(translateto.equals("pl")){
                try {
                    var words = parametersDAO.getDictionary();
                    String pl="ERROR, translation not found";
                    for(var word: words){
                        if(word.getENG().equals(phrase))
                        pl = word.getPL();
                    }
                    return pl;
                 } catch (SQLException ex) {
                     Logger.getLogger(WordResource.class.getName()).log(Level.SEVERE, null, ex);
                     return "ERROR, couldn't read dictionary";
                 }
            }
            if(translateto.equals("de")){
                try {
                    var words = parametersDAO.getDictionary();
                    String de="ERROR, translation not found";
                    for(var word: words){
                        if(word.getENG().equals(phrase))
                        de = word.getDE();
                    }
                    return de;
                 } catch (SQLException ex) {
                     Logger.getLogger(WordResource.class.getName()).log(Level.SEVERE, null, ex);
                     return "ERROR, couldn't read dictionary";
                 }
            }
        
        }
    return "miau";
    }
}