// �����������е�ÿ���������˫��ָ�� 
//���򡢺������򡢲������ 
void setParent(TriTree tt)
{
	if(tt==NULL) return;
		
	if(tt->LChild) tt->LChild->parent=tt;
	if(tt->LChild) tt->LChild->parent=tt;
	
	setParent(tt->LChild);
	setParent(tt->RChild);
} 

//��ֵh�Ĳ��Ϊ0 
//���򡢺������򡢲������ 
int wpl=0;
void calWPL(BiTree bt,int h)
{
	if(bt==NULL) return;
	
	if(bt->LChild==NULL  && bt->RChild==NULL) 
		wpl += wpl+bt->data*h;
	
	calWPL(bt->LChild,h+1);	
	calWPL(bt->RChild,h+1);	
}

//���϶��¡����ҵ���Ĳ�α���
void layer(BiTree bt) 
{
	Queue    Q;
    BiTree  p; 
    
    InitQueue(&Q)�� 
    if(bt==NULL) return;  
    EnterQueue(&Q, bt);   

    while (!IsEmpty(&Q))   
    { 
	    DeleteQueue(&Q, &p); 
	    visit(p->data);
	    if(p-> RChild)  EnterQueue(&Q, p->RChild); 
	    if(p-> LChild)  EnterQueue(&Q, p->LChild); 
    }  
}

//˳��洢���������
void LRD(ElemType A[],int i,int n)
{
	if(i>n) return;
	
	LRD(A,2*i,n);
	LRD(A,2*i+1,n);
	if(A[i]!=nullElem) visit(A[i]);
} 

//�ж�ĳ��˳��洢����ȫ�������Ƿ�Ϊ�����
int isMaxHeap(ElemType A[],int n)
{
	int i;
	
	for(i=1;i<=n/2;i++)
	{
		if(A[i]<A[2*i]) return false;
		if(2*i+1<n && A[i]<A[2*i+1]) return false; 
	}	
	return true; 
}

//����ÿ����㣬�����Ƿ���϶ѵ�Ҫ�� ; DLR,LDR,LRD,����������� 
int isMaxHeap(ElemType A[],int i,int n)
{	
	static int tag=1;
	if(i>n) return 0;
	
	if(2*i<=n && A[i]<A[2*i])  tag=0;  //�����ӱ� 
	if(2*i+1<=n && A[i]<A[2*i+1]) tag=0; //���Һ��ӱ� 
	
	isMaxHeap(A,2*i,n);
	isMaxHeap(A,2*i+1,n);
	return tag;
}

//����˼���ж��Ƿ�Ϊ�� 
int isMaxHeap(ElemType A[],int i,int n)
{
	if(i>n) return 1;  //�����Ƕ� 	
	if(2*i>n) return 1; //A[i]��Ҷ�ӣ��Ƕ� 
	
	//�϶�����Ҷ�ӽ�� 
	int tag=1; 
	if(2*i<=n && A[i]<A[2*i])  tag=0;  //�����ӱ� 
	if(2*i+1<=n && A[i]<A[2*i+1]) tag=0; //���Һ��ӱ� 
	
	return tag && isMaxHeap(A,2*i,n) && isMaxHeap(A,2*i+1,n);		
}




