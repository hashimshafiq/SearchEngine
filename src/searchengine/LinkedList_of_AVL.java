/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;

/**
 *
 * @author Hashim
 */
public class LinkedList_of_AVL {
    protected Node start;
    private Node current;
    
     private class Node{
        protected Node next;
        private String path;
        private AVL avl;
        
        Node(){
            
        }
        
        Node(Node next,String path, AVL avl){
            this.next = next;
            this.path = path;
            this.avl = avl;
        }  
    
        public AVL getavl(){return avl;}
    }//end of node class
     
      public void insert_in_avl_linkedlist(Node next,String path, AVL avl){
            if(start == null){
                start = new Node(null,path,avl);            
            }
            
            else{
                current = start;
                Node temp = new Node(null,path,avl);
                while(current.next!=null){
                    current = current.next;   
                    
                    }
                    current.next = temp;
                       
                }
            }
        
      
      public void copy_values(Data data,String hash_word){
          current = start;
          while(current!=null){            
              
              data.insert_in_data(hash_word, 0, current.path,current.avl);     
              current = current.next;
          }
          
      }
      
    
}
