/*��׺���ʽ���ɶ���������׺���ʽû������ ��
1. ���ζ�ȡ���ʽ��
2. ����ǲ��������򽫸ò�������Ϊһ�����ѹ��ջ�У�
3. ����ǲ��������򵯳�ջ�е���������������һ�������Ĳ�������Ϊ�Һ��ӣ�
�ڶ��������Ĳ�������Ϊ���ӣ������Ըò�����Ϊ���Ķ����������������Ķ��������ѹ��ջ�С�
*/
BiTree buildTree(char *exp)
{
    BiTNode *ptr,*q;         
    Stack S; //ջ�е�Ԫ��ΪBiTNode*���� 
    char c;
    int i=0;
    c=exp[i++];
    while(c!='\0')
    {
    	ptr=(BiTNode*)malloc(sizeof(BiTNode));  
		ptr->data=c; ptr->LChild=NULL; ptr->RChild=NULL; 
        if(c=='+' || c=='-'| c=='*'| c=='/') //cΪ������� 
       	{
		    if(!IsEmpty(&S))
            {
            	Pop(&S,&q); 
                ptr->RChild=q;
            }
            if(!IsEmpty(&S))
            {
                Pop(&S,&q); 
                ptr->LChild=q;
            }
        } 
        push(&S,ptr);
        c=exp[i++];        
    }
    return ptr;
}
