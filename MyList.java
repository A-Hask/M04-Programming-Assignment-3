public interface MyList<E> {
  
  default public void addAll(){ }
  
  default public void removeAll(){ }
  
  default public void retainAll(){ }
 
  default public void toArray(){ }
  
  default public void toArray(E[] elements){ }
  
}