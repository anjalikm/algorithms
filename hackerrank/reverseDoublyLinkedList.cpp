/*
   Reverse a doubly linked list, input list may also be empty
   Node is defined as
   struct Node
   {
     int data;
     Node *next;
     Node *prev;
   }
*/
Node* Reverse(Node* head)
{
    // Complete this function
    // Do not write the main method. 
    Node * previous = NULL;
    Node * current = head;
    while(current != NULL){
        Node * temp = current->next; // old next
        current->next = previous; // old prev is new next
        current->prev = temp; // old next is new prev
        previous = current;
        current = temp;
        
    }
    
    head = previous;
    return head;
}
