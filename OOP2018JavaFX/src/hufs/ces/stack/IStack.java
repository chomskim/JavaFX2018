package hufs.ces.stack;

interface IStack<T> {

	T pop();
	void push(T data);
	boolean empty();
	T top();

}
