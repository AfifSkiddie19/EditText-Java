package src;

import java.util.Scanner;

public class EditText {

	class Node
	{
		String huruf;
		Node next;
		Node prev;
		
		public void Insert(String Huruf)
		{
			this.huruf = huruf;
		}
		public String getHuruf()
		{
			return this.huruf;
		}
	}
	
	Node head=null, tail=null, baru, tmp, cetak;
	Node del, a, b=null;
	
	public void add()
	{
		System.out.print("Enter Character: ");
		Scanner input = new Scanner (System.in);
		
		String huruf;
		huruf = input.next();
		baru = new Node();
		baru.Insert(huruf);
		baru.next = null;
		
		if(head==null)
		{
			head=baru;
			tail=baru;
			tmp=baru;
			head.next=null;
			b=new Node();
			head.prev=b;
			b.next=head;
			b.prev=null;
		}
		
		else if(tmp.next==null)
		{
			tmp.next=baru;
			tail=baru;
			tail.prev=tmp;
			tmp=baru;
		}
		else if(tmp.prev==null)
		{
			head.prev=baru;
			b.next=baru;
			baru.prev=b;
			baru.next=head;
			head=baru;
			tmp=head;
			b.prev=null;
		}
		else
		{
			a=tmp.next;
			tmp.next=baru;
			a.prev=baru;
			baru.next=a;
			baru.prev=tmp;
			tmp=baru;
		}
		System.out.println("");
	}
	
	void delete()
	{
		if(tmp==a)
		{
			System.out.print("Stuck is Empty...");
		}
		else if(head==tail)
		{
			del=head;
			tmp=b;
			System.out.print("\nCharacter "+del.getHuruf()+"Was Deleted...\n");
			del=null;
			head=null;
		}
		else if(tmp.next==null)
		{
			tail=tail.prev;
			del=tmp;
			System.out.print("\nCharacter "+del.getHuruf()+"Was Deleted...\n");
			del=null;
			tail.next=null;
		}
		else if(tmp==head)
		{
			del=head;
			tmp=b;
			head=head.next;
			System.out.print("Character "+del.getHuruf()+"Was Deleted...\n");
			del=null;
			tmp.next=head;
			head.prev=b;
		}
		else
		{
			del=tmp;
			tmp=tmp.prev;
			del.next.prev=tmp;
			tmp.next=del.next;
			System.out.print("\nCharacter "+del.getHuruf()+"Was Deleted...\n");
			del=null;
		}
		System.out.print("\nPress Any Key For Continue...");
		Scanner pause = new Scanner(System.in);
		pause.nextLine();
	}
	
	
	void ShiftL()
	{
		if(tmp==b)
		{
			System.out.print("\nPointer Shift Left...");
		}
		else
		{
			System.out.print("\nPointer is on the Left...");
			tmp=tmp.prev;
		}
		System.out.print("\nPress Any Key To Continue...");
		Scanner pause = new Scanner(System.in);
		pause.nextLine();
	}
	
	void ShiftR()
	{
		if(tmp==tail)
		{
			System.out.print("\nPointer Shift Right...");
		}
		else
		{
			System.out.print("\nPointer is on the Right...");
			tmp=tmp.next;
		}
		System.out.print("\nPress Any Key To Continue...");
		Scanner pause = new Scanner(System.in);
		pause.nextLine();
	}
	
	void print()
	{
		if(head!=null)
		{
			cetak=head;
			while(cetak!=null)
			{
				System.out.print(cetak.getHuruf());
				cetak=cetak.next;
			}
		}
		else
		{
			System.out.print("\nEmpty\n");
		}
		System.out.print("\nPress Any Key To Continue...");
		Scanner pause = new Scanner(System.in);
		pause.nextLine();
	}
	
	
	public static void main(String[] args) {

		EditText akses = new EditText();
		int n,i,ch;
		
		System.out.println("\t\t...Edit Text Operation...");
		System.out.print("Entery Your Input : ");
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		for(i=0; i<n; i++)
		{
			System.out.print("\nMenu\n");
			System.out.print("1. Add\n");
			System.out.print("2. Shift Left\n");
			System.out.print("3. Shift Right\n");
			System.out.print("4. Delete\n");
			System.out.print("5. Print\n");
			System.out.print("6. Exit\n");
			System.out.print("Enter Your Choose : ");
			Scanner pil = new Scanner(System.in);
			ch = pil.nextInt();
			switch(ch)
			{
			case 1:
				akses.add();
				break;
			case 2:
				akses.ShiftL();
				break;
			case 3:
				akses.ShiftR();
				break;
			case 4:
				akses.delete();
				break;
			case 5:
				akses.print();
				break;
			case 6:
				System.exit(0);
				default:System.out.print("The Choosen Just 6..");
			}
		}
	}

}
