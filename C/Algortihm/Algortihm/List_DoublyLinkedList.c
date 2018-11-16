#include <stdio.h>
#include <stdlib.h>

typedef int ElementType;

typedef struct tagNode {
	ElementType Data;	/* 데이터 필드 */
	struct tagNode* NextNode; /* 다음 노드를 가르키는 포인터 */
	struct tagNode* PrevNode; /* 이전 노드를 가르키는 포인터 */
} Node;

static ElementType count = 0;

// 노드 생성
Node* DLL_CreateNode(ElementType NewData) {
	Node* NewNode = (Node*)malloc(sizeof(Node));

	NewNode->Data = NewData;
	NewNode->NextNode = NULL;
	NewNode->PrevNode = NULL;

	return NewNode;
}

//노드 제거
void DLL_DeleteNode(Node* node) {
	free(node);
}

Node* DLL_GetNodeAt(Node *head, int index) {
	
	Node* pos = head;
	int count = 0;

	while (pos != NULL) {
		if (count++ == index) {
			return pos;
		} 
		pos = pos->NextNode;	
	}

	return NULL;
}

int DLL_CountNode(Node* head) {
	int count = 0;
	Node* pos = head;

	while (pos != NULL) {
		pos = pos->NextNode;
		count++;
	}

	return count;
}

void DLL_addNode(Node** head, Node* newNode) {
	// no list exists
	if (*head == NULL) {
		*head = newNode;
	}
	// list exists
	else {
		Node* pos = (*head);

		while (pos->NextNode != NULL) {
			pos = pos->NextNode;
		}

		pos->NextNode = newNode;
		newNode->PrevNode = pos;
	}
}

void DLL_InsertAfterNode(Node* curNode, Node* newNode) {

	// head 
	if (curNode->PrevNode == NULL && curNode->NextNode == NULL) {
		curNode->NextNode = newNode;
		newNode->PrevNode = curNode;
	} 
	// not head

	//if tail
	if (curNode->NextNode == NULL) {
		curNode->NextNode = newNode;
		newNode->PrevNode = curNode;
	}
	//in the middle of 2 nodes
	else {
		curNode->NextNode->PrevNode = newNode;
		newNode->PrevNode = curNode;
		newNode->NextNode = curNode->NextNode;
		curNode->NextNode = newNode;
	}
}

void DLL_RemoveNode(Node** head, Node* remove) {

	if (*head == remove) {
		*head = remove->NextNode;
	}

	if (remove->NextNode != NULL) {
		remove->NextNode->PrevNode = remove->PrevNode;
	}

	if (remove->PrevNode != NULL) {
		remove->PrevNode->NextNode = remove->NextNode;
	}

	DLL_DeleteNode(remove);
}


int main() {

	int i = 0;
	int count = 0;

	Node* List = NULL;
	Node* newNode = NULL;
	Node* CurrNode = NULL;

	for (i = 0; i < 5; i++) {
		newNode = DLL_CreateNode(i);
		DLL_addNode(&List, newNode);
	}

	count = DLL_CountNode(List);
	for (i = 0; i < count; i++) {
		CurrNode = DLL_GetNodeAt(List, i);
		printf("List[%d] = %d\n", i, CurrNode->Data);
	}
	printf("---------- 5 Nodes Created ----------\n");

	newNode = DLL_CreateNode(99);
	CurrNode= DLL_GetNodeAt(List, 0);
	DLL_InsertAfterNode(CurrNode, newNode);
	
	newNode = DLL_CreateNode(444);
	CurrNode = DLL_GetNodeAt(List, 4);
	DLL_InsertAfterNode(CurrNode, newNode);

	count = DLL_CountNode(List);
	for (i = 0; i < count; i++) {
		CurrNode = DLL_GetNodeAt(List, i);
		printf("List[%d] = %d\n", i, CurrNode->Data);
	}
	printf("---------- After 2 Nodes inserted ----------\n");

	newNode = DLL_GetNodeAt(List, 1);
	DLL_RemoveNode(&List, newNode);

	newNode = DLL_GetNodeAt(List, 0);
	DLL_RemoveNode(&List, newNode);

	count = DLL_CountNode(List);
	for (i = 0; i < count; i++) {
		CurrNode = DLL_GetNodeAt(List, i);
		printf("List[%d] = %d\n", i, CurrNode->Data);
	}
	printf("---------- After Node with index 1 removed ----------\n");

	return 0;
}