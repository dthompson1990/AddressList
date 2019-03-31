//Name: Darian Thompson
//AddressList class
import java.util.ArrayList;
public class AddressList
{
   private ListNode head;
   private ListNode currentNode;
   public AddressList ()
   {
      head = null;
      currentNode = null;
   }
   public ListNode getHead()
   {
      return head;
   }
   public ListNode getCurrent()
   {
      return currentNode;
   }
   public void setHead(ListNode node)
   {
      head = node;
   }
   public void setCurrent(ListNode node)
   {
      currentNode = node;
   }
   public class ListNode
   {
      private String name;
      private String tel;
      private String email;
      private String addr;
      private String dob;
      private ListNode next;

       private ListNode(String name, String tel, String email, String addr, String dob)
       {
       this.name = name;
       this.tel = tel;
       this.email = email;
       this.addr = addr;
       this.dob = dob;
    } // end of the constructor
       public String getName() 
       { 
         return name; 
       }
       public String getTel() { return tel; }
       public String getEmail() { return email; }
       public String getAddr() { return addr; }
       public String getDob() {return dob; }
       public void setName(String name) { this.name = name; }
       public void setTel(String tel) { this.tel = tel; }
       public void setEmail(String email) { this.email = email; }
       public void setAddr(String addr) { this.addr = addr; }
       public void setDob(String dob) { this.dob = dob; }
       public ListNode getNext() { return next; }
       public void setNext(ListNode link) { next = link; }
       public String toString()
       {
         String nodeString = ("Name: " + this.getName() + " Telephone: " + this.getTel() + " Email: " + this.getEmail()
         + " Address: " + this.getAddr() + " Date of Birth: " + this.getDob() + "\n");
         return nodeString;
       }
    }
    //method used to set reininitialize the head to the current node
    //method needs to be used for most other methods to work correctly
    public void reset()
    {
      currentNode = head;
    }
    public void clear()
    {
      head = null;
      currentNode = null;
    }
    public boolean isEmpty()
    {
      if (currentNode == null && head == null)
         return true;
      else
         return false;
    }
    public int sizeOf()
    {
      if (currentNode == null)
         return 0;
      else
      {
         this.setCurrent(currentNode.getNext());
         return 1 + sizeOf();
      }
    }
    public void addToFront(String name, String tel, String email, String address, String dob)
    {
      ListNode node = new ListNode(name, tel, email, address, dob);
      node.setNext(head);
      head = node;
    }
    public void addToBack(String name, String tel, String email, String address, String dob)
    {
      if (currentNode.getNext() == null)
      {
         ListNode node = new ListNode(name, tel, email, address, dob);
         currentNode.setNext(node);
         node.setNext(null);
      }
      else
      {
         currentNode = currentNode.getNext();
         addToBack(name, tel, email, address, dob);
      }
    }
    
    public String toString()
    {
      if (head == null)
         return "Empty Linked List";
      if (currentNode == null)
         return "";
      else
      {
         String listString = currentNode.toString();
         currentNode = currentNode.getNext();
         return listString.concat(this.toString());
      }
    }
    public String phoneNumberByName(String name)
    {
         if (currentNode == null)
            return ("No matching data");
         else if (currentNode.getName().equals(name))
            return currentNode.getTel();
         else
         {
            currentNode = currentNode.getNext();
            return phoneNumberByName(name);
         }
    }
    public String emailByName(String name)
    {
      if (currentNode == null)
         return ("No matching data");
      else if (currentNode.getName().equals(name))
         return currentNode.getEmail();
      else
      {
         currentNode = currentNode.getNext();
         return emailByName(name);
      }
    }
    public String nameByPhoneNumber(String tel)
    {
      if (currentNode == null)
         return ("No matching data");
      else if (currentNode.getTel().equals(tel))
         return currentNode.getName();
      else
      {
         currentNode = currentNode.getNext();
         return nameByPhoneNumber(tel);
      }
    }
    public String dobByName(String name)
    {
      if (currentNode == null)
         return ("No matching data");
      else if (currentNode.getName().equals(name))
         return currentNode.getDob();
      else
      {
         currentNode = currentNode.getNext();
         return dobByName(name);
      }
    }
  public String reverseToString()
    {
      if (head == null)
         return "Empty Linked List";
      if (currentNode == null)
         return "";
      if (currentNode.getNext() == null)
         return head.toString();
      String nodeContent = currentNode.getNext().toString();
      currentNode = currentNode.getNext();
      return nodeContent.concat(reverseToString());

    } 
   private void addToFront(ListNode node)
   {
      addToFront(node.getName(), node.getTel(), node.getEmail(), node.getAddr(), node.getDob());
   }
   public void addToBack(ListNode node)
   {
      addToBack(node.getName(), node.getTel(), node.getEmail(), node.getAddr(), node.getDob());
   }
   
   public AddressList reverse()
   {   
      if (currentNode == null) 
      {
         head = currentNode;
         return this;
      }
      else if (currentNode.getNext() == null)
      {
         head = currentNode;
         return this;  
      }
      else
      {
         ListNode cNode = currentNode.getNext();
         ListNode nNode = cNode.getNext();
         cNode.setNext(currentNode);
         currentNode = nNode.getNext();
         nNode.setNext(cNode);                
         return reverse();
      }
   } 
}
