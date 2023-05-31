/*�������к��������зֱ�洢��pre[]��ino[]�����У�
i��j���������е��±�磬m��n���������е��±�磻
����ֵΪ����õĶ������ĸ��ڵ�ָ��*/
BiTree CrtBiTree(char pre[],char in[],int i,int j,int m,int n)
{
    int k;
    BiTNode *bt;

    if(i>j) return NULL; //����Ϊ�գ����ؿ�ָ��

    //�����Ϊpre[i]��������������Ѱ�Ҹ�����λ�ã�
    k=m;
    while(k<n)
    {
         if(in[k]==pre[i]) break;
         k++;
    }

    if(k>n)   return NULL;  //��������δ�ҵ�����㣬���в���ȷ

    bt=(BiTNode*)malloc(sizeof(BiTNode));
    bt->data=pre[i];
    if(k==m) //bt��������Ϊ��
        bt->LChild=NULL;
    else
        bt->LChild=CrtBiTree(pre,in,i+1,i+k-m,m,k-1); //�ݹ齨��������

    if(k==n)
        bt->RChild=NULL;  //bt��������Ϊ��
    else
        bt->RChild=CrtBiTree(pre,in,i+k-m+1,j,k+1,n);  //�ݹ齨��������

    return bt;
}
