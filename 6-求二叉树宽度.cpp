#include "stdio.h"
#include "stdlib.h"

#define TRUE 1
#define FALSE 0
#define MAXSIZE 50  /*���е���󳤶�*/

typedef  char TElemType;
typedef struct BiTNode{
    TElemType data;
    struct BiTNode *lchild,*rchild;
}BiTNode,*BiTree;

/*****************************/
typedef BiTNode* QueueElementType;
typedef struct
{
  QueueElementType  elem[MAXSIZE];  
  int  front;  
  int  rear ;  
}SeqQueue;

void InitQueue(SeqQueue *SQ)
{
  SQ->front=SQ->rear=0;
}

int IsEmpty(SeqQueue SQ)
{
    if(SQ.front==SQ.rear)  return 1;
    else return 0;
}
int EnterQueue(SeqQueue *SQ,QueueElementType x)
{
 	if( (SQ->rear+1)%MAXSIZE==SQ->front )
 	{printf("Queue is Full\n");return FALSE;}

 	SQ->elem[SQ->rear]=x;
 	SQ->rear=(SQ->rear+1)%MAXSIZE;
 	return TRUE;
}

int DeleteQueue(SeqQueue *SQ,QueueElementType *x)
{
  	if(SQ->front==SQ->rear)
  	{printf("Queue is NULL\n"); return FALSE;}

  	*x=SQ->elem[SQ->front];
  	SQ->front=(SQ->front+1)%MAXSIZE;
  	return TRUE;
}
int getHead(SeqQueue *SQ,QueueElementType *x)
{
  	if(SQ->front==SQ->rear)
  	{printf("Queue is NULL\n"); return FALSE;}

  	*x=SQ->elem[SQ->front];  	
  	return TRUE;
}

void CreateBiTree(BiTree *T){

  char ch;

  ch=getchar();
  if (ch==' ') (*T)=NULL;                    /* #�����ָ��*/
  else {
    (*T)=(BiTree) malloc(sizeof(BiTNode));/*������   */
    (*T)->data=ch;                        /*���ɸ����  */
    CreateBiTree(&(*T)->lchild) ;         /*����������  */
    CreateBiTree(&(*T)->rchild) ;         /*����������  */
    }
}
int maxWidth(BiTree T){
 
   BiTNode *p;          
   SeqQueue Q;  
   int max=0,count=0;

   InitQueue(&Q); 
   if(T==NULL) return 0;
    
	EnterQueue(&Q,T); EnterQueue(&Q,NULL); //ÿ����NULL���� 
    while (!IsEmpty(Q)){      
        DeleteQueue(&Q,&p);
		  
		if(p!=NULL)   //һ��δ�������������������� 
		{
			count++;		  
			if (p->lchild!=NULL) 	EnterQueue(&Q,p->lchild);
		  	if (p->rchild!=NULL) 	EnterQueue(&Q,p->rchild);
       	}
       	else    //һ������������ж� 
       	{
			if(max < count) max=count;
			count=0;
			EnterQueue(&Q,NULL); //��NULL����������
			getHead(&Q,&p);
			if(p==NULL) break; //����Ԫ���Ѿ������꣬���� 
		}
	}
	return max;
}

int main()
{
	BiTree bt;
	CreateBiTree(&bt);
	printf("maxWidth=%d",maxWidth(bt));
	
	return 1;
}
