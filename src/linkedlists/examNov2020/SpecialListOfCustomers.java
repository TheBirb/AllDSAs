package linkedlists.examNov2020;

import org.w3c.dom.Node;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
/**
 * COMMENTS ABOUT YOUR SOLUTION
 * Include here any comments, explanations and answers related to the questions.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class SpecialListOfCustomers implements Iterable<NodeCustomer> {
	int[] arrayIds;
	NodeCustomer firstCust;
	NodeCustomer lastCust;
	Customer[] arrayCust;

	public SpecialListOfCustomers() {
	}

	/**
	 * THIS QUESTION IS OPTIONAL
	 * @ params an array of ids (integers)
	 * @ return the index for the correct position of the last customer in the
	 * array
	 */
	public int arraySomeWaySorted(int[] severalIds) {
		// split and "semi-sort" the string 
		return 0;
	}


	/**
	 * The default ordering is by ascending surname and descending by cash
	 * Simply insert one element at a time in its correct position
	 * Create the double linked list in order. 
	 * @param c  is a customer
	 */
	public void add2listInOrder(Customer c) {
		NodeCustomer insert= new NodeCustomer();
		insert.c=c;
		if(firstCust==null){
			firstCust=insert;
			lastCust=insert;
		}else{
			NodeCustomer actual=firstCust;
			StringComparator comp= new StringComparator();
			int cmp=0;
			while(actual!=null){
				cmp=comp.compare(insert.c.surname, actual.c.surname);
				if(cmp<=0){
					break;
				}else{
					actual=actual.next;
				}
			}
			if(cmp>0){
				if(actual==null){
					lastCust.next=insert;
					insert.previous=lastCust;
					lastCust=insert;
				}
			}else if(cmp<0){
				if(actual.c.surname.equals(firstCust.c.surname)){
					insert.next=firstCust;
					firstCust.previous=insert;
					firstCust=insert;
				}else{
					insert.next=actual;
					insert.previous=actual.previous;
					actual.previous.next=insert;
					actual.previous=insert;
				}
			}else{
				while(cmp==0 && actual!=null){
					cmp=comp.compare(insert.c.surname, actual.c.surname);
					if(cmp!=0 || insert.c.cash>actual.c.cash){
						break;
					}else{
						actual=actual.next;
					}
				}
				if(actual==null){
					lastCust.next=insert;
					insert.previous=lastCust;
					lastCust=insert;
				}else if(cmp!=0){
					insert.next=actual;
					insert.previous=actual.previous;
					actual.previous.next=insert;
					actual.previous=insert;
				}else{
					if(actual.previous==null){
						insert.next=actual;
						actual.previous=insert;
						firstCust=insert;
					}else{
						insert.next=actual;
						insert.previous=actual.previous;
						actual.previous.next=insert;
						actual.previous=insert;
					}
				}
			}
		}
	}

	public void toMyString(){
		NodeCustomer actual=firstCust;
		String out="[";
		while(actual!=null){
			System.out.println("[Surname: "+actual.c.surname+"  "+"Cash: "+actual.c.cash+"]");
			actual=actual.next;
		}

	}

	/*
	 * We only define one iterator for our list and it should
	 * use the reverse order of the list*/
	@Override
	public Iterator<NodeCustomer> iterator() {
		NodeCustomer actual = lastCust;
		return new ReverseDoubleLinkedListIterator(lastCust);
	}




	public static void main(String[] args) {
		// create an initial array of ids 
		String ids = "45  23  15 9 2 20 11  12";
		String[] string_ids = ids.split("\\s+");
		int[] int_ids = new int[string_ids.length];
		for (int i = 0; i < string_ids.length; i++) {
			int_ids[i] = Integer.parseInt(string_ids[i]);
			//			System.out.println(int_ids[i]);
		}
		SpecialListOfCustomers lcs = new SpecialListOfCustomers();
		int theindex = lcs.arraySomeWaySorted(int_ids);

		// skeleton for reading the file of customers  
		// TO DO complete as needed 
		try {
			Scanner input2program = new Scanner(new File("src/linkedlists/examNov2020/customers1.txt"));
			// read each line and do whatever you wish to do with the file 
			while (input2program.hasNext()) {
				String line1 = input2program.nextLine();
				String[] strs = line1.trim().split("\\s+");
				int cust_id = Integer.parseInt(strs[0]);
				String surname = strs[1];
				String name = strs[2];
				int cash = Integer.parseInt(strs[3]);
				System.out.println(surname);
				Customer c= new Customer();
				c.cash=cash;
				c.name=name;
				c.surname=surname;
				c.cust_id=cust_id;
				lcs.add2listInOrder(c);

			}
			lcs.toMyString();
			input2program.close();
		} catch (Exception e) {
		} finally {
		}

	}

}
