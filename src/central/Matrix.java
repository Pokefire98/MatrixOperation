package central;

import java.util.ArrayList;

public class Matrix
{
	private int col; // y --> runs up and down 
	private int row; // x --> runs side to side 
	private double[][] matrix;
	
	public Matrix(int col, int row)
	{
		this.col = col; 
		this.row = row;
		matrix = new double[col][row];
	}
	
	public Matrix getCopy()
	{
		Matrix copy = new Matrix(col, row);
		
		for(int y = 0; y < col; y++)
		{
			for(int x = 0; x < row; x++)
			{
				copy.setAtIJ(y, x, matrix[y][x]);
			}
		}
		
		return copy;
	}
	
	public void setAtIJ(int y, int x, double val)
	{
		matrix[y][x] = val; 
	}
	
	public double getValue(int y, int x)
	{
		return matrix[y][x]; 
	}
	
	public int getCol()
	{
		return col;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public double[][] getMatrix()
	{
		return matrix;
	}
	
	public void displayithRow(int ithCol)
	{
		String ithColsPrint = "";
		for(int i = 0; i < row; i++)
		{
			if(row - 1 != i)
				ithColsPrint += matrix[ithCol][i] + " , ";
			else 
				ithColsPrint += matrix[ithCol][i];
		}
		System.out.println("[ " + ithColsPrint + " ]"); 
	}
	
	public void displayMatrix()
	{
		System.out.println(col + " x " + row + " = Matrix"); 
		for(int y = 0; y < col; y++)
		{
			displayithRow(y);
		}
	}
	
	private double[] getithRow(int ithCol)
	{
		double[] result = new double[row];
		for(int i = 0; i < row; i++)
		{
			result[i] = matrix[ithCol][i]; 
		}
		return result;
	}
	
	public Matrix transpose()
	{
		int newRow = col;
		int newCol = row;
		Matrix ans = new Matrix(newCol, newRow); 
		ArrayList<double[]> listOfCols = new ArrayList<>();
		for(int i = 0; i < col; i++)
			listOfCols.add(getithRow(i));
		
		for(int x = 0; x < newRow; x++)
		{
			double[] temp = listOfCols.get(x);
			for(int y = 0; y < temp.length; y++)
			{
				ans.setAtIJ(y, x, temp[y]);
			}
		}
		return ans; 
	}
	
	public void multiplyByScaler(double scaler)
	{
		for(int y = 0; y < col; y++)
		{
			for(int x = 0; x < row; x++)
			{
				matrix[y][x] = matrix[y][x] * scaler;
			}
		}
	}
	
	public void addScaler(double scaler)
	{
		for(int y = 0; y < col; y++)
		{
			for(int x = 0; x < row; x++)
			{
				matrix[y][x] = matrix[y][x] + scaler;
			}
		}
	}
	
	public void addMatrix(Matrix b)
	{
		int bRow = b.getRow();
		int bCol = b.getCol();
		if(row == bRow && col == bCol)
		{
			double[][] temp = b.getMatrix();

			for (int y = 0; y < col; y++)
			{
				for (int x = 0; x < row; x++)
				{
					matrix[y][x] = matrix[y][x] + temp[y][x];
				}
			}
		}
		else 
		{
			System.err.println("You cannot add matracies of differing sizes!"); 
			System.err.println("The matrix will not be changed"); 
		}
	}
	
	public void subtractMatrixAB(Matrix b) 
	{
		int bRow = b.getRow();
		int bCol = b.getCol();
		if(row == bRow && col == bCol)
		{
			double[][] temp = b.getMatrix();

			for (int y = 0; y < col; y++)
			{
				for (int x = 0; x < row; x++)
				{
					matrix[y][x] = matrix[y][x] - temp[y][x];
				}
			}
		}
		else 
		{
			System.err.println("You cannot subtract matracies of differing sizes!"); 
			System.err.println("The matrix will not be changed"); 
		}
	}
	
	public void subtractMatrixBA(Matrix b) 
	{
		int bRow = b.getRow();
		int bCol = b.getCol();
		if(row == bRow && col == bCol)
		{
			double[][] temp = b.getMatrix();

			for (int y = 0; y < col; y++)
			{
				for (int x = 0; x < row; x++)
				{
					matrix[y][x] = temp[y][x] - matrix[y][x];
				}
			}
		}
		else 
		{
			System.err.println("You cannot subtract matracies of differing sizes!"); 
			System.err.println("The matrix will not be changed"); 
		}
	}
	
	public boolean isSame(Matrix a)
	{
		boolean same = true;
		for (int y = 0; y < col; y++)
		{
			for (int x = 0; x < row; x++)
			{
				if(this.getValue(y, x) != a.getValue(y, x))
				{
					same = false;
					break;
				}
			}
		}
		return same;
	}
	
	public boolean isSemetric()
	{
		boolean symetry = false;
		Matrix b = this.transpose();
		b.transpose();
		if(this.isSame(b))
			symetry = true;
		return symetry;
	}
	
	
}
