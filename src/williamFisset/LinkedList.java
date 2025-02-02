package williamFisset;

// Linked list is a sequential list of nodes that hold data which point to other node also containing data
// Where are LLs used?
//	- Many List, Queue and Stack implementations (due to optimum time complexity for addition/deletion)
//	- Great for creating circular lists (modelling circular problems like round-robin etc.)
//	- Model real-world objects like trains
//	- Used in separate chaining (in hashtable implementation to deal with hash collisions)
//	- Used in implementation od adjacency lists for graphs

// Terminology :
// Head : The first node in a LL (we always maintain a reference to it)
// Tail : The last node in a LL
// Pointer/Reference : Reference to another node
// Node : An object containing data and reference

// Singly Linked Lists
// node->node->node->node->null
// Only has pointer to next node
// In implementations we maintain reference to head and tail for quick addition and deletion
// Pros :
// 	- Use less memory
//	- Simple implementation
// Cons :
//	- Cannot easily access previous elements

// Doubly Linked Lists
// null->node<->node<->node->null
// Pointer to next and previous node
// In implementations we maintain reference to head and tail for quick addition and deletion from both ends of list
// Pros :
// 	- Can be traversed backwards
// Cons :
//	- Takes 2x memory

public class LinkedList {
}
