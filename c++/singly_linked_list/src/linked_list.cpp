/**
 * Simple singly linked list implementation
 * @author Brandon Manke
 */
#include <string>

template <class E>
class LinkedList {
    // list node
    struct Node {
        E data;
        Node *next;
    };

    private:
        Node *head;
        int size;
    public:
        LinkedList() {
            head = 0;
            size = 0;
        }

        ~LinkedList() {
            Node *current = head;
            while (current != 0) {
                Node *next = current->next;
                delete current;
                current = next;
            }
            head = 0;
        }

        /**
         * Adds value to end of linked list.
         * @param data - value to be added to end of list
         */
        void addToEnd(const E data) {
            if (head == 0) {
                head = new Node();
                head->data = data;
                head->next = 0;
                size++;
                return;
            }
            Node *current = head;
            while (current->next != 0) {
                current = current->next;
            }
            Node *temp = new Node();
            temp->data = data;
            temp->next = 0;
            current->next = temp;
            size++;
        }

        /**
         * Adds value to head/front of linked list.
         * @param data - value to be added to front of list
         */
        void addToFront(const E data) {
            Node *temp = new Node();
            temp->data = data;
            temp->next = head;
            head = temp;
            size++;
        }

        void addTo(const int index, const E data) {
            int counter = 0;

            if (index == 0)
                addToFront(data);

            if (index == getSize() - 1)
                addToEnd(data);

            Node *temp = new Node();
            temp->data = data;
            Node *current = head;

            while (current->next != 0) {
                if (counter == index - 1) {
                    break;
                }
            }
            temp->next = current->next;
            current->next = temp;
            size++;
        }

        E removeEnd() {
            if (head == 0)
                throw;

            Node *current = head;
            while (current->next->next != 0) {
                current = current->next;
            }
            Node *removed = current->next;
            delete current->next;
            current->next = 0;
            size--;
        }

        E removeFront() {
            if (head == 0)
                throw;

            Node *temp = head;
            head = head->next;
            size--;
        }

        E remove(const int index) {
            if (index == 0)
                removeFront();

            if (index == getSize() - 1)
                removeEnd();

            Node *current = head;
            Node *removed;
            int counter = 0;
            while (current->next != 0) {
                if (counter == index - 1) {
                    removed = current->next;
                    if (removed->next != 0) {
                        current->next = removed->next;
                    } else {
                        current->next = 0;
                    }
                } else {
                    counter++;
                    current = current->next;
                }
            }
        }

        /**
         * Prints list to string
         * @return str - list elements seperated by '->' in a string
         */
        std::string toString() const {
            std::string str = "";
            // returns true if template variable is a char or string at runtime
            bool isCharOrString = (std::is_same<E, char>::value || std::is_same<E, std::string>::value);
            if (head == 0) {
                return "List is empty.";
            }
            Node *current = head;
            while (current->next != 0) {
                // check if char or string, so it isnt converted to ascii value
                if (isCharOrString) {
                    str += current->data;
                    str += "->";
                } else {
                    str += std::to_string(current->data) + "->";
                }
                current = current->next;
            }
            if (isCharOrString) {
                str += current->data;
            } else {
                str += std::to_string(current->data);
            }
            return str;
        }

        /**
         * @return size of list
         */
        int getSize() const {
            return size;
        }

        /**
         * Sums all nodes of the list
         * @return sum - sum of entire list
         */
        int sum() const {
            //need checks for type of (double, float, int, long, etc.)
            int sum = 0;
            if (head == 0) {
                throw "List is empty, cannot sum list.";
            }
            Node *current = head;
            while (current != 0) {
                sum += current->data;
                current = current->next;
            }
            return sum;
        }

        /**
         * Computes average of all the values in list
         * @return average - floating point value of average
         */
        float average() const {
            //need checks for type of (double, float, int, long, etc.)
            float average = 0;
            if (head == 0) {
                throw "List is empty, cannot get average.";
            }
            average = this->sum();
            average /= size;
            return average;
        }

        /**
         * Adds param list to end of this linkedlist
         * @param list - LinkedList reference to be added to end of current list
         */
        void concat(const LinkedList<E> &list) {
            if (head == list.head) {
                return;
            }
            if (head == 0 && list.head != 0) {
                head = list.head;
                size += list.getSize();
                return;
            }
            Node *current = head;
            while (current->next != 0) {
                current = current->next;
            }
            current->next = list.head;
            size += list.getSize();
        }
};