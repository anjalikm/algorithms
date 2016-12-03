/*
  Remove all duplicate elements from a sorted linked list
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* RemoveDuplicates(Node *head)
{
  // This is a "method-only" submission. 
  // You only need to complete this method. 
    Node * anchor = head;
    if(head == NULL)
        return NULL;
    Node * current = anchor->next;
    while(current != NULL){
        while(current != NULL && anchor->data == current->data){
            current = current->next;
        }
        anchor->next = current;
        anchor = current;
        if(current != NULL)
            current = current->next;
    }
    return head;
}
