#include <stdio.h>
#include <stdlib.h>

typedef int ElementType;

typedef struct tagNode {
	ElementType Data;	/* ������ �ʵ� */
	struct Node* NextNode; /* ���� ��带 ����Ű�� ������ */
} Node;

/* �Լ� ���� ����*/
Node*	SLL_CreateNode(ElementType NewData);
void	SLL_DestroyNode(Node* Node);
void	SLL_AppendNode(Node** Head, Node* NewNode);
Node*	SLL_GetNodeAt(Node* Head, int Location);
void	SLL_RemoveNode(Node** Head, Node* Remove);
void	SLL_InsertNewHead(Node** Current, Node* NewNode);
void	SLL_InsertAfter(Node* Current, Node* NewNode);
int		SLL_GetNodeCount(Node* Head);
/* ���� 1. Ư�� ��忷�� ���ο� ��带 �����ϴ� �Լ� 2. ��ũ�� ����Ʈ�� ��� ��带 �ѹ��� �����ϴ� �Լ� */
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

	/* ��� 5�� �߰� */
	for (i = 0; i < 5; i++) {
		NewNode = SLL_CreateNode(i);
		SLL_AppendNode(&List, NewNode);
	}

	NewNode = SLL_CreateNode(-1);
	SLL_InsertNewHead(&List, NewNode);

	NewNode = SLL_CreateNode(-2);
	SLL_InsertNewHead(&List, NewNode);

	/* ����Ʈ ��� */
	Count = SLL_GetNodeCount(List, i);
	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	/* ����Ʈ�� �� ��° ��� �ڿ� �� ��� ���� */
	printf("\nInserting 3000 After [2]...\n\n");

	Current = SLL_GetNodeAt(List, 2);
	NewNode = SLL_CreateNode(3000);

	SLL_InsertAfter(Current, NewNode);

	/* ����Ʈ ��� */
	Count = SLL_GetNodeCount(List, i);
	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	/* ����Ʈ�� �� ��° ��� �տ� �� ��� ���� (Vitamin Quiz)*/
	printf("\nInserting 3000 Before [2]...\n\n");

	Current = SLL_GetNodeAt(List, 2);
	NewNode = SLL_CreateNode(2000);

	SLL_InsertBefore(&List, Current, NewNode);

	/* ����Ʈ ��� */
	Count = SLL_GetNodeCount(List, i);
	
	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	/* ��� ��带 �޸𸮿��� ���� */
	printf("\nDestroying List...\n");

	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, 0);

		if (Current != NULL) {
			SLL_RemoveNode(&List, Current);
			SLL_DestroyNode(Current);
		}
	}

	/* ����Ʈ ��� */
	printf("\Printing List...\n");
	Count = SLL_GetNodeCount(List, i);

	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	/* ��� 5�� �߰� */
	printf("\Adding Node...\n");
	for (i = 0; i < 5; i++) {
		NewNode = SLL_CreateNode(i);
		SLL_AppendNode(&List, NewNode);
	}


	/* ����Ʈ ��� */
	Count = SLL_GetNodeCount(List, i);
	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	/* ��� ���� ���� */
	printf("\nDestroying List...\n");
	SLL_DestroyAllNodes(&List);

	/* ����Ʈ ��� */
	printf("\Printing List...\n");
	Count = SLL_GetNodeCount(List, i);

	for (i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	return 0;
}

// ��� ����
Node* SLL_CreateNode(ElementType NewData) {
	Node* NewNode = (Node*)malloc(sizeof(Node));

	NewNode->Data = NewData;
	NewNode->NextNode = NULL;

	return NewNode;
}

//��� �Ҹ�
void SLL_DestroyNode(Node* Node) {
	free(Node);
}

//��� �߰�
void SLL_AppendNode(Node** Head, Node* NewNode) {
	/* ��� ��尡 NULL�̶�� ���ο� ��� ����*/
	if ((*Head) == NULL) {
		*Head = NewNode;
	}
	else {
		/* ������ ã�� NewNode�� ���� */
		Node* Tail = (*Head);
		while (Tail->NextNode != NULL) {
			Tail = Tail->NextNode;
		}

		Tail->NextNode = NewNode;
	}
}

// ��� Ž��
Node* SLL_GetNodeAt(Node* Head, int Location) {
	Node* Current = Head;

	while (Current != NULL && (--Location) >= 0) {
		Current = Current->NextNode;
	}

	return Current;
}

//��� ����
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

//��� �߰�
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

//��� �� ����
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