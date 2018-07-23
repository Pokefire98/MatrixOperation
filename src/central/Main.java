package central;

public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Matrix m = new Matrix(2, 2);
		m.setAtIJ(0, 0, 1);
		m.setAtIJ(0, 1, 2);
		m.setAtIJ(1, 0, 3);
		m.setAtIJ(1, 1, 4);
		
		
		m.displayMatrix();
		System.out.println();
		
		Matrix n = new Matrix(2, 3);
		n.setAtIJ(0, 0, 1);
		n.setAtIJ(0, 1, 2);
		n.setAtIJ(1, 0, 3);
		n.setAtIJ(1, 1, 4);
		n.setAtIJ(1, 2, 5);
		n.setAtIJ(0, 2, 6);
		
		n.displayMatrix();
		System.out.println();
		
		Matrix c = m.transpose();
		c.displayMatrix();
		
		System.out.println(m.isSemetric());
	
	}

}
