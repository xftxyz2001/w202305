typedef struct Tnode   //����㶨��
{
	DataType data;
	int parent;
} TNode;
typedef struct     //������
{
    TNode tree[MAX]; 
    int nodenum;
}MFSet;


/* ȷ��x���ڲ��鼯SS���ĸ��Ӽ��ϡ����������SS����һ�Ӽ����򷵻�-1�����򷵻������Ӽ����ĸ�����±ꡣ*/
int Find_1 ( MFSst  *SS,  DataType  x)
{
    pos=Locate (SS, x);  //�ҵ�x�ڲ��鼯�е�λ��
    if ( pos<0 )  return -1
    i=pos; 

    while(SS->tree[i].parent > 0 )   //˳��˫����������
        i= SS->tree[i].parent ;
    return  i��
}
 
int Merge_1 ( MFSst  *SS,  int  root1,  int  root2 )
/* root1��root2�ǲ��鼯SS�����������ཻ�ķǿ��Ӽ����ĸ������Ӽ���root2�����Ӽ���root1��*/
{
	if ( root1<0 || root1> SS->nodenum-1 ) return  ERROR;
	if ( root2<0 || root2> SS->nodenum-1 ) return  ERROR;

	SS->tree[root2].parent=root1;
	return OK;
}


///////////////////////////
/*·��ѹ�� 
ȷ��x���ڲ��鼯SS���ĸ��Ӽ��ϣ�ͬʱ�����Ӽ�����������߶ȡ�
���x������SS����һ�Ӽ����򷵻�-1��
���������ҵ�x�����Ӽ����ĸ�root��
Ȼ��x��x���������ȣ�����root������Ϊroot���ӽ�㣬
��󷵻�root�� 
*/
int Find_2 ( MFSst  *SS,  DataType  x)
{
	pos=Locate (SS, x);
	if ( pos<0 )  return -1; 
	i=pos
	while ( SS->tree[i].parent > 0 )  
 		 i= SS->tree[i].parent ;
	root=i; 
	i=pos; 
	while ( i !=root )
	{
  		temp= SS->tree[i].parent ;
  		SS->tree[i].parent = root;
  		i= temp ;
	}
	return  root;
}

 
/* ���㷨�������Ŀ���ٵ��Ӽ�����������Ŀ�϶���Ӽ�����
parent�������н����Ŀ�ĸ�ֵ������ָ���ϲ�����*/ 
int Merge_2 ( MFSst  *SS,  int  root1,  int  root2 )
{    
	if ( root1<0 || root1> SS->nodenum-1 )   return  ERROR;
    if ( root2<0 || root2> SS->nodenum-1 )  return  ERROR;
    if ( SS->tree[root1].parent < SS->tree[root2].parent )
     {  
          SS->tree[root1].parent+= SS->tree[root2].parent ��
          SS->tree[root2].parent=root1; }
    else  /* �ڶ����Ӽ����н����Ŀ�϶� */
    {  
           SS->tree[root2].parent+= SS->tree[root1].parent ;
           SS->tree[root1].parent=root2;
	}
    return OK;
}

////////////////////////////////
// ���鼯��Ӧ�ã����鼯���ü��˵Ĵ洢�ṹ�����㷨˼����ͬ�� 
 
// 1. �ж�ͼ����ͨ������: ���ڽӾ��� g[][] ��ʾ����ͼ�ı�
int ComponentCount(){
    int s[n];
    for(int k = 0; k < n; k++){
        s[k] = -1;    // ��ʼ�����鼯
    }
 
    // ���������ߣ�����ͼ�����������ǲ��ּ��ɣ�
    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            if(g[i][j] > 0){    // ��� i, j ֮���б�
                int iRoot = Find(s, i);  // ͨ�����鼯�ҵ� i ��������
                int jRoot = Find(s, j);  // ͨ�����鼯�ҵ� j ��������
                if(iRoot != jRoot)  Union(s, iRoot, jRoot);   // i, j ����ͬһ����
            }int g[][],int n
        }
    }
 
    // ͳ���м�����ͨ����
    int count = 0;
    for(int i = 0; i < n; i++){
        if(s[i] < 0) count++;
    }
    return count;   
    // count = 1, ˵������ͨͼ��count > 1, ˵��������ͨͼ����count����ͨ������
}
 
// 2. �ж�ͼ�Ƿ��л�:���ڽӾ��� g[][] ��ʾ����ͼ�ı�
int ComponentCount(int g[][],int n){
    int s[n];
    for(int k = 0; k < n; k++)
        s[k] = -1;   // ��ʼ�����鼯
    
 
    // ���������ߣ�����ͼ�����������ǲ��ּ��ɣ�
    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            if(g[i][j] > 0){    // ��� i, j ֮���б�
                int iRoot = Find(s, i);  // �ҵ�i ��������
                int jRoot = Find(s, j);  // �� j ��������
 
                if(iRoot != jRoot)  Union(s, iRoot, jRoot);   // i, j ����ͬһ����
                else   return 1;  // i, j ԭ������ͬһ�����ϣ���ԭ������ͨ  
            }
        }
    }
    return 0;  // ͼ��û�л�
}

// 3. Kruskal�㷨
// �ܵ�ʱ�临�Ӷ� O(elog_2e)���ܹ�ִ��e�֣�ÿ���ж����������Ƿ�����ͬһ�����ϡ�
#include <stdio.h>
#include <stdlib.h>
#define N 9   // ͼ�бߵ�����
#define P 6   // ͼ�ж��������
//������ʾ�ߵĽṹ��
struct edge {   
    int start;  //һ������ 2 ������
    int end;    
    int weight;  //�ߵ�Ȩֵ
};

//qsort��������ʹ�ã�ʹedges�ṹ���еı߰���Ȩֵ��С��������
int cmp(struct edge a[], struct edge b[]) {
    return  a[i]->weight - b[i]->weight;
}
//��³˹�����㷨Ѱ����С��������edges �洢�û������ͼ�ĸ����ߣ�minTree ���ڼ�¼�����С�������ĸ�����
void kruskal_MinTree(struct edge edges[], struct edge minTree[]) {
    int i, start, end, elem, k;
    //ÿ����������һ�����ֵ
    int assists[P];
    int num = 0;
    //��ʼ״̬�£�ÿ������ı�Ƕ�����ͬ
    for (i = 0; i < P; i++) {
        assists[i] = i;
    }
    //����Ȩֵ�������б߽�����������
    qsort(edges, N, sizeof(edges[0]), cmp);
    //�������еı�
    for (i = 0; i < N; i++) {
        //�ҵ���ǰ�ߵ����������� assists �����е�λ���±�
        initial = edges[i].start - 1;
        end = edges[i].end - 1;
        //�������λ�ô����Ҷ���ı�ǲ�ͬ��˵������һ�������У����������·
        if (assists[initial] != assists[end]) {
            //��¼�ñߣ���Ϊ��С����������ɲ���
            minTree[num] = edges[i];
            //����+1
            num++;
            elem = assists[end];
            //���¼����������Ķ�����ȫ����Ϊһ����
            for (k = 0; k < P; k++) {
                if (assists[k] == elem) {
                    assists[k] = assists[initial];
                }
            }
            //���ѡ��ıߵ������Ͷ��������1��֤����С�������Ѿ��γɣ��˳�ѭ��
            if (num == P - 1) {
                break;
            }
        }
    }
}

void display(struct edge minTree[]) {
    int cost = 0, i;
    printf("��С������Ϊ:\n");
    for (i = 0; i < P - 1; i++) {
        printf("%d-%d  Ȩֵ��%d\n", minTree[i].start, minTree[i].end, minTree[i].weight);
        cost += minTree[i].weight;
    }
    printf("��ȨֵΪ��%d", cost);
}

int main() {
    int i;
    struct edge edges[N], minTree[P - 1];
    for (i = 0; i < N; i++) {
        scanf("%d %d %d", &edges[i].start, &edges[i].end, &edges[i].weight);
    }
    kruskal_MinTree(edges, minTree);
    display(minTree);
    return 0;
}


