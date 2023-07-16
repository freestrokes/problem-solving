package com.freestrokes.datastructure;

/*
 * Queue By Linked List (연결리스트로 구현한 큐)
 */

/**
 * 큐의 기능을 정의한 인터페이스
 */
interface QueueIF {
    boolean isEmpty();
    boolean isFull();
    void enqueue(String data);
    void dequeue();
    void peek();
    void clear();
}

/**
 * 큐를 구성하는 Node 클래스
 */
class ListQueueNode {
    private String data;    // 데이터 저장 변수
    public ListQueueNode link;    // 다른 노드를 참조할 링크

    public ListQueueNode() {
        this.data = null;
        this.link = null;
    }

    public ListQueueNode(String data) {
        this.data = data;
        this.link = null;
    }

    public ListQueueNode(String data, ListQueueNode link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }
}

/**
 * 연결 리스트로 구현한 큐 클래스
 */
public class QueueByLinkedList implements QueueIF {

    private ListQueueNode head;    // ListQueueNode 타입의 head 노드 인스턴스 변수
    private ListQueueNode front;    // 큐의 front 포인터
    private ListQueueNode rear;    // 큐의 rear 포인터
    private int queueSize;    // 큐 사이즈

    // 큐 생성자
    public QueueByLinkedList(int size) {
        head = null; // head 초기화
        front = null;    // front 포인터 초기화
        rear = null;    // rear 포인터 초기화
        this.queueSize = size;    // 큐 사이즈 초기화
    }

    // 큐가 비어있는 상태인지 확인
    public boolean isEmpty(){
        return (front == null && rear == null);
    }

    // 큐가 가득찬 상태인지 확인
    public boolean isFull() {
        // 큐 비어있을 경우 false return
        if(isEmpty()) {
            return false;
        }
        // 큐 포인터가 null이 아닌 경우 count 계산
        else {
            int nodeCount = 0;    // 큐 노드 카운터
            ListQueueNode tempNode = head;    // tempNode에 head 할당

            while(tempNode.link != null) {
                ++nodeCount;
                tempNode = tempNode.link;    // 다음 노드를 참조
            }

            // 큐 사이즈와 노드 카운트가 동일한 경우 true return
            return (this.queueSize-1 == nodeCount);
        }
    }

    // 큐에 Node 삽입
    public void enqueue(String data) {
        ListQueueNode newNode = new ListQueueNode(data);    // 새로운 노드 생성

        // 큐가 가득 찼을 경우
        if(isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        // 큐가 비었을 경우
        else if(isEmpty()) {
            // front,rear 포인터가 null인 경우 새로운 노드를 참조하도록 함
            // 이 때 head도 함께 새로운 노드를 참조하도록 함 (head는 첫 노드를 참조하는 용도로만 사용을 제한)
            this.head = newNode;
            this.front = this.head;
            this.rear = this.head;
        } else {
            // rear 포인터의 노드(마지막 노드) link가 새로운 노드를 참조하도록 함.
            // 이후 rear 포인터는 새로 추가된 노드를 참조하도록 함.
            rear.link = newNode;
            rear = newNode;
        }
    }

    // 큐에서 Node 삭제
    public void dequeue() {
        ListQueueNode tempNode;

        // front 포인터가 null인 경우 모든 노드가 삭제되었으므로 return
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        // front 포인터의 link가 null인 경우 (큐에 노드가 1개 남았을 경우)
        if(front.link == null) {
            // head와 front,rear 포인터에 null을 할당하여 남은 노드와의 연결을 끊고 초기화
            head = null;
            front = null;
            rear = null;
        } else {
            tempNode = front.link;    // tempNode는 front 포인터가 가리키는 노드의 다음 노드를 할당.
            head = tempNode;    // head가 tempNode를 참조하도록 함
            front.link = null;    // 기존에 front 포인터가 가리키는 노드의 link를 초기화하여 끊음
            front = head;    // front 포인터가 head(다음 노드)를 참조하도록 함
        }
    }

    // 큐의 첫번째 데이터 추출
    public void peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        } else {
            System.out.println(front.getData());
        }
    }

    // 큐 초기화
    public void clear() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        } else {
            // 큐의  head와 front,rear포인터 초기화
            head = null;
            front = null;
            rear = null;
        }
    }

    // 큐 Node 탐색
    public ListQueueNode searchNode(String data) {
        ListQueueNode tempNode = this.front;    // temp 노드에 front 포인터가 가리키는 노드를 할당.

        // temp 노드가 null이 아닐 때까지 반복하여 탐색
        while(tempNode != null) {
            // 주어진 데이터와 temp 노드의 데이터가 일치할 경우 해당 temp 노드를 return
            if(data.equals(tempNode.getData())) {
                return tempNode;
            } else {
                // 데이터가 일치하지 않을 경우 temp 노드에 다음 노드 할당.
                tempNode = tempNode.link;
            }
        }

        return tempNode;
    }

    // 큐에 저장된 모든 데이터를 출력
    public void printListQueue() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        } else {
            ListQueueNode tempNode = this.front;    // tempNode에 head가 가리키는 첫번째 노드를 할당

            // tempNode가 null이 아닐 때까지 반복하여 출력
            while(tempNode != null) {
                System.out.print(tempNode.getData() + " ");
                tempNode = tempNode.link;    // temp 노드에 다음 노드(tempNode.link) 할당.
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int queueSize = 5;
        String str = "D";
        QueueByLinkedList queueByLinkedList = new QueueByLinkedList(queueSize);    // 큐 생성

        queueByLinkedList.printListQueue();

        queueByLinkedList.enqueue("A");
        queueByLinkedList.printListQueue();
        queueByLinkedList.enqueue("B");
        queueByLinkedList.printListQueue();
        queueByLinkedList.enqueue("C");
        queueByLinkedList.printListQueue();
        queueByLinkedList.enqueue("D");
        queueByLinkedList.printListQueue();
        queueByLinkedList.enqueue("E");
        queueByLinkedList.printListQueue();
        queueByLinkedList.enqueue("F");
        queueByLinkedList.printListQueue();

        queueByLinkedList.dequeue();
        queueByLinkedList.printListQueue();
        queueByLinkedList.dequeue();
        queueByLinkedList.printListQueue();
        queueByLinkedList.peek();

        System.out.println(queueByLinkedList.searchNode(str).getData());
    }

}
