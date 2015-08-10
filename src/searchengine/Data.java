/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashim
 */
class Data {
    private porter stemmer;
    protected Node start;
    private Node current;
    
    private class Node{
        private Node below;
        private String word;
        private String stem_word;
        private String path;
        private AVL avl;
        private int frequency;
        
        Node(){}
        
        Node(Node below,String word,int frequency,String path,AVL avl){
            stemmer = new porter();
            this.below = below;
            this.word = word;
            this.frequency = frequency;
            this.path= path;
            this.avl = avl;
            this.stem_word = stemmer.stripAffixes(word);
        
        }
        
        
    
    }
    
    public void insert_in_data(String word,int frequency,String path,AVL avl){
            
            if(start == null){
                start = new Node(null,word,frequency,path,avl);
                
            }
            
            else{
                current = start;
                //Node temp = new Node(null,word,frequency,path,avl);
                while(true){
                    if(current.below==null){
                       current.below = new Node(null,word,frequency,path,avl);
                       break;
                       
                    }
                    current = current.below;
                    
                }
            }
      }
    
    public void update_frequency(){
           porter stemmer = new porter();
           current = start;
           int frequency;
           while(current!=null){
              frequency = current.avl.update_frequency(stemmer.stripAffixes(current.word));
              current.frequency = frequency;
              current = current.below;
           }
       }
    
    public void fill_table(JTable tbl){
          DefaultTableModel model = (DefaultTableModel) tbl.getModel();
                              
                  current = start;
                  while(current!=null){
                        current.avl.inorder();
                        if(current.frequency!=0){
                            Object x[] = {current.word,current.frequency,current.path};
                            model.addRow(x);
                        }
                        current = current.below;
                     }
      }
    
    
}
