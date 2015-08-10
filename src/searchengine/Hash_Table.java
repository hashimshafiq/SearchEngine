/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;

import javax.swing.JTable;

/**
 *
 * @author Hashim
 * 
 */
public class Hash_Table{
   private Node start;
   private Node current;
   
   private class Node{
       private Node below;
       private Data data;
       private String word;
       
       Node(){
       
       }
       
       Node(Node below, Data data,String word){
           this.below = below;
           this.data = data;
           this.word = word;
       
       }
   
   }
   
   
   public void insert_in_hash(Data data,String word){
       if(start==null)
           start = new Node(null,data,word);
       else{
           current = start;
           Node temp = new Node(null,data,word);
           while(current.below!=null){
               current = current.below;
           }
           current.below = temp;
       }
   }
   
   public void start_search(){
          current = start;
          while(current!=null){
              current.data.update_frequency();
              
             current= current.below; 
             
          }
    
      }
   
      public void filltable(JTable tbl){
                current = start;
          while(current!=null){
              current.data.fill_table(tbl);
              current= current.below; 
          }
    
          }
    
    
}
