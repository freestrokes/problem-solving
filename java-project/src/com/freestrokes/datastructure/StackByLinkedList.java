package com.freestrokes.datastructure;

/*
 * Stack By Linked List (연결리스트로 구현한 스택)
 */

/**
 * 스택의 기능을 정의한 인터페이스
 */
interface StackIF {
    boolean isEmpty();
    boolean isFull();
    void push(String data);
    void pop();
    void peek();
    void clear();
}

/**
 * 스택을 구성하는 Node 클래스
 */
class ListStackNode {
    private String data;    // 데이터 저장 변수
    public ListStackNode link;    // 다른 노드를 참조할 링크

    public ListStackNode() {
        this.data = null;
        this.link = null;
    }

    public ListStackNode(String data) {
        this.data = data;
        this.link = null;
    }

    public ListStackNode(String data, ListStackNode link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }
}

/**
 * 연결 리스트로 구현한 스택 클래스
 */
public class StackByLinkedList implements StackIF {

    private ListStackNode head;    // ListStackNode 타입의 head 노드 인스턴스 변수
    private ListStackNode top;    // 스택의 top 포인터
    private int stackSize;    // 스택 사이즈

    // 스택 생성자
    public StackByLinkedList(int size) {
        head = null; // head 초기화
        top = null;    // top 포인터 초기화
        this.stackSize = size;    // 스택 사이즈 초기화
    }

    // 스택이 비어있는 상태인지 확인
    public boolean isEmpty(){
        return (top == null);
    }

    // 스택이 가득찬 상태인지 확인
    public boolean isFull() {
        // 스택 비어있을 경우 false return
        if(isEmpty()) {
            return false;
        }
        // 스택 포인터가 null이 아닌 경우 count 계산
        else {
            int nodeCount = 0;    // 스택 노드 카운터
            ListStackNode tempNode = head;    // tempNode에 head 할당

            while(tempNode.link != null) {
                ++nodeCount;
                tempNode = tempNode.link;    // 다음 노드를 참조
            }

            // 스택 사이즈와 노드 카운트가 동일한 경우 true return
            return (this.stackSize-1 == nodeCount);
        }
    }

    // 스택에 Node 삽입 (마지막에 삽입)
    public void push(String data) {
        ListStackNode newNode = new ListStackNode(data);    // 새로운 노드 생성
        // 스택이 가득 찼을 경우
        if(isFull()) {
            System.out.println("Stack is full!");
            return;
        }
        // 스택이 비었을 경우
        else if(isEmpty()) {
            // top 포인터가 null인 경우 새로운 노드를 참조하도록 함
            // 이 떄 head도 함께 새로운 노드를 참조하도록 함 (head는 첫 노드를 참조하는 용도로만 사용을 제한)
            this.head = newNode;
            this.top = this.head;
        } else {
            // top 노드가 null이 아닌 경우 temp 노드가 top을 참조하도록 함.
            // tempNode는 마지막 노드를 찾기 위해 사용.
            ListStackNode tempNode = top;

            // temp 노드의 link가 null이 아닐 때까지 다음 노드를 참조.
            // tempNode.link는 다음 노드를 참조하고 있으므로,
            // tempNode = tempNode.link는 tempNode가 다음 노드를 참조하도록 하는 것.
            // while문이 모두 실행되면 tempNode는 가장 마지막 노드를 참조한 상태가 됨.
            while(tempNode.link != null) {
                tempNode = tempNode.link;    // 다음 노드를 참조
            }

            // tempNode(마지막 노드)의 link가 다음 노드를 참조하도록 함.
            tempNode.link = newNode;
        }
    }

    // 스택에서 Node 삭제 (마지막 노드 삭제)
    public void pop() {
        ListStackNode preNode;
        ListStackNode tempNode;

        // top 포인터가 null인 경우 모든 노드가 삭제되었으므로 return
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        // top 포인터의 link가 null인 경우 (스택의 노드가 1개 남았을 경우)
        if(top.link == null) {
            // head와 top 포인터에 null을 할당하여 남은 노드와의 연결을 끊고 초기화
            head = null;
            top = null;
        } else {
            preNode = top;    // preNode는 top 포인터가 가리키는 노드를 할당
            tempNode = top.link;    // tempNode는 top 포인터가 가리키는 노드의 다음 노드 (preNode의 다음 노드)

            // tempNode의 link가 null이 아닐 때까지 한 노드씩 다음 노드로 이동.
            // preNode는 tempNode를 할당하고
            // tempNode는 tempNode의 다음 노드를 할당.
            // 이렇게 하면 preNode는 마지막 노드의 이전 노드가 되고, tempNode는 마지막 노드가 됨.
            while(tempNode.link != null) {
                preNode = tempNode;
                tempNode = tempNode.link;
            }

            // preNode의 link를 null로 만들어서 가장 마지막 노드를 삭제
            // 즉, preNode의 다음 노드인 tempNode로의 연결을 끊음.
            preNode.link = null;
        }
    }

    // 스택의 최상위(마지막) 데이터 추출
    public void peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        } else {
            ListStackNode tempNode = top;

            while(tempNode.link != null) {
                tempNode = tempNode.link;
            }

            System.out.println(tempNode.getData());
        }
    }

    // 스택 초기화
    public void clear() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        } else {
            // 스택 포인터와 head 초기화
            head = null;
            top = null;
        }
    }

    // 스택 Node 탐색
    public ListStackNode searchNode(String data) {
        ListStackNode tempNode = this.top;    // temp 노드에 top 포인터가 가리키는 노드를 할당.

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

    // 스택에 저장된 모든 데이터를 출력
    public void printListStack() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        } else {
            ListStackNode tempNode = this.top;    // tempNode에 head가 가리키는 첫번째 노드를 할당

            // tempNode가 null이 아닐 때까지 반복하여 출력
            while(tempNode != null) {
                System.out.print(tempNode.getData() + " ");
                tempNode = tempNode.link;    // temp 노드에 다음 노드(tempNode.link) 할당.
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int stackSize = 5;
        String str = "B";
        StackByLinkedList stackByLinkedList = new StackByLinkedList(stackSize);    // 스택 생성

        stackByLinkedList.printListStack();

        stackByLinkedList.push("A");
        stackByLinkedList.printListStack();
        stackByLinkedList.push("B");
        stackByLinkedList.printListStack();
        stackByLinkedList.push("C");
        stackByLinkedList.printListStack();
        stackByLinkedList.push("D");
        stackByLinkedList.printListStack();
        stackByLinkedList.push("E");
        stackByLinkedList.printListStack();
        stackByLinkedList.push("F");
        stackByLinkedList.printListStack();

        stackByLinkedList.pop();
        stackByLinkedList.printListStack();
        stackByLinkedList.pop();
        stackByLinkedList.printListStack();

        stackByLinkedList.peek();

        System.out.println(stackByLinkedList.searchNode(str).getData());
    }

}
