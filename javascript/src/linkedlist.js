'use strict';
/**
 * Linked list implementation in vanilla JavaScript.
 * @author Brandon Manke
 * @file linkedlist.js
 */
function LinkedList() {
    this.head = null;
    this.size = 0;

    /**
     * This is a constructor for list elements / nodes.
     * @param data - data that node represents
     */
    function Node(data) {
        this.data = data;
        this.next = null;
    }
};

/**
 * @return size - Returns size of list
 */
LinkedList.prototype.getSize = function() {
    return this.size;
}

/**
 * Returns the value of the data at specified node.
 * @param index - Index of node, whose value is returned.
 * @return value - Value of node at specified index. (Or -1 if not found)
 */
LinkedList.prototype.getValue = function(index) {
    var current = this.head;
    var count = 0;
    if (index < 0 || index > (this.size - 1)) {
        throw console.log('Index out of bounds');
    }

    while (current.next !== null) {
        if (count === index) {
            return current.data;
        }
                
        if (count < this.size - 1) {
            count++;
        }
        current = current.next;
    }
    return -1; // if nothing is found
}

/**
 * Adds node at the beginning of the list.
 * @param data - data to be added to list
 */
LinkedList.prototype.insertBefore = function(data) {
    var current = new Node(data);

    if (this.head === null) {
        this.head = current;
        this.size++;
        return;
    }

    current.next = this.head;
    this.head = current;
    this.size++;
}

/**
 * Adds node at the end of the list.
 * @param data - data to be added to list
 */
LinkedList.prototype.insertAfter = function(data) {
    var current = this.head;

    if (this.head === null) {
        this.head = new Node(data);
        this.size++;
        return;
    }

    while (current.next !== null) {
        current = current.next;
    }

    current.next = new Node(data);
    this.size++;
}

/**
 * Removes node at the beginning of the list.
 * @return data of removed node
 */
LinkedList.prototype.removedHead = function() {
    if (this.head === null) {
        throw console.log('No such element');
    }
    var temp = this.head;
    this.head = temp.next;
    this.size--;
    return temp.data;
}

/**
 * Removes node at end of the list.
 * @return data of removed node
 */
LinkedList.prototype.removeEnd = function() {
    var current = this.head;
    if (this.head === null) {
        throw console.log('No such element');
    }

    while (current.next.next !== null) {
        current = current.next;
    }

    var temp = current.next;
    current.next = null;
    this.size--;
    return temp.data;
}

/**
 * Removes node at specified index.
 * @param index - position of element to be removed in list
 * @return data of removed node
 */
LinkedList.prototype.remove = function(index) {
    var current = this.head;
    var temp;
    var count = 0;
    if (index < 0 || index > (this.size - 1)) {
        throw console.log('Index out of bounds');
    }

    // TODO finish this logic prev.next = current.next
    while (current.next !== null) {
        if (count === index - 1) {
            temp = current.next;
            current.next = temp.next;
        }

        count++;
        current = current.next;
    }
    return temp.data;
}

/**
 * Reverses linked-list.
 */
LinkedList.prototype.reverse = function() {

}

/**
 * Removes first instance of value in linked-list.
 * @param value - value to be removed
 */
LinkedList.prototype.removeValue = function(value) {

}

/**
 * Returns list formatted as string with '-->' seperating data.
 * @return string - Formatted string of entire list data
 */
LinkedList.prototype.toString = function() {
    var current = this.head;
    var string = '';
    if (this.head !== null) {
        while (current.next !== null) {
            //if (current.next.next === null) {
            //    string += current.data + '-->' + current.next.data;
            //}
            string += current.data + '-->';
            current = current.next;
        }
    } else {
        throw console.log('List is empty');
    }
    string += current.data;
    return string;
}

// Tests:
var LinkedList = new LinkedList();
LinkedList.insertAfter(2);
LinkedList.insertBefore(3);
LinkedList.insertAfter(7);
LinkedList.insertAfter(5);
console.log('Size:', LinkedList.getSize());
console.log(LinkedList.toString()); // Prints 3-->2-->7-->5
