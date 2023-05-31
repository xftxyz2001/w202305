//��׺���ʽ����������
/*
��1���ӵ�ǰ����ı��ʽdata[start...end]���ҳ����������ڡ�������ȼ���͵�һ���������
     ��Ϊ�������ĸ��ڵ㣬����¼��λ��mid
��2���ֱ𹹽��ö�������������data[start...mid-1]��������data[mid+1...end]
��3�����ص�ǰ���ڵ�
*/ 
BiTree createTree(char *data, int start, int end)
{
	// ȥ�����������
	if(data[start] == "(" && data[end] == ")"){
		start++; end--;
	}
	
	BiTree T = new BiTNode;
	int size = end-start+1;
	
	if(size <= 0) return NULL; 	
    if(size == 1){  // ����Ϊ1, ����ֱ����ΪҶ���
		T->data = data[start];
		T->lchild = T->rchild = NULL; 
		return T;		
	} 
	
	char chosen;   // ��¼ѡ�е������
	int lcount = 0, mid;  // lcount��¼������������mid��¼ѡ�������λ��
	for(int i=start; i<=end; i++){
		if(data[i] == "(") lcount++;  // ���������ڼ�¼����ƥ���Ƿ����
		if(data[i] == ")") lcount--;
			
		// isFour()�����ж��Ƿ������������, lcount==0��ʾ��㲻��������, 
		// compare()���ڱȽ�����������ȼ�.0 ��ʾ��ͬ��1��ʾ��һ�����ȼ���-1��ʾ�ڶ������ȼ��� 
		if(isFour(data[i]) && lcount==0 && compare(chosen, data[i]) != -1){
			chosen = data[i];  mid = i;
		}
	}
	T->data = chosen;
	// �����������ֱ�ֵ���ݹ���ô˺��� 
	T->lchild = createTree(data, start, mid-1);
	T->rchild = createTree(data, mid+1, end);
	return T;
	}
}
