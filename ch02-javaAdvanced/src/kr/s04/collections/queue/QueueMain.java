package kr.s04.collections.queue;

import java.util.LinkedList;

public class QueueMain {
	public static void main(String[] args) {
		String[] array = {"서울","부산","대구","광주","인천"};
		
		//큐(Queue) : 선입선출 FIFO(First-In First-Out) 방식
		LinkedList<String> queue = new LinkedList<String>();
		for(int i=0;i<array.length;i++) {
			queue.offer(array[i]);
		}
		
		//요소의 목록 출력
		System.out.println(queue);
		System.out.println("========================");
		
		while(queue.peek() != null) {//큐에 저장된 첫번째 요소를 검색
			          //데이터가 큐 안에 있는 한 첫 번째 요소는 늘 있으니까
			//큐에 저장된 첫번째 요소를 반환하고 큐에서 제거: poll
			System.out.print(queue.poll() + "\t");
		}
		System.out.println("\n============================");
		System.out.println(queue);
	}
}
