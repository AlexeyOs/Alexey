package ru.osetsky;

public class Turn {
	public int back (){
	int[] values = new int[5];
	for (int index=0; index<5; index++){
	values[index] = index; // ���������� ������� �������
	}
	for (int i = 0; i < values.length / 2; i++) {
	int perestanovka = values[i];
	values[i] = values[values.length - 1 - i];  	// ����������������, ������� ������������� 
	values[values.length - 1 - i] = perestanovka;	// ������ � �������� �������
	return values;  // �� ���������� ������! ������ �����
	}				// ����������, ��� �� ���������� ��-�� ����, ��� ������ ��������� ���
}

}