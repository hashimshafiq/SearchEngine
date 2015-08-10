/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;

import java.io.IOException;
import javax.swing.JTable;

/**
 *
 * @author Hashim
 */
public class Core_of_Engine {
    
    private ReadingData reader;
    private LinkedList_of_AVL avllist; 
    private final porter stemmer  = new porter();
    private Hash_Table hash;
    
    public void read_data( JTable table,String search,String path){
       avllist = new LinkedList_of_AVL();
        reader = new ReadingData();
        try {
            reader.ReadData(avllist,path);
        } catch (IOException ex) {
           System.out.println("Error ! Reading Data");
        }
        this.hash_function(search, avllist);
        this.hash.start_search();
        this.hash.filltable(table);
   }
   
   
   public void hash_function(String search_str,LinkedList_of_AVL avllist){
     
       this.hash = new Hash_Table();
       search_str = search_str.toLowerCase().trim();
       search_str = this.remove_repeated_word_in_search_string(search_str);
       String[] search_array = search_str.split(" ");
      
      String stmr_word; 
      for(String str: search_array){
         stmr_word = this.stemmer.stripAffixes(str);
                if(stmr_word.trim().length()>0){
                           Data data = new Data();//ref for each hash value                   
                           avllist.copy_values(data, str);
                           hash.insert_in_hash(data, str);
                }
     
      }
        //System.out.println(search_str);
   }
   
   public String remove_repeated_word_in_search_string(String search){
       String[] arr = search.toLowerCase().trim().split(" ");
       String[] visited = new String[arr.length];
       int count = 0;
       boolean found = false;
       for(String str:arr){
           str= str.trim();
           for(int i = 0;i<count;i++){
              if(visited[i].equals(str)){
                  found = true;
                  break;
              } 
           }
           if(!found){
               visited[count] = str;
               count++;
           }
           found = false;
       }//end of outer for loop
       String new_search = "".trim();
       for(int i = 0;i<count;i++){
           new_search = new_search + visited[i]+" ";
       }
       return new_search.trim();
   }
   
    
  
    
}
