package hufs.ces.stack;

public class StackImplTest {

	static void testStackImpl(IStack<String> stack) {
		try {
			System.out.println ("Test Stack Implementation of "+stack.getClass());
			stack.push("Cracker, Carl");
			stack.push("Hacker, Harry");
			stack.push("Lam, Larry");
			stack.push("Sandman, Susan");
			System.out.println (stack.top());
			System.out.println (stack.pop());
			System.out.println (stack.top());

			stack.push("Reindeer, Rudolf");
			System.out.println (stack.top());
			//System.out.println (stack.get(0));//error
		} catch (Exception e) {
			System.out.println (e);
		}
	}
	public static void main(String[] args) {
		testStackImpl(new StackHasAList<String>());
		testStackImpl(new StackIsAList<String>());

	}

}
