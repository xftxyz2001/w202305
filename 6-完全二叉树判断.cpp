#include <stdio.h>
#include <stdlib.h>

#define MAX 100

typedef  char TElemType;  //�����Ӽ��������ÿ������ֵΪchar 
typedef struct BiTNode{
    TElemType data;
    struct BiTNode *LChild,*RChild;
}BiTNode,*BiTree;

//�����ǽ̲��ϵĽ������������� 
void CreateBiTree(BiTree *T){
  char ch;
  ch=getchar();
  if (ch==' ') (*T)=NULL;                    /* #�����ָ��*/
  else {
    (*T)=(BiTree) malloc(sizeof(BiTNode));/*������   */
    (*T)->data=ch;                        /*���ɸ����  */
    CreateBiTree(&(*T)->LChild) ;         /*����������  */
    CreateBiTree(&(*T)->RChild) ;         /*����������  */
   }
}

int IsCompleteBT(BiTree T){
	BiTNode  *Queue[MAX],*p;   //��һ���ܴ������ģ�����      
  	int front,rear,tag=1;

    front=rear=0;  //��ʼ������Ϊ�� 

    if(T==NULL)  return 1;  //��������ȫ������
	
	Queue[rear++]=T;           /*����������*/

    while (front!=rear){       /*�����зǿ�*/
      	p=Queue[front++];        /*����Ԫ�س����У�������������*/
	    
      	if (p->LChild!=NULL) 
		{
		   if(tag==0) return 0; //����ڴ�֮ǰ�Ѿ��������գ����ȷ��������ȫ������ 
		   else  Queue[rear++]=p->LChild; /*�������ǿգ��������*/
		}
      	else tag=0;  //��¼���ӵ�һ�������յ����������tagΪ0
		   
      	if (b->RChild!=NULL)  
		{
			if(tag==0) return 0;   //����ڴ�֮ǰ�Ѿ��������գ����ȷ��������ȫ������ 
			else Queue[rear++]=p->RChild; /*�������ǿգ��������*/
		}
		else  tag=0; //��¼�Һ��ӵ�һ�������յ����������tagΪ0    	
    }
    
    return 1;
}

//���ö��в��� 
//int IsCompleteBT(BiTree T){
//	Queueu Q;
//	BiTNode *p;     
//  int tag=1;
//
//  InitQueue(&Q); //��ʼ������Ϊ�� 
//
//  if(T==NULL)  return 1;  //��������ȫ������
//	
//	EnterQueue(&Q,T);         /*����������*/
//
//  while (!IsEmpty(&Q)){       /*���зǿ�*/
//      DeleteQueue(&Q,&p);    /*����Ԫ�س����У�������������*/
//	    
//      if (p>LChild!=NULL) 
//		{
//		   if(tag==0) return 0; //����ڴ�֮ǰ�Ѿ��������գ����ȷ��������ȫ������ 
//		   else  EnterQueue(&Q,p->LChild;; /*�������ǿգ��������*/
//		}
//      else tag=0;  //��¼���ӵ�һ�������յ����������tagΪ0
//		   
//      if (p->RChild!=NULL)  
//		{
//			if(tag==0) return 0;   //����ڴ�֮ǰ�Ѿ��������գ����ȷ��������ȫ������ 
//			else EnterQueue(&Q,p->RChild); /*�������ǿգ��������*/
//		}
//		else  tag=0; //��¼�Һ��ӵ�һ�������յ����������tagΪ0    	
//    }
//    
//    return 1;
//}
//

//�Լ���дһ�����������Ѹ����������ܲ���һ��,OK�ˡ� 
int main(){
	BiTree T=NULL;
	int b;
	
	printf("\nCreate a Binary Tree,# means NULL\n");
	CreateBiTree(&T);  /*����һ�ö�����T*/

  	printf("%d",IsCompleteBT(T));     /*��α���������*/  	
  
  	return 1;
}

