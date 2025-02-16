package leetcode.linkedlist;

public class DoublyLinkedListProblems {
	class BrowserHistory {
		private static class BrowserNode {
			String url;
			BrowserNode next, prev;

			BrowserNode(String url) {
				this.url = url;
				next = null;
				prev = null;
			}
		}

		private BrowserNode head = null;
		private BrowserNode tail = null;

		public BrowserHistory(String homepage) {
			head = tail = new BrowserNode(homepage);
		}

		public void visit(String url) {
			BrowserNode newNode = new BrowserNode(url);
			tail.next = newNode;
			newNode.prev = tail;
			tail = tail.next;
		}

		public String back(int steps) {
			int cnt = 0;
			while (cnt < steps && tail.prev != null) {
				tail = tail.prev;
				cnt++;
			}
			return tail.url;
		}

		public String forward(int steps) {
			int cnt = 0;
			while (cnt < steps && tail.next != null) {
				tail = tail.next;
				cnt++;
			}
			return tail.url;
		}
	}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
}
