package hufs.ces.stack;

import java.util.ArrayList;

class StackIsAList<T> extends ArrayList<T> implements IStack<T> {

	StackIsAList() {
		super();
	}

	public static void main(String[] args) {
		IStack<String> staff = new StackIsAList<String>();

		staff.push("Cracker, Carl");
		staff.push("Hacker, Harry");
		staff.push("Lam, Larry");
		staff.push("Sandman, Susan");
		System.out.println (staff.top());
		System.out.println (staff.pop());
		System.out.println (staff.top());

		staff.push("Reindeer, Rudolf");
		System.out.println (staff.top());
		//System.out.println (staff.get(0));//error

	}

	@Override
	public T pop() {
		assert !empty();
		T result = top();
		this.remove(this.size()-1);
		return result;
	}

	@Override
	public void push(T data) {
		this.add(data);
	}

	@Override
	public boolean empty() {
		return this.size() == 0;
	}

	@Override
	public T top() {
		assert !empty();
		return this.get(this.size()-1);
	}

}
