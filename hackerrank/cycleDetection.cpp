/*
Detect a cycle in a linked list. Note that the head pointer may be 'NULL' if the list is empty.

A Node is defined as: 
    struct Node {
        int data;
        struct Node* next;
    }
*/

bool has_cycle(Node* head) {
    // Complete this function
    // Do not write the main method
    if(head == NULL)
        return false;
    Node * first = head;
    Node * second = head;
    while( second != NULL){
        first  = first->next;
        if(second->next != NULL)
            second = second->next->next;
        else
            second = NULL;
        if(first == second) // cycle found
            return true;
    }
    //end of the list reached so no cycle
    return false;
}