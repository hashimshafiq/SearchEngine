/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Hashim
 */
public class ReadingData {
    
    porter stemmer = new porter();
    ReadingData(){
    
    
    }
    
    public void ReadData(LinkedList_of_AVL avl_list,String folder_path) throws IOException{
     
        File folder = new File(folder_path);
        File[] listOfFiles = folder.listFiles();
        String content;
        String[] content_array;
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                //System.out.println(file.getName());
                //System.out.println(file.getAbsolutePath());
                //fr.Openfile(file.getAbsolutePath());
                //content = fr.readfile();
                content = FileUtils.readFileToString(file);
                content_array = content.toLowerCase().split(" ");
                //this.porter_stemmer(content_array,file.getAbsolutePath());
                avl_list.insert_in_avl_linkedlist(null,file.getAbsolutePath(),this.porter_stemmer(content_array)); 
                //fr.closefile();
            
       
        
                
                
                
            }   
        }
        
    }
    
    public AVL porter_stemmer(String[] array){
        AVL<String> avl = new AVL();    
        for(String key : array){
                if(key.length()<=2||key.equals("a") || key.equals("able") || key.equals("about") || key.equals("across") || key.equals("after") || key.equals("all") || key.equals("almost") || key.equals("also") || key.equals("am") || key.equals("among") || key.equals("an") ||  key.equals("and") ||  key.equals("any") ||  key.equals("are") ||  key.equals("as") ||  key.equals("at") ||  key.equals("be") ||  key.equals("because") ||  key.equals("been") ||  key.equals("but") ||  key.equals("by") ||  key.equals("can") ||  key.equals("cannot") ||  key.equals("could") ||  key.equals("dear") ||  key.equals("did") ||  key.equals("do") ||  key.equals("does") ||  key.equals("either") ||  key.equals("else") ||  key.equals("ever") ||  key.equals("every") ||  key.equals("for") ||  key.equals("from") ||  key.equals("get") ||  key.equals("got") ||  key.equals("had") ||  key.equals("has") ||  key.equals("have") ||  key.equals("he") ||  key.equals("her") ||  key.equals("hers") ||  key.equals("him") ||  key.equals("his") ||  key.equals("how") ||  key.equals("however") ||  key.equals("i") ||  key.equals("if") ||  key.equals("in") ||  key.equals("into") ||  key.equals("is") ||  key.equals("it") ||  key.equals("its") ||  key.equals("just") ||  key.equals("least") ||  key.equals("let") ||  key.equals("like") ||  key.equals("likely") ||  key.equals("may") ||  key.equals("me") ||  key.equals("might") ||  key.equals("most") ||  key.equals("must") ||  key.equals("my") ||  key.equals("neither") ||  key.equals("no") ||  key.equals("nor") ||  key.equals("not") ||  key.equals("of") ||  key.equals("off") ||  key.equals("often") ||  key.equals("on") ||  key.equals("only") ||  key.equals("or") ||  key.equals("other") ||  key.equals("our") ||  key.equals("own") ||  key.equals("rather") ||  key.equals("said") ||  key.equals("say") ||  key.equals("says") ||  key.equals("she") ||  key.equals("should") ||  key.equals("since") ||  key.equals("so") ||  key.equals("some") ||  key.equals("than") ||  key.equals("that") ||  key.equals("the") ||  key.equals("their") ||  key.equals("them") ||  key.equals("then") ||  key.equals("there") ||  key.equals("these") ||  key.equals("they") ||  key.equals("this") ||  key.equals("tis") ||  key.equals("to") ||  key.equals("too") ||  key.equals("twas") ||  key.equals("us") ||  key.equals("wants") ||  key.equals("was") ||  key.equals("we") ||  key.equals("were") ||  key.equals("what") ||  key.equals("when") ||  key.equals("where") ||  key.equals("which") ||  key.equals("while") ||  key.equals("who") ||  key.equals("whom") ||  key.equals("why") ||  key.equals("will") ||  key.equals("with") ||  key.equals("would") ||  key.equals("yet") ||  key.equals("you") ||  key.equals("your") ||  key.equals("ain't") ||  key.equals("aren't") ||  key.equals("can't") ||  key.equals("could've") ||  key.equals("couldn't") ||  key.equals("didn't") ||  key.equals("doesn't") ||  key.equals("don't") ||  key.equals("hasn't") ||  key.equals("he'd") ||  key.equals("he'll") ||  key.equals("he's") ||  key.equals("how'd") ||  key.equals("how'll") ||  key.equals("how's") ||  key.equals("i'd") ||  key.equals("i'll") ||  key.equals("i'm") ||  key.equals("i've") ||  key.equals("isn't") ||  key.equals("it's") ||  key.equals("might've") ||  key.equals("mightn't") ||  key.equals("must've") ||  key.equals("mustn't") ||  key.equals("shan't") ||  key.equals("she'd") ||  key.equals("she'll") ||  key.equals("she's") ||  key.equals("should've") ||  key.equals("shouldn't") ||  key.equals("that'll") ||  key.equals("that's") ||  key.equals("there's") ||  key.equals("they'd") ||  key.equals("they'll") ||  key.equals("they're") ||  key.equals("they've") ||  key.equals("wasn't") ||  key.equals("we'd") ||  key.equals("we'll") ||  key.equals("we're") ||  key.equals("weren't") ||  key.equals("what'd") ||  key.equals("what's") ||  key.equals("when'd") ||  key.equals("when'll") ||  key.equals("when's") ||  key.equals("where'd") ||  key.equals("where'll") ||  key.equals("where's") ||  key.equals("who'd") ||  key.equals("who'll") ||  key.equals("who's") ||  key.equals("why'd") ||  key.equals("why'll") ||  key.equals("why's") ||  key.equals("won't") ||  key.equals("would've") ||  key.equals("wouldn't") ||  key.equals("you'd") ||  key.equals("you'll") ||  key.equals("you're") ||  key.equals("you've")){
                    // System.out.println("Stop Word");
                    //String value = stemmer.stripAffixes(key);
                    //System.out.println(value);
                    //JOptionPane.showMessageDialog(null,"These are stop words ignore them","Error",0);
                }
                else if(key.length()<=2){
                    //JOptionPane.showMessageDialog(null,"String Must be more than 2 characters","Error",0);
                }
                
                else{
                    String value = stemmer.stripAffixes(key);
                    avl.insert(value);
                   
                
                }
            
            }
        
        return avl;
    
    
    
    }  
}
    
    
