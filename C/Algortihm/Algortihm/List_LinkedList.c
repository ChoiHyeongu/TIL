#include <stdio.h>
#include <stdlib.h>

typedef int ElementType;

typedef struct tagNode {
	ElementType Data;	/* 데이터 필드 */
	struct Node* NextNode; /* 다음 노드를 가르키는 포인터 */
} Node;

/* 함수 원형 선언*/
Node*	SLL_CreateNode(ElementType NewData);
void	SLL_DestroyNode(Node* Node);
void	SLL_AppendNode(Node** Head, Node* NewNode);
Node*	SLL_GetNodeAt(Node* Head, int Location);
void	SLL_RemoveNode(Node** Head, Node* Remove);
void	SLL_InsertNewHead(Node** Current, Node* NewNode);
void	SLL_InsertAfter(Node* Current, Node* NewNode);
int		SLL_GetNodeCount(Node* Head);
/* 구현 1. 특정 노드옆에 새로운 노드를 삽입하는 함수 2. 링크드 리스트의 모든 노드를 한번에 제거하는 함수 */
void	SLL_InsertBefore(Node** Head, Node* Current, Node* NewHead);
void	SLL_DestroyAllNodes(Node ** List);

int main() {

	printf("[Vitamin Quiz]\n");
	printf("sizeof(Node) = %d\n", sizeof(Node));
	printf("sizeof(Node*) = %d\n\n", sizeof(Node*));

	int i = 0;
	int Count = 0;
	Node* List = NULL;
	Node* Current = NULL;
	Node* NewNode = NULL;

	/* 노드 5개 추가 */
	for (i = 0; i < 5; i++) {
		NewNode = SLL_CreateNode(i);
		SLL_AppendNode(&List, NewNode);
	}

	NewNode = SLL_CreateNode(-1);
	SLL_InsertNewHead(&List, NewNode);

	NewNode = SLL_CreateNode(-2);
	SLL_InsertNewHead(&List, NewNode);

	/* 리스트 출력 */
	Count = SLL_GetNodeCount(List, i);
	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	/* 리스트의 세 번째 노드 뒤에 새 노드 삽입 */
	printf("\nInserting 3000 After [2]...\n\n");

	Current = SLL_GetNodeAt(List, 2);
	NewNode = SLL_CreateNode(3000);

	SLL_InsertAfter(Current, NewNode);

	/* 리스트 출력 */
	Count = SLL_GetNodeCount(List, i);
	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	/* 리스트의 세 번째 노드 앞에 새 노드 삽입 (Vitamin Quiz)*/
	printf("\nInserting 3000 Before [2]...\n\n");

	Current = SLL_GetNodeAt(List, 2);
	NewNode = SLL_CreateNode(2000);

	SLL_InsertBefore(&List, Current, NewNode);

	/* 리스트 출력 */
	Count = SLL_GetNodeCount(List, i);
	
	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	/* 모든 노드를 메모리에서 제거 */
	printf("\nDestroying List...\n");

	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, 0);

		if (Current != NULL) {
			SLL_RemoveNode(&List, Current);
			SLL_DestroyNode(Current);
		}
	}

	/* 리스트 출력 */
	printf("\Printing List...\n");
	Count = SLL_GetNodeCount(List, i);

	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	/* 노드 5개 추가 */
	printf("\Adding Node...\n");
	for (i = 0; i < 5; i++) {
		NewNode = SLL_CreateNode(i);
		SLL_AppendNode(&List, NewNode);
	}


	/* 리스트 출력 */
	Count = SLL_GetNodeCount(List, i);
	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	/* 노드 전부 삭제 */
	printf("\nDestroying List...\n");
	SLL_DestroyAllNodes(&List);

	/* 리스트 출력 */
	printf("\Printing List...\n");
	Count = SLL_GetNodeCount(List, i);

	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	return 0;
}

// 노드 생성
Node* SLL_CreateNode(ElementType NewData) {
	Node* NewNode = (Node*)malloc(sizeof(Node));

	NewNode->Data = NewData;
	NewNode->NextNode = NULL;

	return NewNode;
}

//노드 소멸
void SLL_DestroyNode(Node* Node) {
	free(Node);
}

//노드 추가
void SLL_AppendNode(Node** Head, Node* NewNode) {
	/* 헤드 노드가 NULL이라면 새로운 노드 생성*/
	if ((*Head) == NULL) {
		*Head = NewNode;
	}
	else {
		/* 테일을 찾아 NewNode를 연결 */
		Node* Tail = (*Head);
		while (Tail->NextNode != NULL) {
			Tail = Tail->NextNode;
		}

		Tail->NextNode = NewNode;
	}
}

// 노드 탐색
Node* SLL_GetNodeAt(Node* Head, int Location) {
	Node* Current = Head;

	while (Current != NULL && (--Location) >= 0) {
		Current = Current->NextNode;
	}

	return Current;
}

//노드 제거
void SLL_RemoveNode(Node** Head, Node* Remove) {
	if (*Head == Remove) {
		*Head = Remove->NextNode;
	}
	else {
		Node* Current = *Head;
		while (Current != NULL && Current->NextNode != Remove) {
			Current = Current->NextNode;
		}

		if (Current != NULL) {
			Current->NextNode = Remove->NextNode;
		}
	}
}

//노드 추가
void SLL_InsertAfter(Node* Current, Node* NewNode) {
	NewNode->NextNode = Current->NextNode;
	Current->NextNode = NewNode;
}

void SLL_InsertNewHead(Node** Head, Node* NewHead) {
	if (*Head == NULL) {
		(*Head) == NewHead;
	}
	else {
		NewHead->NextNode = (*Head);
		(*Head) = NewHead;
	}
}

//노드 수 세기
int SLL_GetNodeCount(Node* Head) {
	int Count = 0;
	Node* Current = Head;

	while (Current != NULL) {
		Current = Current->NextNode;
		Count++;
	}

	return Count;
}

//Viamin Quiz 1
void SLL_InsertBefore(Node** Head, Node* Current, Node* NewHead) {
	
	Node* PrevNode = *Head;

	NewHead->NextNode = Current;

	if ((*Head)==Current) {
		SLL_InsertNewHead(Head, NewHead);
	}

	while(PrevNode != NULL && PrevNode->NextNode != Current) {
		PrevNode = PrevNode->NextNode;
		if (PrevNode->NextNode == Current) {
			PrevNode->NextNode = NewHead;
			NewHead->NextNode = Current;
		}
	}
}

void SLL_DestroyAllNodes(Node ** List) {
		
	int i = 0;
	int Count = SLL_GetNodeCount(*List);
	Node* Current;

	for (i = 0; i < Count ; i++) {
		Current = SLL_GetNodeAt(*List, 0);
		SLL_RemoveNode(List, Current);
	}
}