#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <conio.h>
#define p printf
#define s scanf
/* initialization / global declaration */
/* structures */
typedef struct{
		int id;
		char name[20];
		char type[30];
}luxuryObj;
typedef struct{
		int id;
		char name[20];
}plants;
typedef struct{
		int id;
		char name[20];
}animals;
typedef struct{
		int id;
		char name[20];
}universe;
typedef struct{
		int id;
		int age;
		char firstname[20];
		char lastname[20];
}people;
luxuryObj lo[20];
plants pl[20];
animals anml[20];
universe unvrs[20];
people pple[20];
/* end of struct */
/* user-defined function declaration */
int arraysortSys(int runFunc);
int enrollmentSys(int runFunc, int totalPeople);
int enrollmentSys_Add(int totalPeople);
int enrollmentSys_Search(int totalPeople);
int arraySum(int *arr, int index);
void flushinput();
void removeNewline(char line[]);
/* end of user-def func declaration */
/* end of initial/global decl */
/* Main funct */
int main(){
	int endProgram = 0, option, totalPeople = 0, i;
	int array[4];
	while(endProgram != 1){
		p("Activity 1 | Chapter 2 Activities by Selwyn Rollorata\n");
		p("Programs:\n");
		p("[1] Array Sorting\n");
		p("[2] Enrollment System\n");
		p("[3] Array Sum (Pointer)\n");
		p("[.] Close Program\n");
		p("Option: ");
		option = getch();
		option = option - 48; /* gets the expected number from the ascii code, ex. inputed number "1", from ascii char it is 49. */
		if(option == 1){
			system("cls");
			arraysortSys(option);
			system("cls");
		} else if(option == 2){
			system("cls");
			totalPeople = enrollmentSys(option, totalPeople);
			system("cls");
		} else if(option == 3){
			system("cls");
			p("Activity 1 | Chapter 2 Activities by Selwyn Rollorata\n");
			p("\n----------------------------\n");
			p(" Array Sum of inputed 4 Digit number\n");
			for(i = 0; i < 4; i++){
				p("  input for array[%d]: ", i); 
				s("%d", &array[i]);
			}
			system("cls");
			arraySum(array, 4);
			system("cls");
		} else {
			p("\n\n[..] Closing Program ....");
			endProgram = 1;
		}
	}
	return 0; }
/* end of Main funct*/
/* user-defined function definition */
int arraysortSys(int runFunc){
	int numCount, array[20], temp, i, j, a, x;
	p("Activity 1 | Chapter 2 Activities by Selwyn Rollorata\n");	
	p("\n----------------------------\n");
	p("Array Sorting | Decreasing order\n");
	p("--How many number do you want to enter?: ");
	s("%d", &numCount);
	for(a = 0; a < numCount; a++){
		p("  -Enter num%d: ", a + 1);	
		s("%d", &array[a]);
		flushinput(); 
	}
	/* ------- algo for sorting -------*/
	for(i = 0; i < numCount; i++){
		for(j = 0; j < numCount; j++){
			if(array[i] > array[j]){
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
	}
	/* ------- display sort result -------*/
	p("\n----Result----- ");
	for(x = 0; x < numCount; x++)
		p("\n  array[%d]: %d", x ,array[x]);
	p("\n\npress any key to close Array Sorting...");
	runFunc = getch();
	return runFunc;}
int enrollmentSys(int runFunc, int totalPeople){
	int endEnrollsys = 0, option = 0, pause;
	while (endEnrollsys != 1){
		p("Activity 1 | Chapter 2 Activities by Selwyn Rollorata\n");
		p("\n----------------------------\n");
		p("Enrollment System | People \n");
		p("[1] Add\n");
		p("[2] Search\n");
		p("[.] Close Enrol\n");
		p("Input: ");
		option = getch();
		option = option - 48;
		if(option == 1){
			system("cls");
			totalPeople = enrollmentSys_Add(totalPeople);
			system("cls");
		} else if(option == 2){
			if(totalPeople == 0){
				p("\n\nYou didn't add a person yet. No one is here\n");
				p("Press any key to return: ");
				pause = getch();
			} else {
				system("cls");
				totalPeople = enrollmentSys_Search(totalPeople);
			}
			system("cls");
		} else {
			p("\n\nClosing Enrollment System..");
			endEnrollsys = 1;
		}
	}
	p("\npress any key to close Enrollment System...");
	runFunc = getch();
	return totalPeople;	}
int enrollmentSys_Add(int totalPeople){
	int endAdd = 0;
	while(endAdd != 1){
		p("Activity 1 | Chapter 2 Activities by Selwyn Rollorata\n");
		p("\n----------------------------\n");
		p("Enrollment System | People\n");
		p("--Add\n");
		p("  First Name: "); fgets(pple[totalPeople].firstname, sizeof(pple[totalPeople].firstname), stdin); 
		p("  Last Name: "); fgets(pple[totalPeople].lastname, sizeof(pple[totalPeople].lastname), stdin); 
		p("  Age: "); s("%d", &pple[totalPeople].age);
		pple[totalPeople].id = totalPeople + 1;
		totalPeople++;
		p("\n\n--\n[0] Add another person\n[1] Close\n:");
		endAdd = getch();
		endAdd -= 48;
		system("cls");
		flushinput();
	}
	return totalPeople; }
int enrollmentSys_Search(int totalPeople){
	int i, endSearch = 0, resultCount = 0;
	char search[20];
	while(endSearch != 1){
		p("Activity 1 | Chapter 2 Activities by Selwyn Rollorata\n");
		p("\n----------------------------\n");
		p("Enrollment System | People\n");
		p("--Search\n");
		p("  Input: ");
		fgets(search, sizeof(search), stdin);
		for(i = 0; i < totalPeople; i++){
			if((strcmp(search, pple[i].firstname)) == 0){
				p("\n  Id: %d    Age: %d \n", pple[i].id, pple[i].age);
				p("  *Firstname: %s", pple[i].firstname);
				p("  Lastname: %s \n", pple[i].lastname);
				resultCount++;
			} 
			if((strcmp(search, pple[i].lastname)) == 0){
				p("\n  Id: %d    Age: %d \n", pple[i].id, pple[i].age);
				p("  Firstname: %s", pple[i].firstname);
				p("  *Lastname: %s \n", pple[i].lastname);
				resultCount++;
			}
		}
		p("\n  Result Found: %d\n", resultCount);
		p("[0] Search More\n");
		p("[1] Close\n:");
		resultCount = 0;
		endSearch = getch();
		endSearch -= 48;
		system("cls");
	}
	return totalPeople; }
int arraySum(int *arr, int index){
	int i, total = 0, pause;
	p("Activity 1 | Chapter 2 Activities by Selwyn Rollorata\n");
	p("\n----------------------------\n");
	p("Sum of inputed 4 Digit number\n");
	p("Result: \n");
	for (i = 0; i < index; i++){
		p("  array[%d]: %d\n", i, arr[i]);
		total += arr[i];
	}
	p("Sum: %d\n", total);
	p("Press any key to close...");
	pause = getch();
	return *arr; }
void flushinput(){
	char ch;
	if((ch = getchar()) != '\n' && ch != EOF); }
void removeNewline(char line[]){
	int newline = strlen(line) - 1;
	if (line[newline] == '\n')
		line[newline] = '\0';
	}
/* end of user-defined function */