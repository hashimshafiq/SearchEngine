/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;

/**
 *
 * @author Hashim
 * @param <T>
 */
public class AVL<T extends Comparable<T>>{
    
    // Node Class
    private class Node{
        private Node left;
        private Node right;
        private T info;
        private int count = 1;
    
        Node(T info,Node left,Node right){
            this.info = info;
            this.left = left;
            this.right = right;
        }
        
    }
    
    // Data Members of AVL Class
    public Node root;
    int inner,outer;
    // this method insert data in AVL Trees
    public void insert(T info){
        Node current = root;
        if(current==null){
            root = new Node(info,null,null);
            return;
        }
        
        while(true){
            if(info.compareTo(current.info)<0){
                if(current.left==null){
                    current.left = new Node(info,null,null);
                    break;
                }else{
                    current = current.left;
                }
            }else if(info.compareTo(current.info)>0){
                if(current.right==null){
                    current.right = new Node(info,null,null);
                    break;
                }else{
                    current = current.right;
                }
        
            }else if(info.compareTo(current.info)==0){
                
                return;
            }
        }
        this.check_balancing(root);
        this.root_balance();
    }
    
    // This method search for specific info from AVL Trees
    public Node Search(T info){
        Node current = root;
        if(current==null)
            return null;
        else{
            while(current!=null){
                if(info.compareTo(current.info)==0)
                    return current;
                else if(info.compareTo(current.info)<0)
                    current = current.left;
                else if(info.compareTo(current.info)>0)
                    current = current.right;
            }
        
        }
        return null;
    }
    
    
    
    // This method calculates the word frequency
    public int word_frequency(T info){
        Node current = root;
        if(current==null)
            return 0;
        else{
            while(current!=null){
                if(info.compareTo(current.info)==0)
                    current.count++;
                else if(info.compareTo(current.info)<0)
                    current = current.left;
                else if(info.compareTo(current.info)>0)
                    current = current.right;
                
            }
        
        }
        return current.count;
    
    
    }
    
    
    // count leaf nodes
    public int leaf_nodes_counter(Node current){
        int left=0;
        int right=0;
        int count=0;
        if(current==null)
            return 0;
        else{
            if(current.left==null&&current.right==null)
                return 1;
            else{
                if(current.left!=null)
                    left += leaf_nodes_counter(current.left);
                if(current.right!=null)
                    right += leaf_nodes_counter(current.right);
            }
        
        }
        count = left+right;
        return count;
        
    }
    
    // this method counts internal nodes
    public int nodes_counter(Node current)
     {  
         int leaf = leaf_nodes_counter(current);
         if (current == null)
             return 0;
         else
         {
             int nodes = 1;
             nodes += nodes_counter(current.left);
             nodes += nodes_counter(current.right);
             return nodes;
         }
        
     }
    
    // height calculator method
    public int height(Node current){
        if(current==null)
            return 0;
        int left_height=0,right_height=0;
        left_height = height(current.left);
        right_height = height(current.right);
        return Math.max(left_height+1, left_height+1);
        
    }
    
    public int internal_nodes_counter(Node root){
        int leaf = this.leaf_nodes_counter(root);
        int t_nodes = this.nodes_counter(root);
        return t_nodes-leaf;
        
    }
    
    public int balance_factor(Node current){
        int left_height = height(current.left);
        int right_height = height(current.right);
        return (left_height+1)-(right_height+1);
    }
    
    public int update_frequency(T info){
        Node current = root;
        if(root == null){
            return 0;
        }
        
        else{
                  while(current!=null){ 
                          if(info.compareTo(current.info)==0){
                           return current.count;
                          }
                       
                           else if(info.compareTo(current.info)<0){       
                                  current = current.left;         
                            }

                              else if(info.compareTo(current.info)>0){
                                       current = current.right;
                               }     
                           }
                  return 0;
             }
    }
    public void inorder(){
         in_order(root);
     //     System.out.println();
    }
    private void in_order(Node current){
         if(current == null){
            return;
        }
       
              in_order(current.left); 
              // System.out.print(current.info+"("+(current.count)+") ");
              in_order(current.right);  
            
    }
    
    ////////////////////////////// Roatation  Functions ///////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    public void check_balancing(Node temp){
        if(temp.left == null&&temp.right==null){
            return ;
        } 
            if(temp.left!=null){
            check_balancing(temp.left);
            }
            if(temp.right!=null){
            check_balancing(temp.right);
            }
            
            //check  wether left child is unbalanced or not
            if(temp.left!=null){
            outer =  balance_factor(temp.left);
                       //for left rotation in given node
                    if(outer <= -2){
                       inner = balance_factor(temp.left.right);
                                      if(inner>=0){
                                          r_rotation_rightsubtree(temp.left);
                                          l_rotation_leftsubtree(temp);   //for double rotation rl rotation in left subtree
                                      }

                                      else if(inner<0){
                                         l_rotation_leftsubtree(temp);///left rotation in left sub tree
                                      }//end of inner else if                      
                  }
                        
                    //for right  rotation in given node left subtree
                    else if(outer >= 2){
                                      inner = balance_factor(temp.left.left);
                                      if(inner>=0){
                                          r_rotation_leftsubtree(temp);
                                      }

                                      else if(inner<0){
                                            l_rotation_leftsubtree(temp.left); //for double rotation lr rotation in right subtree
                                            r_rotation_leftsubtree(temp);
                                      }//end of inner else if
             
                    }//end of outer else if
            }//end of if for left checking
            
             //check wether right child is unbalanced or not
            if(temp.right!=null){
                outer =  balance_factor(temp.right);
                 if(outer <= -2){
                       inner = balance_factor(temp.right.right);
                                      if(inner>=0){
                                          this.r_rotation_rightsubtree(temp.right);
                                          this.l_rotation_rightsubtree(temp);
                                      }

                                      else if(inner<0){
                                         l_rotation_rightsubtree(temp);
                                      }//end of inner else if                      
                  }
                 
                 else if(outer >= 2){
                                      inner = balance_factor(temp.right.left);
                                      if(inner>=0){
                                          r_rotation_rightsubtree(temp);
                                      }

                                      else if(inner<0){
                                              this.l_rotation_leftsubtree(temp.right);
                                              this.r_rotation_rightsubtree(temp);
                                      }//end of inner else if
             
                    }
                 
            }//end of if for right
        
   }
   
   private void l_rotation_leftsubtree(Node curr){//for left rotation in left sub tree   
                                Node temp = curr.left.right;
                                curr.left.right = temp.left;
                                temp.left = curr.left;
                                curr.left = temp;
   }
   
    private void r_rotation_leftsubtree(Node curr){   //for right right rotation in left sub tree            
                                 Node temp= curr.left.left;
                                 curr.left.left= temp.right;
                                 temp.right = curr.left;
                                 curr.left = temp; 
                       
   }
    
    
       private void l_rotation_rightsubtree(Node curr){//for left rotation in right sub tree 
                                Node temp = curr.right.right;
                                curr.right.right = temp.left;
                                temp.left = curr.right;
                                curr.right = temp;
       }
   
        private void r_rotation_rightsubtree(Node curr){   //for right right rotation in right sub tree            
                                
                                 
                                  Node temp= curr.right.left;
                                 curr.right.left= temp.right;
                                 temp.right = curr.right;
                                 curr.right = temp;
             }
        
        
        
        //balancing root if root balancing factor is not in range
        public void root_balance(){
            int outer,inner;
            outer = this.balance_factor(root);
            
            if(outer>=2){
                  inner = this.balance_factor(root.left);
                  if(inner>=1){
                      Node temp = root.left;//right rotation
                      root.left =temp.right;
                      temp.right = root;
                      root = temp;
                  }
                  
                  else if(inner<=-1){
                     this.l_rotation_leftsubtree(root);
                        Node temp = root.left;//right rotation
                      root.left =temp.right;
                      temp.right = root;
                      root = temp;
                  }
            }
            
            else if(outer<=-2){
                inner = this.balance_factor(root.right);
                 if(inner>=1){
                     this.r_rotation_rightsubtree(root);
                      Node temp = root.right;//left rotation
                      root.right =temp.left;
                      temp.left = root;
                      root = temp;
                  }
                  
                  else if(inner<=-1){
                      Node temp = root.right;//left rotation
                      root.right =temp.left;
                      temp.left = root;
                      root = temp;
                  }
            }
        }
    
    
    
    
        
        
    
    }
        
    
    
    
    
    
    
    
    
    
    
    

