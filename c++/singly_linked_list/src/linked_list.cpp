/**
 * Singly linked list class
 * @author Brandon Manke
 */
template <class T>
class LinkedList {
    private:
        LinkedList *next;
        T data;
    public: 
        LinkedList(const T &value) : next(nullptr), data(value) {}

        ~LinkedList() {}

        LinkedList *getNext() const {
            return next;
        }

        const T& value() const {
            return data;
        }

        void setNext(LinkedList *el) {
            next = el;
        }

        void setValue(const T& value) {
            data = value;
        }
};
