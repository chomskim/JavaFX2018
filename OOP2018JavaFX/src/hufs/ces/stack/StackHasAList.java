package hufs.ces.stack;

import java.util.ArrayList;

class StackHasAList<T> implements IStack<T> {

	ArrayList<T> stackData;

	public StackHasAList() {
		stackData = new ArrayList<T>();
	}

	public static void main(String[] args) {
		IStack<String> staff = new StackHasAList<String>();

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
		stackData.remove(stackData.size()-1);
		return result;
	}

	@Override
	public void push(T data) {
		stackData.add(data);
	}

	@Override
	public boolean empty() {
		return stackData.size() == 0;
	}

	@Override
	public T top() {
		assert !empty();
		return stackData.get(stackData.size()-1);
	}

}
