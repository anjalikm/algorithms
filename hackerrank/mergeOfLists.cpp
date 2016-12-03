/*
   Find merge point of two linked lists
   Node is defined as
   struct Node
   {
       int data;
       Node* next;
   }
*/
int FindMergeNode(Node *headA, Node *headB)
{
    // Complete this function
    // Do not write the main method. 
    Node * listA = headA;
    Node * listB = headB;
    Node * anchorA;
    while(listA != NULL){
        anchorA = listA;
        listB = headB;
        while(listB != NULL){
            if(listB == anchorA)
                return listB->data;
            listB = listB->next;
        }
        listA = listA->next;
    }
    return -1;
}